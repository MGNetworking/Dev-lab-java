package org.ghoverblog.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
import java.util.UUID;


public class Product {

    private final UUID id = UUID.randomUUID();
    private final String name;
    private BigDecimal price;

    public Product(String name, BigDecimal price) {
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

        this.price = price.setScale(2, RoundingMode.HALF_UP);

    }
}
