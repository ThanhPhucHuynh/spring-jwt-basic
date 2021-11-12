package com.example.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Blog;
import com.example.repository.BlogRepository;

@Service
@Transactional
public class BlogService {
	 @Autowired
	    private BlogRepository blogRepository;
	    public List<Blog> postDaoList() {
	        return (List<Blog>) blogRepository.findAll();
	    }

	    public void savePost(Blog b) {
	    	blogRepository.save(b);
	    }

	    public Blog getPostDao(Long id) {
	        return blogRepository.findById(id).get();
	    }

	    public void deletePostDao(Long id) {
	    	blogRepository.deleteById(id);
	    }
}
