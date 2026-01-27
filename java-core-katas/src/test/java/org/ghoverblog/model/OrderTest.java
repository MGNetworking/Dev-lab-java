package org.ghoverblog.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

    @Test
    void constructor_shouldThrow_whenIdIsNull() {
        assertThatThrownBy(() ->
                new Order(null, List.of()))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("null");
    }

    @Test
    void constructor_shouldThrow_whenOrderLinesIsNull() {
        assertThatThrownBy(() ->
                new Order(UUID.randomUUID().toString(), null))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("null");
    }

    @Test
    void constructor_shouldThrow_whenOrderLinesIsEmpty() {
        assertThatThrownBy(() ->
                new Order(UUID.randomUUID().toString(), List.of()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("vide");
    }

    @Test
    void changeQuantityLine_shouldThrow_WhenChangeProductIsNull() {

        Order order = new Order(
                UUID.randomUUID().toString(),
                List.of(new OrderLine(new Product("keyboard", BigDecimal.TEN), 10)));

        assertThrows(NullPointerException.class,
                () -> order.changeQuantityLine(null, 10));
    }


    @Test
    void changeQuantityLine_shouldThrow_WhenChangeQuantityIsNegative() {
        Product product = new Product("keyboard", BigDecimal.TEN);
        OrderLine line = new OrderLine(product, 1);

        Order order = new Order(
                UUID.randomUUID().toString(),
                List.of(line));

        assertThrows(IllegalArgumentException.class,
                () -> order.changeQuantityLine(product, 0));
    }

    @Test
    void changeQuantityLine_shouldReturnQuantity_WhenProductFound() {
        Product product = new Product("keyboard", BigDecimal.TEN);
        OrderLine line = new OrderLine(product, 1);
        int changeQuantity = 5;

        Order order = new Order(
                UUID.randomUUID().toString(),
                List.of(line));

        order.changeQuantityLine(product, changeQuantity);

        assertThat(order.getQuantityProduct(product))
                .isEqualTo(changeQuantity);

    }

    @Test
    void getQuantityProduct_shouldThrow_whenProductIsNull() {
        Product product = new Product("keyboard", BigDecimal.TEN);
        OrderLine line = new OrderLine(product, 1);
        Order order = new Order(UUID.randomUUID().toString(), List.of(line));

        assertThatThrownBy(() -> order.getQuantityProduct(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("produit");
    }

    @Test
    void getQuantityProduct_shouldReturnQuantity_whenProductFound() {
        int quantity = 1;
        Product product = new Product("keyboard", BigDecimal.TEN);
        OrderLine line = new OrderLine(product, quantity);
        Order order = new Order(UUID.randomUUID().toString(), List.of(line));

        assertThat(order.getQuantityProduct(product))
                .isEqualTo(quantity);
    }

    @Test
    void getQuantityProduct_shouldReturnZero_whenProductNotFound() {
        Product keyboard = new Product("Keyboard", new BigDecimal("49.99"));
        Product mouse = new Product("Mouse", new BigDecimal("19.99"));

        OrderLine line = new OrderLine(keyboard, 3);
        Order order = new Order(UUID.randomUUID().toString(), List.of(line));

        assertThat(order.getQuantityProduct(mouse)).isZero();
    }

}
