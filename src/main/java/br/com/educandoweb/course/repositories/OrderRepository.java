package br.com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.educandoweb.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
	
	
}
