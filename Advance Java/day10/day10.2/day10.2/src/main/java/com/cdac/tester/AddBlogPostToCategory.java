package com.cdac.tester;

import static com.cdac.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.dao.BlogPostDao;
import com.cdac.dao.BlogPostDaoImpl;
import com.cdac.entities.BlogPost;

public class AddBlogPostToCategory {

	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory();
				Scanner sc = new Scanner(System.in)) {
			// create blog post  dao instance
			BlogPostDao blogPostDao=new BlogPostDaoImpl();
			System.out.println("Enter category id");
			Long categoryId=sc.nextLong();
			System.out.println("Enter blog post details - title,  description,  contents");
			//create transient blog post
			BlogPost post=new BlogPost(sc.next(), sc.next(), sc.next());
			System.out.println(blogPostDao.addNewBlogPost(categoryId, post));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
