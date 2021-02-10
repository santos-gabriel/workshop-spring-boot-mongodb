package br.com.gabrieldossantos.workshopmongo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabrieldossantos.workshopmongo.domain.Post;
import br.com.gabrieldossantos.workshopmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired
	private PostService serv;
	
	@RequestMapping(value = "{id}")
	public ResponseEntity<Post> findById(@PathVariable String id){
		return ResponseEntity.ok().body(serv.findById(id));
	}
	
}
