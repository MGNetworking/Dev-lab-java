package org.ghoverblog.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ProductTest {

    @Test
    void price_cannot_be_null() {
        assertThatThrownBy(() ->
                new Product("Keyboard", null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    void price_is_normalized_to_decimale() {
        Product product = new Product("keybord", new BigDecimal("49.995"));

        assertThat(product.getPrice())
                .isEqualByComparingTo(new BigDecimal("50.00"));
    }

    @Test
    void price_must_be_strictly_positive() {

        assertThatThrownBy(() -> new Product("keybord", BigDecimal.ZERO))
                .isInstanceOf(IllegalArgumentException.class);
    }



}
