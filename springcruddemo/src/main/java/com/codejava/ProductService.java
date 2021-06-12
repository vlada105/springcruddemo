package com.codejava;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repository;
	
	public List<Product> listAll(){
		return repository.findAll();		
	}
	
	public void saveProduct(Product product) {
		repository.save(product);
	}
	
	public Product getProductById(Long id) {
		return repository.findById(id).get();
	}
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
