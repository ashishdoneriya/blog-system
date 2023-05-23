package com.csetutorials.multiblogapp.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Basic;
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
@Table(name = "pages")
@Getter
@Setter
public class Page {

	@Id
	@GeneratedValue
	Long id;
	String slug;
	String title;
	Long created;
	Long updated;

	@Basic(fetch = FetchType.LAZY)
	@Column(length = 5000)
	String content;

	@ManyToOne
	@JoinColumn(name = "authorId")
	User author;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "websiteId")
	Website website;

}
