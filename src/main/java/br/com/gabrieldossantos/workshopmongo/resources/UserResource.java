package br.com.gabrieldossantos.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabrieldossantos.workshopmongo.dto.UserDTO;
import br.com.gabrieldossantos.workshopmongo.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	@Autowired
	private UserService serv;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){					
		return ResponseEntity.ok().body(serv.findAll().stream().map(u -> new UserDTO(u)).collect(Collectors.toList()));		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
		return ResponseEntity.ok().body(new UserDTO(serv.findById(id)));
	}
	
}
