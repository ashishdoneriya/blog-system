package com.csetutorials.multiblogapp.controllers;

import com.csetutorials.multiblogapp.models.Comment;
import com.csetutorials.multiblogapp.models.Post;
import com.csetutorials.multiblogapp.repositories.CommentRepository;
import com.csetutorials.multiblogapp.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/api/comments")
@RestController
public class CommentsController {

	@Autowired
	CommentRepository commentRepository;
	@Autowired
	PostRepository postRepository;

	@PostMapping("/add-first-level-comment")
	public HttpStatus addFirstLevelComment(HttpServletRequest request) {
		Post post = postRepository.findById(Long.valueOf(request.getParameter("postId"))).get();
		String author = request.getParameter("author");
		String email = request.getParameter("email");
		String content = request.getParameter("content");
		Comment comment = new Comment();
		comment.setPost(post);
		comment.setAuthor(author);
		comment.setEmail(email);
		comment.setContent(content);
		comment.setCreated(System.currentTimeMillis());
		commentRepository.save(comment);
		return HttpStatus.OK;
	}

	@PostMapping("/add-second-level-comment")
	public HttpStatus addSecondFirstLevelComment(HttpServletRequest request) {
		Post post = postRepository.findById(Long.valueOf(request.getParameter("postId"))).get();
		String author = request.getParameter("author");
		String email = request.getParameter("email");
		String content = request.getParameter("content");
		String firstLevelParentCommentId = request.getParameter("firstLevelParentCommentId");
		Comment comment = new Comment();
		comment.setPost(post);
		comment.setAuthor(author);
		comment.setEmail(email);
		comment.setContent(content);
		comment.setCreated(System.currentTimeMillis());
		Comment firstLevelParentComment = commentRepository.findById(Long.valueOf(firstLevelParentCommentId)).get();
		comment.setFirstLevelParentComment(firstLevelParentComment);
		commentRepository.save(comment);
		return HttpStatus.OK;
	}

	@PostMapping("/add-third-level-comment")
	public HttpStatus addThirdFirstLevelComment(HttpServletRequest request) {
		Post post = postRepository.findById(Long.valueOf(request.getParameter("postId"))).get();
		String author = request.getParameter("author");
		String email = request.getParameter("email");
		String content = request.getParameter("content");
		Comment comment = new Comment();
		comment.setPost(post);
		comment.setAuthor(author);
		comment.setEmail(email);
		comment.setContent(content);
		comment.setCreated(System.currentTimeMillis());
		String firstLevelParentCommentId = request.getParameter("firstLevelParentCommentId");
		Comment firstLevelParentComment = commentRepository.findById(Long.valueOf(firstLevelParentCommentId)).get();
		comment.setFirstLevelParentComment(firstLevelParentComment);

		String secondLevelParentCommentId = request.getParameter("secondLevelParentCommentId");
		Comment secondLevelParentComment = commentRepository.findById(Long.valueOf(secondLevelParentCommentId)).get();
		if (secondLevelParentComment == null) {
			throw new RuntimeException("null sadfasdfkasd fsd");
		}
		comment.setSecondLevelParentComment(secondLevelParentComment);
		commentRepository.save(comment);
		return HttpStatus.OK;
	}

}
