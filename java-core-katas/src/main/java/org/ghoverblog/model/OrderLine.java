package org.ghoverblog.model;

import java.math.BigDecimal;

public class OrderLine {

    private final Product product;
    private int quantity;

    public OrderLine(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
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
    public BigDecimal getLineTotale() {
        return this.product.getPrice()
                .multiply(BigDecimal.valueOf(this.quantity));
    }

}
