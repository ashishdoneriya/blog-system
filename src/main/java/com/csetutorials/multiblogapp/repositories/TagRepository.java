package com.csetutorials.multiblogapp.repositories;

import com.csetutorials.multiblogapp.models.Tag;
import com.csetutorials.multiblogapp.models.Website;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface TagRepository extends JpaRepository<Tag, Long> {

	Tag findByWebsiteAndSlug(Website website, @Param("slug") String slug);

}
