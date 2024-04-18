package org.blitmatthew.ecom.repository;

import org.blitmatthew.ecom.domain.documents.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
