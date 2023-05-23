package com.csetutorials.multiblogapp.services;

import com.csetutorials.multiblogapp.models.User;
import com.csetutorials.multiblogapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public User findBySlug(String slug) {
		return userRepository.findBySlug(slug);
	}
}
