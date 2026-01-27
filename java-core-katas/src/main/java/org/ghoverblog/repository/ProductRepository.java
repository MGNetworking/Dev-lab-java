package org.ghoverblog.repository;

import org.ghoverblog.model.Product;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepository {

    boolean save(Product product);

    Optional<Product> findById(UUID id);

    boolean delete(UUID id);

    boolean update(Product product);

}
