package com.csetutorials.multiblogapp.repositories;

import com.csetutorials.multiblogapp.models.Website;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface WebsiteRepository extends JpaRepository<Website, Long> {

	@Cacheable("websiteCache")
	Website findByDomain(@Param("domain") String domain);

}
