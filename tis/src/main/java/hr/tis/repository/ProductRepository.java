package hr.tis.repository;

import hr.tis.model.PopularProduct;
import hr.tis.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for managing products.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    /**
     * Retrieves products by code and name containing specified values.
     *
     * @param code The code to search for.
     * @param name The name to search for.
     * @return The list of products matching the criteria.
     */
    List<Product> findByCodeContainingIgnoreCaseAndNameContainingIgnoreCase(String code, String name);

    /**
     * Retrieves products by code containing specified value.
     *
     * @param code The code to search for.
     * @return The list of products matching the criteria.
     */
    List<Product> findByCodeContainingIgnoreCase(String code);

    /**
     * Retrieves products by name containing specified value.
     *
     * @param name The name to search for.
     * @return The list of products matching the criteria.
     */
    List<Product> findByNameContainingIgnoreCase(String name);

    /**
     * Retrieves all products.
     *
     * @return The list of all products.
     */
    List<Product> findAll();

    /**
     * Retrieves the top 3 popular products based on average ratings.
     *
     * @return The list of top 3 popular products.
     */
    @Query("SELECT new hr.tis.model.PopularProduct(p.name, AVG(r.rating)) " +
            "FROM Product p " +
            "JOIN Review r ON p.id = r.product.id " +
            "GROUP BY p.name " +
            "ORDER BY AVG(r.rating) DESC " +
            "LIMIT 3")
    List<PopularProduct> findTop3ByOrderByAverageRatingDesc();
}