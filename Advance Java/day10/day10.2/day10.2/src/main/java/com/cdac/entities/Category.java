package com.cdac.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="categories")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
//one , parent table , inverse
public class Category extends BaseEntity {
	@Column(length = 50,unique = true)
	private String name;
	private String description;
	//Category 1---->* BlogPost
	/*
	 * mappedBy - appears in inverse side of the association
	 * mandatory -only in bi dir association
	 * value - name of association prop as it appears 
	 * in the owning side of the association
	 * 
	 */
	@OneToMany (mappedBy="blogPostCategory")//mandatory , o.w causes - MappingException
	private List<BlogPost> posts=new ArrayList<>();
	public Category(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}	
	//add a helper method , to add a child ref in bi dir association
	public void addBlogPost(BlogPost post)
	{
//		category.getPosts().add(newPost);
//		newPost.setBlogPostCategory(category);
		this.posts.add(post);
		post.setBlogPostCategory(this);
	}
	//add a helper method , to remove a child ref in bi dir association
		public void removeBlogPost(BlogPost post)
		{
			this.posts.remove(post);
			post.setBlogPostCategory(null);
		}
}
