package br.com.gabrieldossantos.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gabrieldossantos.workshopmongo.domain.User;
import br.com.gabrieldossantos.workshopmongo.dto.UserDTO;
import br.com.gabrieldossantos.workshopmongo.repository.UserRepository;
import br.com.gabrieldossantos.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){		
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = repo.findById(id);
		if (user.isEmpty() || (!user.isPresent())) 
			throw new ObjectNotFoundException("Objeto não encontrado");
		else
			return user.get();
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void updateData(User newObj, User obj) {		
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}
	
	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}
		
}
