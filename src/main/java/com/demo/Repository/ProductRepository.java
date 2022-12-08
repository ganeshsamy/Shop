package com.demo.Repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.demo.Entity.Product;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product, String>{

}
