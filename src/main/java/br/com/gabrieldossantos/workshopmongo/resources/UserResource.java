package br.com.gabrieldossantos.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.gabrieldossantos.workshopmongo.domain.User;
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
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody UserDTO objDTO){
		User obj = serv.insert(serv.fromDTO(objDTO));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id){
		serv.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "{id}")
	public ResponseEntity<UserDTO> update(@RequestBody UserDTO objDTO, @PathVariable String id){				
		objDTO.setId(id);
		return ResponseEntity.ok().body(new UserDTO(serv.update(serv.fromDTO(objDTO))));
	}
	
}
