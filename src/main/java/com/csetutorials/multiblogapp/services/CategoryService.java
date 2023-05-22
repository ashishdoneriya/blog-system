package com.csetutorials.multiblogapp.services;

import com.csetutorials.multiblogapp.models.Category;
import com.csetutorials.multiblogapp.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

	@Autowired
	WebsiteService websiteService;
	@Autowired
	CategoryRepository categoryRepository;

	public Category getCategory(String categorySlug) {
		return categoryRepository.findByWebsiteAndSlug(websiteService.getWebsite(), categorySlug);
	}


}
