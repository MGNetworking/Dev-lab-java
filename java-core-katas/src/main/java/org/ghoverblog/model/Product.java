package org.ghoverblog.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
import java.util.UUID;


public class Product {

    private final UUID id;
    private final String name;
    private BigDecimal price;

    public Product(UUID id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.setPrice(price);
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Prix en euros
     * Scale = 2
     * Arrondi : HALF_UP
     */
    public void setPrice(BigDecimal price) {

        Objects.requireNonNull(price, "Le prix ne peux pas être null");
        if (price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Le prix doit être strictement positif");
        }

        try {
            // Normalisation à 2 décimales
            this.price = price.setScale(2, RoundingMode.HALF_UP);
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("Le prix doit avoir maximum 2 décimales", e);
        }

    }
}
