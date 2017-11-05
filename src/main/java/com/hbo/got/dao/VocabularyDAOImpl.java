package com.hbo.got.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hbo.got.entity.Vocabulary;
import com.hbo.got.util.HibernateUtil;



public class VocabularyDAOImpl  implements IVocabularyDAO {

	public Long save(Vocabulary voca) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		Long id = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			//
			id = (Long) session.save(voca);
			//
			tx.commit();
			session.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			if(tx!=null)
				tx.rollback();
			if(session !=null) 
				session.close();
		}
		return id;
	}

	@SuppressWarnings("rawtypes")
	public Vocabulary findByVoca(String voca) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		List result = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			result = session.createQuery("from "+Vocabulary.ENTITY_NAME).list();
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
		if(result != null && result.size() >0) {
			return (Vocabulary) result.get(0);
		}
		return null;

	}

	@SuppressWarnings("unchecked")
	public List<Vocabulary> findAll() {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		List result = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			result = session.createQuery("from "+Vocabulary.ENTITY_NAME).list();
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
		return result;

	}
	
	
}
