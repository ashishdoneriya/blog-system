package com.csetutorials.multiblogapp.repositories;

import com.csetutorials.multiblogapp.models.WebsiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebsiteUserRepository extends JpaRepository<WebsiteUser, Long> {
}
