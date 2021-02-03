package br.com.gabrieldossantos.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabrieldossantos.dto.UserDTO;
import br.com.gabrieldossantos.workshopmongo.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	@Autowired
	private UserService serv;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){
		try {			
			return ResponseEntity.ok().body(serv.findAll().stream().map(u -> new UserDTO(u)).collect(Collectors.toList()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
}
