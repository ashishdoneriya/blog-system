package com.csetutorials.multiblogapp.repositories;

import com.csetutorials.multiblogapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

	User findBySlug(@Param("slug") String slug);

}
