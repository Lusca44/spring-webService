package br.com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.educandoweb.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	
	
}
