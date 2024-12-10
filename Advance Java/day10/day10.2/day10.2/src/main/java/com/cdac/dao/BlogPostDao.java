package com.cdac.dao;

import com.cdac.entities.BlogPost;

public interface BlogPostDao {
//add new blog post to existing category
	String addNewBlogPost(Long categoryId,BlogPost newPost);
}
