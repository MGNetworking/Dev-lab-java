package org.ghoverblog.model;

import java.math.BigDecimal;
import java.util.*;

/**
 * Cette classe permet de créer une commande
 */
public class Order {
    private final UUID id;
    private final Date createDate = new Date();
    private final List<OrderLine> orderLines;
    private Status status = Status.CREATED;
    private BigDecimal totalPrice = BigDecimal.ZERO;

    public Order(String id, List<OrderLine> orderLines) {
        Objects.requireNonNull(id, "l'id order ne peux être null");
        Objects.requireNonNull(orderLines, "La liste de produit est null");

        if (orderLines.isEmpty()) {
            throw new IllegalArgumentException("La liste de produit est vide");
        }

        this.id = UUID.fromString(id);
        this.orderLines = orderLines;
        this.calculateTotalPrice();

    }

    public UUID getId() {
        return id;
    }

    public Date getDateCreated() {
        return new Date(this.createDate.getTime());
    }

    public Status getStatus() {
        return this.status;
    }

    public void updateStatus(Status status) {
        this.status = status;
    }

    public BigDecimal getTotalPrice() {
        return this.totalPrice;
    }

    public void changeQuantityLine(Product product, int quantity) {
        Objects.requireNonNull(product, "Le produit ne doit pas être null");
        if (quantity <= 0) {
            throw new IllegalArgumentException("La quantité doit être supérieure a 0");
        }
        for (OrderLine line : this.orderLines) {
            if (line.getProduct().getId().equals(product.getId())) {
                line.changeQuantity(quantity);
                break;
            }
        }
    }

    public int getQuantityProduct(Product product) {

        Objects.requireNonNull(product, "Le produit doit être présent");

        for (OrderLine line : this.orderLines) {
            if (line.getProduct().getId().equals(product.getId())) {
                return line.getQuantity();
            }
        }
        return 0;
    }

    /**
     * Permet de calcule de totale de la commande
     */
    public void calculateTotalPrice() {

        this.totalPrice = this.orderLines
                .stream()
                .map(OrderLine::getLineTotale)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

    }


}
