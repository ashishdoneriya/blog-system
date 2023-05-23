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

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User user;
}
