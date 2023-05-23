package com.csetutorials.multiblogapp.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "comments")
@Getter
@Setter
public class Comment {

	@Id
	@GeneratedValue
	Long id;
	long created;
	long updated;
	String author;
	String email;
	@Column(length = 500)
	String content;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "firstLevelParentId")
	@OnDelete(action = OnDeleteAction.CASCADE)
	Comment firstLevelParentComment;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "firstLevelParentId")
	@OnDelete(action = OnDeleteAction.CASCADE)
	List<Comment> childComments;

	@ManyToOne
	@JoinColumn(name = "secondLevelParentId")
	Comment secondLevelParentComment;


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "postId")
	Post post;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "websiteId")
	Website website;

}
