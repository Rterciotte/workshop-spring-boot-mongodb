package com.rterciotte.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rterciotte.workshopmongo.domain.User;
import com.rterciotte.workshopmongo.dto.UserDTO;
import com.rterciotte.workshopmongo.repository.UserRepository;
import com.rterciotte.workshopmongo.services.exception.ObjectNotFoundException;

@Service


public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public User fromDTO(UserDTO objDTO) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
