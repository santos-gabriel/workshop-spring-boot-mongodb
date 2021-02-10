package br.com.gabrieldossantos.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.gabrieldossantos.workshopmongo.domain.Post;
import br.com.gabrieldossantos.workshopmongo.domain.User;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	
	
	
}
