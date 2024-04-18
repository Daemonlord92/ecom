package org.blitmatthew.ecom;

import org.blitmatthew.ecom.domain.documents.Product;
import org.blitmatthew.ecom.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcomApplication implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(EcomApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if(productRepository.count() == 0) {
            productRepository.insert(Product.builder().name("Rubber Duck").description("A small yellow rubber duck to sit on your desk!").price(3.50).build());
        }
    }
}
