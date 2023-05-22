package com.csetutorials.multiblogapp.services;

import com.csetutorials.multiblogapp.models.Page;
import com.csetutorials.multiblogapp.repositories.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PageService {

	@Autowired
	PageRepository pageRepository;
	@Autowired
	WebsiteService websiteService;

	public Page findBySlug(String slug) {
		return pageRepository.findByWebsiteAndSlug(websiteService.getWebsite(), slug);
	}
}
