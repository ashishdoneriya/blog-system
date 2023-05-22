package com.csetutorials.multiblogapp.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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

	String name;

	String domain;

	String description;

	int pageSize = 10;

	@OneToMany(mappedBy = "website", fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
	List<WebsiteUser> websiteUsers;

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


}
