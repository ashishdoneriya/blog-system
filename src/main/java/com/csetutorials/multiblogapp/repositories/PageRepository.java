package com.csetutorials.multiblogapp.repositories;

import com.csetutorials.multiblogapp.models.Page;
import com.csetutorials.multiblogapp.models.Website;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PageRepository extends JpaRepository<Page, Long> {

	List<Page> findByWebsiteOrderByCreatedAsc(Website website);

	Page findByWebsiteAndSlug(Website website, @Param("slug") String slug);

}
