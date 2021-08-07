package br.com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.educandoweb.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
	
	
	
}
