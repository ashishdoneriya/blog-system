package com.csetutorials.multiblogapp.services;

import com.csetutorials.multiblogapp.models.Category;
import com.csetutorials.multiblogapp.models.Post;
import com.csetutorials.multiblogapp.models.Tag;
import com.csetutorials.multiblogapp.models.User;
import com.csetutorials.multiblogapp.models.Website;
import com.csetutorials.multiblogapp.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PostService {

	@Autowired
	PostRepository postRepository;
	@Autowired
	WebsiteService websiteService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	TagService tagService;
	@Autowired
	UserService userService;

	public Post findByPostSlug(String postSlug) {
		Website website = websiteService.getWebsite();
		return postRepository.findByWebsiteAndSlug(website, postSlug);
	}

	public Page<Post> findAll(int pageNumber) {
		Website website = websiteService.getWebsite();
		Pageable pageable = PageRequest.of(pageNumber - 1, website.getSettings().getPageSize());
		return postRepository.findByWebsiteOrderByCreatedDesc(website, pageable);
	}

	public Page<Post> findByCategory(String categorySlug, int pageNumber) {
		Pageable pageable = PageRequest.of(pageNumber - 1, websiteService.getWebsite().getSettings().getPageSize());
		return postRepository.findByCategoriesOrderByCreatedDesc(categoryService.getCategory(categorySlug), pageable);
	}

	public Page<Post> findByCategory(Category category, int pageNumber) {
		Pageable pageable = PageRequest.of(pageNumber - 1, websiteService.getWebsite().getSettings().getPageSize());
		return postRepository.findByCategoriesOrderByCreatedDesc(category, pageable);
	}

	public Page<Post> findByTag(String tagSlug, int pageNumber) {
		Pageable pageable = PageRequest.of(pageNumber - 1, websiteService.getWebsite().getSettings().getPageSize());
		return postRepository.findByTagsOrderByCreatedDesc(tagService.getTag(tagSlug), pageable);
	}

	public Page<Post> findByTag(Tag tag, int pageNumber) {
		Pageable pageable = PageRequest.of(pageNumber - 1, websiteService.getWebsite().getSettings().getPageSize());
		return postRepository.findByTagsOrderByCreatedDesc(tag, pageable);
	}

	public Page<Post> findByAuthor(String authorSlug, int pageNumber) {
		Website website = websiteService.getWebsite();
		User user = userService.findBySlug(authorSlug);
		Pageable pageable = PageRequest.of(pageNumber - 1, website.getSettings().getPageSize());
		return postRepository.findByWebsiteAndAuthorOrderByCreatedDesc(website, user, pageable);
	}

	public Page<Post> findByAuthor(User author, int pageNumber) {
		Website website = websiteService.getWebsite();
		Pageable pageable = PageRequest.of(pageNumber - 1, website.getSettings().getPageSize());
		return postRepository.findByWebsiteAndAuthorOrderByCreatedDesc(website, author, pageable);
	}


}
