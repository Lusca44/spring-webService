package br.com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.educandoweb.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	
	
}
