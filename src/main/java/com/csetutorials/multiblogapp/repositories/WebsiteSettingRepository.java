package com.csetutorials.multiblogapp.repositories;

import com.csetutorials.multiblogapp.models.WebsiteSetting;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

@Cacheable
public interface WebsiteSettingRepository extends JpaRepository<WebsiteSetting, Long> {
}
