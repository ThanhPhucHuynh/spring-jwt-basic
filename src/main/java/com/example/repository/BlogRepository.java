package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long >  {
	 
//	Blog findById(int id);
}
