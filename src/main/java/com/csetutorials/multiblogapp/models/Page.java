package com.csetutorials.multiblogapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pages")
@Getter
@Setter
public class Page {

	@Id
	@GeneratedValue
	Long id;
	String title;
	Long created;
	Long updated;
	@ManyToOne
	@JoinColumn(name = "authorId")
	User author;
	String slug;
	@Basic(fetch = FetchType.LAZY)
	String content;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "websiteId")
	Website website;

}
