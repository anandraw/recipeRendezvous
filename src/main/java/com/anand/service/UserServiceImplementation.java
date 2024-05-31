package com.anand.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.anand.exceptions.UserException;
import com.anand.model.User;
import com.anand.repo.UserRepo;
import com.anand.security.JwtProvider;

@Service
public class UserServiceImplementation implements UserService {

	 private UserRepo userRepository;
	    private JwtProvider jwtProvider;
	    private PasswordEncoder passwordEncoder;

	    public UserServiceImplementation(UserRepo userRepository, JwtProvider jwtProvider, PasswordEncoder passwordEncoder) {
	        this.userRepository = userRepository;
	        this.jwtProvider = jwtProvider;
	        this.passwordEncoder = passwordEncoder;
	    }

	    @Override
	    public User findUserProfileByJwt(String jwt) throws UserException {
	        // Extract email from JWT token
	        String email = jwtProvider.getEmailFromJwtToken(jwt);

	        System.out.println("Extracted email from JWT: " + email);

	        // Fetch user by email
	        Optional<User> user = userRepository.findByEmail(email);

	        // Check if user exists
	        if (user.isEmpty()) {
	            throw new UserException("User does not exist with email: " + email);
	        }

	        System.out.println("Found user with email: " + user.get().getEmail());
	        return user.get();
	    }

}
