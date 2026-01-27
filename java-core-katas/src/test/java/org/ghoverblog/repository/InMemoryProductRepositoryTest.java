package org.ghoverblog.repository;

import org.ghoverblog.model.Product;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InMemoryProductRepositoryTest {

    @Test
    void save_then_findById_returnProduct() {
        ProductRepository repo = new InMemoryProductRepository();
        Product p = new Product("Keyboard", new BigDecimal("49.99"));

        repo.save(p);

        assertThat(repo.findById(p.getId())).contains(p);

    }

    @Test
    void save_with_null_product_should_throw() {
        ProductRepository repo = new InMemoryProductRepository();

        assertThatThrownBy(() -> repo.save(null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    void delete_existing_then_delete_again_returns_false() {
        ProductRepository repo = new InMemoryProductRepository();
        Product p = new Product("Keyboard", new BigDecimal("49.99"));

        repo.save(p);
        UUID id = p.getId();

        assertThat(repo.delete(id)).isTrue();
        assertThat(repo.delete(id)).isFalse();
    }


    @Test
    void delete_with_null_id_should_throw() {
        ProductRepository repo = new InMemoryProductRepository();
        assertThatThrownBy(() -> repo.delete(null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    void update_with_null_product_should_throw() {
        ProductRepository repo = new InMemoryProductRepository();

        assertThatThrownBy(() -> repo.update(null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    void update_unknown_returns_false() {
        ProductRepository repo = new InMemoryProductRepository();

        Product p = new Product("Keyboard", new BigDecimal("49.99"));

        assertThat(repo.update(p)).isFalse();
    }

    @Test
    void update_existing_returns_true() {
        ProductRepository repo = new InMemoryProductRepository();

        Product p = new Product("Keyboard", new BigDecimal("49.99"));
        repo.save(p);

        assertThat(repo.update(p)).isTrue();
    }


}
