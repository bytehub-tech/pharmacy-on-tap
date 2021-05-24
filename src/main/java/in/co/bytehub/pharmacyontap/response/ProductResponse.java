package in.co.bytehub.pharmacyontap.response;

import in.co.bytehub.pharmacyontap.model.ProductSearch;

import java.util.List;

public class ProductResponse {
    private List<ProductSearch> products;

    public List<ProductSearch> getProducts() {
        return products;
    }

    public ProductResponse setProducts(List<ProductSearch> products) {
        this.products = products;
        return this;
    }
}
