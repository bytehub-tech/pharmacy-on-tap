package in.co.bytehub.pharmacyontap.repo;

import in.co.bytehub.pharmacyontap.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface PharmaProductRepo extends PagingAndSortingRepository<Product, Long> {
}
