package org.ghoverblog.model;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class OrderLine {
    private final UUID id = UUID.randomUUID();
    private final Product product;
    private int quantity;

    public OrderLine(Product product, int quantity) {
        this.product = Objects.requireNonNull(product, "Le produit ne doit pas être null");
        if (quantity < 0) throw new IllegalArgumentException("La quantité doit être >= 0");
        this.quantity = quantity;
    }

    public UUID getId() {
        return id;
    }

    Product getProduct() {
        return this.product;
    }


    void changeQuantity(int quantity) {
        if (quantity < 0) throw new IllegalArgumentException("Quantity must be >= 0");
        this.quantity = quantity;
    }

    int getQuantity() {
        return this.quantity;
    }

    /**
     * Calcule le prix d'une ligne
     * <p>Le total correspond au prix unitaire du produit multiplié
     * par la quantité commandée.</p>
     *
     * @return montant total de la ligne, en {@link BigDecimal}
     * (non nul, valeur calculée, non stockée)
     */
    BigDecimal getLineTotale() {
        return this.product.getPrice()
                .multiply(BigDecimal.valueOf(this.quantity));
    }

}
