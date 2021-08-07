package br.com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.educandoweb.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	
	
}
