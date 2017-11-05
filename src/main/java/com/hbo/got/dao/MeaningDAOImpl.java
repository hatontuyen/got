package com.hbo.got.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hbo.got.entity.Meaning;
import com.hbo.got.util.HibernateUtil;

public class MeaningDAOImpl implements IMeaningDAO {

	public Long save(Meaning meaning) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		Long id = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			id = (Long) session.save(meaning);
			tx.commit();
			session.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			if(tx != null)
				tx.rollback();
			if(session != null)
				session.close();
			
		}
		
		return id;
	}

}
