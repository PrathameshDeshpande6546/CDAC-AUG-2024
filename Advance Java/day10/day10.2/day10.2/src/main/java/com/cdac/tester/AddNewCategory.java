package com.cdac.tester;

import static com.cdac.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.dao.CategoryDao;
import com.cdac.dao.CategoryDaoImpl;
import com.cdac.dao.UserDao;
import com.cdac.dao.UserDaoimpl;
import com.cdac.entities.Category;

public class AddNewCategory {

	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory();
				Scanner sc = new Scanner(System.in)) {
			// create category dao instance
			CategoryDao categoryDao=new CategoryDaoImpl();
			System.out.println("Enter category name n desc");
			Category category=new Category(sc.next(), sc.next());
			System.out.println(categoryDao.addNewCategory(category));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
