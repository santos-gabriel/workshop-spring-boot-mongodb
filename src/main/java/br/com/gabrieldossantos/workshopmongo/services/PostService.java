package br.com.gabrieldossantos.workshopmongo.services;

import java.util.Date;
import java.util.List;

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
	
	public List<Post> findByTitle(String text) {
		return repo.findByTitle(text);
//		return repo.findByTitleContainingIgnoreCase(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repo.fullSearch(text, minDate, maxDate);		
	}
}
