package org.ghoverblog.model;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ProductTest {

    @Test
    void price_cannot_be_null() {
        assertThatThrownBy(() ->
                new Product("keyboard", null))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("prix");
    }

    @Test
    void price_is_normalized_to_decimale() {
        Product product = new Product("keyboard", new BigDecimal("49.995"));

        assertThat(product.getPrice())
                .isEqualByComparingTo(new BigDecimal("50.00"))
                .hasScaleOf(2);

    }

    @Test
    void price_must_be_strictly_positive() {

        assertThatThrownBy(() ->
                new Product("keyboard", BigDecimal.ZERO))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("strictement positif");
    }

    @Test
    void setPrice_shouldThrow_whenPriceIsNull(){
        assertThatThrownBy(() ->
                new Product(UUID.randomUUID().toString(), null))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("null");
    }



}
