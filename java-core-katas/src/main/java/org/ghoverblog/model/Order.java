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
        Objects.requireNonNull(orderLines, "La list de produit est null");

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
