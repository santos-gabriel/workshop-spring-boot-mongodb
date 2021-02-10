package br.com.gabrieldossantos.workshopmongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gabrieldossantos.workshopmongo.domain.Post;
import br.com.gabrieldossantos.workshopmongo.repository.PostRepository;
import br.com.gabrieldossantos.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Post post = repo.findById(id).get();
		if (post == null) {
			throw new ObjectNotFoundException("Post não encontrado");
		}
		return post;
	}
}
