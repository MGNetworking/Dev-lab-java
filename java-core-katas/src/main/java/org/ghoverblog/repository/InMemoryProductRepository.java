package org.ghoverblog.repository;

import org.ghoverblog.model.Product;

import java.util.*;

public class InMemoryProductRepository implements ProductRepository {

    private final Map<UUID, Product> productMap = new HashMap<>();

    @Override
    public boolean save(Product product) {
        Objects.requireNonNull(product, "Product must not be null");
        return this.productMap.put(product.getId(), product) != null;
    }

    @Override
    public Optional<Product> findById(UUID id) {
        Objects.requireNonNull(id, "Product id must not be null");
        return Optional.ofNullable(this.productMap.get(id));
    }

    @Override
    public boolean delete(UUID id) {
        Objects.requireNonNull(id, "L'id Produit ne doit pas être null");
        return this.productMap.remove(id) != null;
    }

    @Override
    public boolean update( Product product) {
        Objects.requireNonNull(product, "Le Produit ne doit pas être null");
        return this.productMap.replace(product.getId(), product) != null;
    }
}
