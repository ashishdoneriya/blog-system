package com.csetutorials.multiblogapp.services;

import com.csetutorials.multiblogapp.models.User;
import com.csetutorials.multiblogapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	WebsiteService websiteService;

	public User findBySlug(String slug) {
		return userRepository.findByWebsiteAndSlug(websiteService.getWebsite(), slug);
	}
}
