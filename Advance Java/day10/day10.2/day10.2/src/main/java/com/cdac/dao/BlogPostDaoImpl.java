package com.cdac.dao;

import static com.cdac.utils.HibernateUtils.getSessionFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cdac.entities.BlogPost;
import com.cdac.entities.Category;

public class BlogPostDaoImpl implements BlogPostDao {

	@Override
	public String addNewBlogPost(Long categoryId, BlogPost newPost) {
		String mesg="adding blog post failed!!!!!";
		// 1. Get Session from SF
		Session session=getSessionFactory().getCurrentSession();
		//2. Begin a Tx
		Transaction tx=session.beginTransaction();
		try {
			//3. get category from it's id
			Category category=session.get(Category.class, categoryId);
			//4 . null checking
			if(category != null)
			{
				//=> category : persistent
				//5. Establish bi dir association between entities
				/*
				 * add a blog post ref in the List
				 * set category ref to the post
				 */
				category.addBlogPost(newPost);
				session.persist(newPost);	//required since - no cascading still!!!!			
			}	
		
			tx.commit();
			mesg="added new post , id="+newPost.getId();
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
	
		return mesg;
	}

	

}
