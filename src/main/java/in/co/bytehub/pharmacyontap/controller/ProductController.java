package in.co.bytehub.pharmacyontap.controller;

import in.co.bytehub.pharmacyontap.model.Product;
import in.co.bytehub.pharmacyontap.response.ProductResponse;
import in.co.bytehub.pharmacyontap.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/.search/{term}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse searchProducts(@PathVariable String term) {
        productService.findProducts(term);
        return new ProductResponse().setProducts(productService.findProducts(term));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

}
