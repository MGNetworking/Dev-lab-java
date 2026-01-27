package org.ghoverblog.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


public class OrderLineTest {

    @Test
    void constructor_shouldThrow_whenProductIsNull() {
        assertThatThrownBy(() -> new OrderLine(null, 1))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("produit")
                .hasMessageContaining("null");
    }

    @Test
    void constructor_shouldThrow_whenQuantityIsNegative() {
        Product product = new Product("Keyboard", new BigDecimal("49.99"));

        assertThatThrownBy(() -> new OrderLine(product, -1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0");
    }

    @Test
    void constructor_shouldCreateOrderLine_whenInputsAreValid() {
        Product product = new Product("Keyboard", new BigDecimal("49.99"));

        OrderLine line = new OrderLine(product, 2);

        assertThat(line.getId()).isNotNull();
        assertThat(line.getQuantity()).isEqualTo(2);
        assertThat(line.getProduct()).isSameAs(product);
    }

    @Test
    void changeQuantity_shouldThrow_whenQuantityIsNegative() {
        Product product = new Product("Keyboard", new BigDecimal("49.99"));
        OrderLine line = new OrderLine(product, 1);

        assertThatThrownBy(() -> line.changeQuantity(-5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0");
    }

    @Test
    void changeQuantity_shouldUpdateQuantity_whenQuantityIsValid() {
        Product product = new Product("Keyboard", new BigDecimal("49.99"));
        OrderLine line = new OrderLine(product, 1);

        line.changeQuantity(7);

        assertThat(line.getQuantity()).isEqualTo(7);
    }

    @Test
    void getLineTotale_shouldReturnUnitPriceTimesQuantity() {
        Product product = new Product("Keyboard", new BigDecimal("49.99"));
        OrderLine line = new OrderLine(product, 3);

        assertThat(line.getLineTotale())
                .isEqualByComparingTo("149.97");
    }

    @Test
    void getLineTotale_shouldReturnZero_whenQuantityIsZero() {
        Product product = new Product("Keyboard", new BigDecimal("49.99"));
        OrderLine line = new OrderLine(product, 0);

        assertThat(line.getLineTotale())
                .isEqualByComparingTo("0.00");
    }
}
