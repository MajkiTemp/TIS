package hr.tis.controller;

import hr.tis.model.PopularProduct;
import hr.tis.model.Product;
import hr.tis.model.ServiceResult;
import hr.tis.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing products.
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * Creates a new product.
     *
     * @param product The product to create.
     * @return The response entity with the result of the operation.
     */
    @PostMapping("/create")
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
        // Product product_T = new Product("ABC123XYZ456789", "Test proizvod", 10.5, 8,"Ovo je testni proizvod.");
        ServiceResult serviceResult = productService.createProduct(product);
        return new ResponseEntity<>(serviceResult.toString(), HttpStatus.OK);
    }

    /**
     * Retrieves products based on optional filters.
     *
     * @param codeFilter The code filter.
     * @param nameFilter The name filter.
     * @return The response entity with the result of the operation.
     */
    @GetMapping("/getByFilter")
    public ResponseEntity<String> getProductsByFilters(@RequestParam(required = false) String codeFilter, @RequestParam(required = false) String nameFilter) {
        ServiceResult serviceResult = productService.getProductsByFilters(codeFilter, nameFilter);
        return new ResponseEntity<>(serviceResult.toString(), HttpStatus.OK);
    }

    /**
     * Retrieves the top 3 popular products.
     *
     * @return The list of top 3 popular products.
     */
    @GetMapping("/getPopularProducts")
    public List<PopularProduct> getPopularProducts() {
        return productService.getPopularProducts();
    }
}