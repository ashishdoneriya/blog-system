package com.csetutorials.multiblogapp.repositories;

import com.csetutorials.multiblogapp.models.Category;
import com.csetutorials.multiblogapp.models.Post;
import com.csetutorials.multiblogapp.models.Tag;
import com.csetutorials.multiblogapp.models.User;
import com.csetutorials.multiblogapp.models.Website;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface PostRepository extends JpaRepository<Post, Long> {

	Post findByWebsiteAndSlug(Website website, @Param("slug") String slug);

	Page<Post> findByWebsiteOrderByCreatedDesc(Website website, Pageable pageable);

	Page<Post> findByCategoriesOrderByCreatedDesc(Category cateory, Pageable pageable);

	Page<Post> findByTagsOrderByCreatedDesc(Tag tag, Pageable pageable);

	Page<Post> findByWebsiteAndAuthorOrderByCreatedDesc(Website website, User author, Pageable pageable);

}
