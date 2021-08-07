package br.com.educandoweb.course.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.educandoweb.course.entities.User;
import br.com.educandoweb.course.repositories.UserRepository;
import br.com.educandoweb.course.services.exceptions.DatabaseException;
import br.com.educandoweb.course.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public List<User> findAll(){
		return userRepo.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = userRepo.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User user) {
		return userRepo.save(user);
	}
	
	public void delete(Long id) {
		try {
			userRepo.deleteById(id);
			}
		catch(EmptyResultDataAccessException e){
				throw new ResourceNotFoundException(id);
			}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public User update(Long id, User user) {
		try{
			Optional<User> entity = userRepo.findById(id);
			updateData(entity, user);
			return userRepo.save(entity.get());
		}catch (NoSuchElementException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Optional<User> entity, User user) {
		entity.get().setName(user.getName());
		entity.get().setEmail(user.getEmail());
		entity.get().setPhone(user.getPhone());
	}
	
}

