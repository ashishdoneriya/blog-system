package com.csetutorials.multiblogapp.repositories;

import com.csetutorials.multiblogapp.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}