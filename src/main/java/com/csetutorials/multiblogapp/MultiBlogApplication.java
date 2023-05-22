package com.csetutorials.multiblogapp;

import com.csetutorials.multiblogapp.models.Role;
import com.csetutorials.multiblogapp.models.User;
import com.csetutorials.multiblogapp.models.Website;
import com.csetutorials.multiblogapp.models.WebsiteUser;
import com.csetutorials.multiblogapp.repositories.CategoryRepository;
import com.csetutorials.multiblogapp.repositories.PageRepository;
import com.csetutorials.multiblogapp.repositories.PostRepository;
import com.csetutorials.multiblogapp.repositories.UserRepository;
import com.csetutorials.multiblogapp.repositories.WebsiteRepository;
import com.csetutorials.multiblogapp.repositories.WebsiteUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MultiBlogApplication implements CommandLineRunner {

	@Autowired
	PageRepository pageRepository;
	@Autowired
	PostRepository postRepository;
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	WebsiteUserRepository websiteUserRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	WebsiteRepository websiteRepository;

	public static void main(String[] args) {
		SpringApplication.run(MultiBlogApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		addPages();
		addPosts();
	}

	private void addPosts() {
		User user = new User();
		user.setName("Ashish Doneriya");
		user.setSlug("ashishdoneriya");
		user.setDescription("Hi buddies");
		user.setRole(Role.SUPER_ADMIN);
		userRepository.save(user);

		Website website = new Website();
		website.setName("Cse Tutorials");
		website.setDomain("localhost");
		website.setDescription("tutorials about something");

		websiteRepository.save(website);

		WebsiteUser websiteUser = new WebsiteUser();
		websiteUser.setWebsite(website);
		websiteUser.setUser(user);
		websiteUser.setRole(Role.SUPER_ADMIN);
		websiteUserRepository.save(websiteUser);
	}

	private void addPages() {
	}
}
