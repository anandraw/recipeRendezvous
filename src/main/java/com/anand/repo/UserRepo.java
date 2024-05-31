package com.anand.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anand.model.User;

public interface UserRepo extends JpaRepository<User, Long> {
	
	public Optional<User> findByEmail(String username);

}
