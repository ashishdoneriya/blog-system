package com.csetutorials.multiblogapp.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "posts")
@Getter
@Setter
public class Post {

	@Id
	@GeneratedValue
	Long id;
	String title;
	Long created;
	Long updated;
	@ManyToOne
	@JoinColumn(name = "authorId")
	User author;
	String description;
	String slug;
	@Basic(fetch = FetchType.LAZY)
	@Column(length = 5000)
	String content;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "postCategories",
			joinColumns = @JoinColumn(name = "postId"),
			inverseJoinColumns = @JoinColumn(name = "categoryId"))
	@OnDelete(action = OnDeleteAction.CASCADE)
	List<Category> categories;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "postTags",
			joinColumns = @JoinColumn(name = "postId"),
			inverseJoinColumns = @JoinColumn(name = "tagId"))
	@OnDelete(action = OnDeleteAction.CASCADE)
	List<Tag> tags;

	@OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
	List<Comment> comments;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "websiteId")
	Website website;


}
