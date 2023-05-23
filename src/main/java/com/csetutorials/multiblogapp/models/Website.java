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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "websites")
@Getter
@Setter
public class Website {

	@Id
	@GeneratedValue
	Long id;

	@Column
	String name;

	@Column(unique = true)
	String domain;

	@Column
	String description;

	@OneToOne(mappedBy = "website")
	@OnDelete(action = OnDeleteAction.CASCADE)
	WebsiteSetting settings;

	@OneToMany(mappedBy = "website", fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
	List<Post> posts;

	@OneToMany(mappedBy = "website", fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
	List<Page> pages;

	@OneToMany(mappedBy = "website", fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
	List<Category> categories;

	@OneToMany(mappedBy = "website", fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
	List<Tag> tags;

	@OneToMany(mappedBy = "website", fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
	List<Comment> comments;



}
