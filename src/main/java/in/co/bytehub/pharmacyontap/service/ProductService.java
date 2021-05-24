package in.co.bytehub.pharmacyontap.service;

import in.co.bytehub.pharmacyontap.model.Product;
import in.co.bytehub.pharmacyontap.model.ProductSearch;
import in.co.bytehub.pharmacyontap.repo.PharmaProductRepo;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilders;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final PharmaProductRepo pharmaProductRepo;
    private final ElasticsearchRestTemplate elasticsearchRestTemplate;

    public ProductService(PharmaProductRepo pharmaProductRepo,
                          ElasticsearchRestTemplate elasticsearchRestTemplate) {
        this.pharmaProductRepo = pharmaProductRepo;
        this.elasticsearchRestTemplate = elasticsearchRestTemplate;
    }

    public List<ProductSearch> findProducts(String term) {
        Query query = new NativeSearchQueryBuilder()
                .withQuery(
                        QueryBuilders.queryStringQuery(term + "*")
                                .field("salts")
                                .field("name")
                                .type(MultiMatchQueryBuilder.Type.BEST_FIELDS)
                )
                // Filter out Expired pharma product
                .withFilter(
                        QueryBuilders.boolQuery()
                                .should(QueryBuilders.boolQuery().mustNot(QueryBuilders.existsQuery("expDate")))
                                .should(QueryBuilders.rangeQuery("expDate").gt(LocalDate.now()))

                )


                // for sorting - text field not efficient
                .withSort(SortBuilders.fieldSort("name.keyword"))
                .withSort(SortBuilders.fieldSort("expDate"))
                .withMaxResults(10)
                .build();
        SearchHits<ProductSearch> searchHits = elasticsearchRestTemplate.search(query, ProductSearch.class);
        return searchHits.stream().map(SearchHit::getContent).collect(Collectors.toList());

    }

    @Transactional
    public void addProduct(Product product) {
        pharmaProductRepo.save(product);
        ProductSearch productSearch = new ProductSearch();
        productSearch.setId(product.getId());
        productSearch.setName(product.getName());
        productSearch.setSalts(product.getSalts());
        productSearch.setBatch(product.getBatch());
        productSearch.setCp(product.getCp());
        productSearch.setMp(product.getMp());
        productSearch.setExpDate(product.getExpDate());
        productSearch.setType(product.getType());
        productSearch.setQuantity(product.getQuantity());
        elasticsearchRestTemplate.save(productSearch);
    }

}
