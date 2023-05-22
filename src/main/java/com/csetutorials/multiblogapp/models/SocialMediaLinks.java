package com.csetutorials.multiblogapp.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "socialMediaLinks")
@Getter
@Setter
public class SocialMediaLinks {

	@Id
	@GeneratedValue
	Long id;
	@Column
	String facebookUrl;
	@Column
	String twitterUrl;
	@Column
	String instagramUrl;
	@Column
	String linkedIn;
	@Column
	String myspace;
	@Column
	String pinterest;
	@Column
	String youtube;
	@Column
	String wikipedia;

	@OneToOne
	@JoinColumn(name = "userId")
	private User user;
}
