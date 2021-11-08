package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public static final String FIND_BY_EMAIL = "SELECT * FROM members WHERE email = ?1";

	@Query(value = FIND_BY_EMAIL, nativeQuery = true)
	 User findByEmail(String email);
}
