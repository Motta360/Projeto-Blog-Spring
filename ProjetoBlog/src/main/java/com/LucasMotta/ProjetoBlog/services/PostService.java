package com.LucasMotta.ProjetoBlog.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LucasMotta.ProjetoBlog.models.Post;
import com.LucasMotta.ProjetoBlog.repositories.PostRepository;

@Service
public class PostService {
	
	@Autowired
	PostRepository postRepository;
	
	public Optional<Post> findById(Long id){
		return postRepository.findById(id);
	}
	
	public List<Post> findAll(){
		return postRepository.findAll();
	}
	
	public Post save(Post Post) {
		return postRepository.save(Post);
	}
	
	public void delete(Long id) {
		postRepository.deleteById(id);
	}

}
