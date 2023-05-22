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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "tags")
@Getter
@Setter
public class Tag {

	@Id
	@GeneratedValue
	Long id;
	String slug;
	String name;

	@ManyToMany(mappedBy = "tags", fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Post> posts;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "websiteId")
	Website website;
}
