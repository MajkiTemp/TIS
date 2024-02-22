package hr.tis.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 15)
    @Min(value = 15, message = "Code should not be less than 15")
    @Max(value = 15, message = "Code should not be greater than 15")
    private String code;

    private String name;

    @Column(name = "price_eur")
    private double priceEUR;

    @Column(name = "price_usd")
    private double priceUSD;


    public Product(String code, String name, double priceEUR, double priceUSD, String description) {
        this.code = code;
        this.name = name;
        this.priceEUR = priceEUR;
        this.priceUSD = priceUSD;
        this.description = description;
    }

    public Product() {

    }

    public Long getId() {
        return id;
    }

    private String description;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPriceEUR() {
        return priceEUR;
    }

    public void setPriceEUR(double priceEUR) {
        this.priceEUR = priceEUR;
    }

    public double getPriceUSD() {
        return priceUSD;
    }

    public void setPriceUSD(double priceUSD) {
        this.priceUSD = priceUSD;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
