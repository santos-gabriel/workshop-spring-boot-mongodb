package br.com.gabrieldossantos.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gabrieldossantos.workshopmongo.domain.User;
import br.com.gabrieldossantos.workshopmongo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		try {
			return repo.findAll();
		}catch(Exception e) {
			return null;
		}
	}
	
}
