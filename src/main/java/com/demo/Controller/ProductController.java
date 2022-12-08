package com.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Dto.ProductDto;
import com.demo.Service.ProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductService productservice;
	
	@GetMapping
	public Flux<ProductDto> getproducts() {
		return productservice.getproducts();

	}
	
	
	@PostMapping
	public Mono<ProductDto> saveProduct(@RequestBody Mono<ProductDto> productDtoMono) {
		return productservice.saveProduct(productDtoMono);
		

	}
	@PutMapping("/update/{id}")
	public Mono<ProductDto> saveproduct(@RequestBody Mono<ProductDto> productDtoMono,@PathVariable String id) {
		return productservice.updateProduct(productDtoMono,id );
		

	}
	@DeleteMapping("/delete{id}")
	public Mono<Void> deleteProduct(@PathVariable String id) {
		return productservice.deleteProduct(id);

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}