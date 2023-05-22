package com.csetutorials.multiblogapp.repositories;

import com.csetutorials.multiblogapp.models.Category;
import com.csetutorials.multiblogapp.models.Website;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	Category findByWebsiteAndSlug(Website website, @Param("slug") String slug);

}
