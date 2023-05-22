package com.csetutorials.multiblogapp.controllers;

import com.csetutorials.multiblogapp.models.Category;
import com.csetutorials.multiblogapp.models.Post;
import com.csetutorials.multiblogapp.models.Tag;
import com.csetutorials.multiblogapp.models.User;
import com.csetutorials.multiblogapp.services.CategoryService;
import com.csetutorials.multiblogapp.services.PageService;
import com.csetutorials.multiblogapp.services.PostService;
import com.csetutorials.multiblogapp.services.TagService;
import com.csetutorials.multiblogapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LayoutController {

	@Autowired
	PostService postService;
	@Autowired
	PageService pageService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	TagService tagService;
	@Autowired
	UserService userService;

	@RequestMapping("/{slug}.html")
	public String findByPostSlug(Model model, @PathVariable("slug") String slug) {
		model.addAttribute("post", postService.findByPostSlug(slug));
		return "post";
	}

	@RequestMapping("/{slug}")
	public String findByPageSlug(Model model, @PathVariable("slug") String slug) {
		model.addAttribute("post", pageService.findBySlug(slug));
		return "post";
	}

	@RequestMapping("/topics/{slug}")
	public String findPostsByTopic(Model model, @PathVariable("slug") String slug) {
		Category category = categoryService.getCategory(slug);
		model.addAttribute("category", category);
		addPosts(model, postService.findByCategory(category, 1));
		return "category";
	}

	@RequestMapping("/topics/{slug}/page/{pageNumber}")
	public String findPostsByTopicPaginated(Model model, @PathVariable("slug") String slug, int pageNumber) {
		Category category = categoryService.getCategory(slug);
		model.addAttribute("category", category);
		addPosts(model, postService.findByCategory(category, pageNumber));
		return "category";
	}

	@RequestMapping("/tags/{slug}")
	public String findPostsByTag(Model model, @PathVariable("slug") String slug) {
		Tag tag = tagService.getTag(slug);
		model.addAttribute("tag", tag);
		addPosts(model, postService.findByTag(tag, 1));
		return "tag";
	}

	@RequestMapping("/tags/{slug}/page/{pageNumber}")
	public String findPostsByTagPaginated(Model model, @PathVariable("slug") String slug, int pageNumber) {
		Tag tag = tagService.getTag(slug);
		model.addAttribute("tag", tag);
		addPosts(model, postService.findByTag(tag, pageNumber));
		return "tag";
	}

	@RequestMapping("/authors/{slug}")
	public String findPostsByAuthor(Model model, @PathVariable("slug") String slug) {
		User user = userService.findBySlug(slug);
		model.addAttribute("user", postService.findByAuthor(user, 1));
		addPosts(model, postService.findByAuthor(user, 1));
		return "author";
	}

	@RequestMapping("/authors/{slug}/page/{pageNumber}")
	public String findPostsByAuthorPaginated(Model model, @PathVariable("slug") String slug, int pageNumber) {
		User user = userService.findBySlug(slug);
		model.addAttribute("user", postService.findByAuthor(user, 1));
		addPosts(model, postService.findByAuthor(user, pageNumber));
		return "author";
	}

	private void addPosts(Model model, Page<Post> page) {
		model.addAttribute("posts", page.getContent());
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalRecords", page.getNumberOfElements());
	}

}
