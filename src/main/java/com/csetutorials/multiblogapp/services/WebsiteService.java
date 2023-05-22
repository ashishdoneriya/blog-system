package com.csetutorials.multiblogapp.services;

import com.csetutorials.multiblogapp.models.Website;
import com.csetutorials.multiblogapp.repositories.WebsiteRepository;
import com.csetutorials.multiblogapp.utilities.DomainResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebsiteService {

	@Autowired
	WebsiteRepository repo;

	public Website getWebsite() {
		return repo.findByDomain(DomainResolver.getDomain());
	}

}
