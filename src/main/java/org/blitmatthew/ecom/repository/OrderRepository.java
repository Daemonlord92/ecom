package org.blitmatthew.ecom.repository;

import org.blitmatthew.ecom.domain.documents.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
}
