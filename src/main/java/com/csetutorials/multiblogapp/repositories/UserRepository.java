package com.csetutorials.multiblogapp.repositories;

import com.csetutorials.multiblogapp.models.User;
import com.csetutorials.multiblogapp.models.Website;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT u FROM User u INNER JOIN u.websiteUsers wu WHERE wu.website = :website AND u.slug = :slug")
	User findByWebsiteAndSlug(@Param("website") Website website, @Param("slug") String slug);

}
