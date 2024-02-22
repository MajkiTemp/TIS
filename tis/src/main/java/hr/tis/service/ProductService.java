package hr.tis.service;

import hr.tis.model.PopularProduct;
import hr.tis.model.Product;
import hr.tis.model.ServiceResult;
import hr.tis.repository.ProductRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Service layer for managing products.
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private SharedService sharedService;
    ServiceResult serviceResult;
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();


    /**
     * Creates a new product.
     *
     * @param product The product to create.
     * @return The service result.
     */
    public ServiceResult createProduct(Product product) {

        try {
            Set<ConstraintViolation<Product>> violations = validator.validate(product);
            if (!violations.isEmpty()) {
                String message = "[";
                for (ConstraintViolation<Product> violation : violations) {
                    message += violation.getMessage() + "],";
                }
                return serviceResult = new ServiceResult(false, message);
            }
            product.setPriceUSD(sharedService.convertEURtoUSD(product.getPriceEUR()));
            productRepository.save(product);
            serviceResult = new ServiceResult(true, "Saved product");

        } catch (Exception e) {
            return serviceResult = new ServiceResult(false, e.getMessage());
        }

        return serviceResult;
    }



    /**
     * Retrieves products based on optional filters.
     *
     * @param codeFilter The code filter.
     * @param nameFilter The name filter.
     * @return The service result containing filtered products.
     */
    public ServiceResult getProductsByFilters(String codeFilter, String nameFilter) {
        codeFilter = codeFilter != null ? codeFilter.toLowerCase() : null;
        nameFilter = nameFilter != null ? nameFilter.toLowerCase() : null;
        List<Product> returnList;

        try {
            if (codeFilter != null && nameFilter != null) {
                returnList = productRepository.findByCodeContainingIgnoreCaseAndNameContainingIgnoreCase(codeFilter, nameFilter);
            } else if (codeFilter != null) {
                returnList = productRepository.findByCodeContainingIgnoreCase(codeFilter);
            } else if (nameFilter != null) {
                returnList = productRepository.findByNameContainingIgnoreCase(nameFilter);
            } else {
                returnList = productRepository.findAll();
            }
        } catch (Exception e) {
            return serviceResult = new ServiceResult(false, e.getMessage());
        }
        return new ServiceResult(true, "ProductsByFilters", returnList);
    }

    /**
     * Retrieves the top 3 popular products based on average ratings.
     *
     * @return The list of popular products.
     */
    public List<PopularProduct> getPopularProducts() {
        return productRepository.findTop3ByOrderByAverageRatingDesc();
    }
}




