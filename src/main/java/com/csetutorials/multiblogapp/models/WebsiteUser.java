package com.csetutorials.multiblogapp.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "websiteUsers")
@Getter
@Setter
public class WebsiteUser {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	@JoinColumn(name = "userId")
	User user;

	@ManyToOne
	@JoinColumn(name = "websiteId")
	Website website;

	Role role;

}
