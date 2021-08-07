package br.com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.educandoweb.course.entities.Product;
import br.com.educandoweb.course.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepo;
	
	public List<Product> findAll(){
		return productRepo.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = productRepo.findById(id);
		return obj.get();
	}
	
}
