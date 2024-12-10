package com.cdac.dao;

import com.cdac.entities.Category;
import org.hibernate.*;
import static com.cdac.utils.HibernateUtils.getSessionFactory;

public class CategoryDaoImpl implements CategoryDao {

	@Override
	public String addNewCategory(Category category) {
		String mesg="adding category failed!!!";
		// 1. Get Session from SF
		Session session=getSessionFactory().getCurrentSession();
		//2. Begin a Tx
		Transaction tx=session.beginTransaction();
		try {
			session.persist(category);
			tx.commit();
			mesg="added new category with id="+category.getId();
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
	
		return mesg;
	}

}
