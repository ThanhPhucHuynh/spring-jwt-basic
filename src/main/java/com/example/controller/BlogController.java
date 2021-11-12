package com.example.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Blog;
import com.example.service.BlogService;

@RestController
@RequestMapping("/post")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BlogController {
	@Autowired
    BlogService blogService;
	
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Blog> list() {
        return blogService.postDaoList();
    }
    @RequestMapping(value = "", method = RequestMethod.POST)
    public void add(@RequestBody Blog postDao) {
    	blogService.savePost(postDao);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Blog> get(@PathVariable Long id) {
        try {
            Blog postDao = blogService.getPostDao(id);
            return new ResponseEntity<Blog>(postDao, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Blog postDao, @PathVariable Integer id) {
        try {
            postDao.setId(id);
            blogService.savePost(postDao);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
