package com.csetutorials.multiblogapp;

import com.csetutorials.multiblogapp.models.Category;
import com.csetutorials.multiblogapp.models.Page;
import com.csetutorials.multiblogapp.models.Post;
import com.csetutorials.multiblogapp.models.Role;
import com.csetutorials.multiblogapp.models.User;
import com.csetutorials.multiblogapp.models.Website;
import com.csetutorials.multiblogapp.models.WebsiteSetting;
import com.csetutorials.multiblogapp.models.WebsiteUser;
import com.csetutorials.multiblogapp.repositories.CategoryRepository;
import com.csetutorials.multiblogapp.repositories.PageRepository;
import com.csetutorials.multiblogapp.repositories.PostRepository;
import com.csetutorials.multiblogapp.repositories.UserRepository;
import com.csetutorials.multiblogapp.repositories.WebsiteRepository;
import com.csetutorials.multiblogapp.repositories.WebsiteSettingRepository;
import com.csetutorials.multiblogapp.repositories.WebsiteUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
@EnableCaching
@EnableTransactionManagement
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
	@Autowired
	WebsiteSettingRepository websiteSettingRepository;

	public static void main(String[] args) {
		SpringApplication.run(MultiBlogApplication.class, args);
	}

	@Bean
	public CacheManager cacheManager() {
		return new ConcurrentMapCacheManager();
	}

	@Override
	public void run(String... args) {
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

		WebsiteSetting setting = new WebsiteSetting();
		setting.setWebsite(website);
		websiteSettingRepository.save(setting);

		WebsiteUser websiteUser = new WebsiteUser();
		websiteUser.setWebsite(website);
		websiteUser.setUser(user);
		websiteUser.setRole(Role.SUPER_ADMIN);
		websiteUserRepository.save(websiteUser);

		Page pa = new Page();
		pa.setAuthor(user);
		pa.setSlug("p11-1");
		pa.setTitle("title 1");
		pa.setWebsite(website);
		pa.setContent("dasf asd fasd fasdfasd fas 11111111111111111111111111111");
		pa.setCreated(System.currentTimeMillis());
		pa.setUpdated(System.currentTimeMillis());
		pageRepository.save(pa);

		Category c1 = new Category();
		c1.setName("Category 1");
		c1.setSlug("category-1");
		c1.setWebsite(website);
		categoryRepository.save(c1);
		Category c2 = new Category();
		c2.setName("Category 2");
		c2.setSlug("category-2");
		c2.setWebsite(website);
		categoryRepository.save(c2);

		Post p1 = new Post();
		p1.setDescription("asdfdsaf d fasdf adsfas");
		p1.setAuthor(user);
		p1.setSlug("p1-1");
		p1.setTitle("title 1");
		p1.setWebsite(website);
		p1.setContent("dasf asd fasd fasdfasd fas 11111111111111111111111111111");
		p1.setCreated(System.currentTimeMillis());
		p1.setUpdated(System.currentTimeMillis());
		p1.setCategories(Arrays.asList(c1, c2));
		postRepository.save(p1);

		Post p2 = new Post();
		p2.setDescription("asdfdsaf d fasdf adsfas");
		p2.setAuthor(user);
		p2.setSlug("p2-2");
		p2.setTitle("title 2");
		p2.setWebsite(website);
		p2.setContent("dasf asd fasd fasdfasd fas df222222222222222222222222222");
		p2.setCreated(System.currentTimeMillis());
		p2.setUpdated(System.currentTimeMillis());
		p2.setCategories(Collections.singletonList(c1));
		postRepository.save(p2);

	}

}
