package com.csetutorials.multiblogapp.repositories;

import com.csetutorials.multiblogapp.models.User;
import com.csetutorials.multiblogapp.models.Website;
import com.csetutorials.multiblogapp.models.WebsiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebsiteUserRepository extends JpaRepository<WebsiteUser, Long> {

	boolean existsByUserAndWebsite(User user, Website website);

}
