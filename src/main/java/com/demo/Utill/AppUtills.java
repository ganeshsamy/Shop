package com.demo.Utill;

import org.springframework.beans.BeanUtils;

import com.demo.Dto.ProductDto;
import com.demo.Entity.Product;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

public class AppUtills {
	public static ProductDto entityToDto(Product product) {
		ProductDto productDto = new ProductDto();
		BeanUtils.copyProperties(product, productDto);
		return productDto;
		
	}
	public static Product dtoToEntity(ProductDto productDto) {
		Product product = new Product();
		BeanUtils.copyProperties(productDto,product );
		return product;
		
	}

}
