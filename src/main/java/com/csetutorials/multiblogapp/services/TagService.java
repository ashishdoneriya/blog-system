package com.csetutorials.multiblogapp.services;

import com.csetutorials.multiblogapp.models.Tag;
import com.csetutorials.multiblogapp.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagService {

	@Autowired
	WebsiteService websiteService;
	@Autowired
	TagRepository tagRepository;

	public Tag getTag(String tagSlug) {
		return tagRepository.findByWebsiteAndSlug(websiteService.getWebsite(), tagSlug);
	}


}
