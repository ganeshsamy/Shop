package com.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Dto.ProductDto;
import com.demo.Repository.ProductRepository;
import com.demo.Utill.AppUtills;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

	@Autowired
	 ProductRepository productrepository;

	public Flux<ProductDto> getproducts() {
		
		return productrepository.findAll().map(AppUtills:: entityToDto);
	}

	
	public Mono<ProductDto> saveProduct(Mono<ProductDto> productDtoMono) {
		return productDtoMono.map(AppUtills :: dtoToEntity)
				.flatMap(productrepository :: insert )
				.map(AppUtills :: entityToDto);		

	}
	public Mono<ProductDto> updateProduct(Mono<ProductDto> productDtoMono, String id ) {
		
		return productrepository.findById(id)
				.flatMap(p ->productDtoMono.map(AppUtills :: dtoToEntity)
						.doOnNext(e -> e.setId(id)))
				.flatMap(productrepository :: save)
				.map(AppUtills :: entityToDto);
		

	}
	public Mono<Void> deleteProduct(String id) {
		return productrepository.deleteById(id);
		

	}
	
	
	
	
	
	
}
