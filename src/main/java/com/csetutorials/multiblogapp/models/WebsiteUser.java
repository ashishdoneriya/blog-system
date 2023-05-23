package com.csetutorials.multiblogapp.models;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
	@OnDelete(action = OnDeleteAction.CASCADE)
	User user;

	@ManyToOne
	@JoinColumn(name = "websiteId")
	@OnDelete(action = OnDeleteAction.CASCADE)
	Website website;

	Role role;

}
