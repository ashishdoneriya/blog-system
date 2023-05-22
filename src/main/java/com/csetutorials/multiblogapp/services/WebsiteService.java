package com.csetutorials.multiblogapp.services;

import com.csetutorials.multiblogapp.models.Website;
import com.csetutorials.multiblogapp.repositories.WebsiteRepository;
import com.csetutorials.multiblogapp.utilities.DomainResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WebsiteService {

	@Autowired
	WebsiteRepository repo;

	Map<String, Website> cache = new HashMap<>();

	public Website getWebsite() {
		return getWebsite(DomainResolver.getDomain());
	}

	private synchronized Website getWebsite(String domain) {
		Website website = cache.get(domain);
		if (website == null) {
			website = repo.findByDomain(domain);
			cache.put(domain, website);
		}
		return website;
	}

}
