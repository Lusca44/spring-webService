package br.com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.educandoweb.course.entities.OrderItem;
import br.com.educandoweb.course.repositories.OrderItemRepository;

@Service
public class OrderItemService {
	
	@Autowired
	private OrderItemRepository orderItemRepo;
	
	public List<OrderItem> findAll(){
		return orderItemRepo.findAll();
	}
	
	public OrderItem findById(Long id) {
		Optional<OrderItem> obj = orderItemRepo.findById(id);
		return obj.get();
	}
	
}
