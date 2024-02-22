package hr.tis.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PopularProduct {
    @Id
    private String name;
    private double averageRating;

    public PopularProduct(String name, double averageRating) {
        this.name = name;
        this.averageRating = averageRating;
    }

    public PopularProduct() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

}
