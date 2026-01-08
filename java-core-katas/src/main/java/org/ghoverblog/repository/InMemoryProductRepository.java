package org.ghoverblog.repository;

import org.ghoverblog.model.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class InMemoryProductRepository implements ProductRepository {

    private final Map<UUID, Product> productMap = new HashMap<>();

    @Override
    public boolean save(Product product) {
        return this.productMap.put(product.getId(), product) != null;
    }

    @Override
    public Optional<Product> findById(UUID id) {
        return Optional.ofNullable(this.productMap.get(id));
    }

    @Override
    public boolean delete(UUID id) {
        return this.productMap.remove(id) != null;
    }

    @Override
    public boolean update( Product product) {
        return this.productMap.replace(product.getId(), product) != null;
    }
}
