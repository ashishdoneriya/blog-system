package com.csetutorials.multiblogapp.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "websiteSettings")
@Getter
@Setter
public class WebsiteSetting {

	@Id
	@GeneratedValue
	Long id;

	int pageSize = 10;

	@OneToOne
	@JoinColumn(name = "websiteId")
	Website website;

}
