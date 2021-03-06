package com.rekest.dao.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.rekest.dao.IDao;
import com.rekest.entities.Demande;
import com.rekest.entities.Departement;
import com.rekest.entities.Service;
import com.rekest.entities.employes.Employe;
import com.rekest.entities.employes.Utilisateur;
import com.rekest.exeptions.DAOException;
import com.rekest.utils.HibernateSession;

import javafx.collections.ObservableList;


public class HibernateDao implements IDao  {

	public final static Logger logger = LogManager.getLogger(HibernateDao.class);

	private static Session session = null;
	private static Transaction transaction = null;
	private static HibernateDao daoInstance = null;

	protected HibernateDao() {}

	public static HibernateDao getCurrentInstance () {
		if (daoInstance == null) daoInstance = new HibernateDao();
		return daoInstance;
	}

	@Override
	public void save(Object entity) throws DAOException{
		try {
			session = HibernateSession.getSession();
			transaction = session.beginTransaction();
			logger.info("Begin transaction.");// begin transaction
			session.persist(entity);
			transaction.commit();
			logger.info("Record is Successully created");  //  end transaction
		} catch (Exception e) {
			throw new DAOException("ERROR:" + e.getClass() + ":" + e.getMessage());
		}
	}

	@Override
	public void delete(Object entity) throws DAOException{
		try {
			session = HibernateSession.getSession();
			//Creating Transaction Object
			transaction = session.beginTransaction();
			logger.info("Begin transaction.");
			session.remove(entity);
			// Transaction Is Committed To Database
			transaction.commit();
			logger.info("Record is Successfully deleted.");
		} catch (Exception e) {
			throw new DAOException("ERROR:" + e.getClass() + ":" + e.getMessage());
		}
	}

	@Override
	public Object find(Object entityClass, Integer primaryKey) throws DAOException{
		Object entity = null;
		try {
			session = HibernateSession.getSession();
			entity = session.find(entityClass.getClass(), primaryKey);
			if (entity != null) logger.info("Record Successfully read.");
			else logger.info("Record not found.");
		} catch (Exception e) {
			throw new DAOException("ERROR:" + e.getClass() + ":" + e.getMessage());
		}
		return entity;
	}

	@Override
	public Object find(Class<?> entityClass, String whereClause) throws DAOException {
		Object entity = null;
		try {
			session = HibernateSession.getSession();							
			@SuppressWarnings("deprecation")
			Query<?> query = session.createQuery("From " + entityClass.getName() + " " + whereClause); 
			entity = query.getSingleResult();
			if (entity != null) logger.info("Record Successfully read.");
			else logger.info("Record not found.");
		} catch (Exception e) {
			throw new DAOException("ERROR:" + e.getClass() + ":" + e.getMessage());
		}
		return entity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> list(Class<?> entityClass, String whereClause) throws DAOException {
		List<Object> entities = null;
		try {
			session = HibernateSession.getSession();
			@SuppressWarnings("deprecation")
			Query<?> query = session.createQuery("From " + entityClass.getName() + " " + whereClause); 
			entities = (List<Object>) query.getResultList();

			if (entities != null) logger.info("Records Successfully read.");
			else logger.info("Records not found.");
		} catch (Exception e) {
			throw new DAOException("ERROR:" + e.getClass() + ":" + e.getMessage());
		}
		return entities;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> list (Object entityClass) throws DAOException{
		List<Object> entities = null;
		try {
			session = HibernateSession.getSession();
			@SuppressWarnings("deprecation")
			Query<?> query = session.createQuery("From " + entityClass.getClass().getSimpleName());
			entities = (List<Object>) query.getResultList();
			if (entities != null) logger.info("Records Successfully read.");
			else logger.info("Records not found.");
		} catch (Exception e) {
			throw new DAOException("ERROR:" + e.getClass() + ":" + e.getMessage());
		}
		return entities;
	}

	@Override
	public void update(Object entity) throws DAOException {
		try {
			session = HibernateSession.getSession();
			//Creating Transaction Object  
			transaction = session.beginTransaction();
			logger.info("Begin transaction.");
			session.persist(entity);
			// Transaction Is Committed To Database
			transaction.commit();
			logger.info("Record Successfully updated.");
		} catch (Exception e) {
			throw new DAOException("ERROR:" + e.getClass() + ":" + e.getMessage());
		}
	}

	@Override
	public void enableAccount(Utilisateur entity) throws DAOException{
		entity.setEnable(true);
		this.update(entity);
	}

	@Override
	public void disableAccount(Utilisateur entity) throws DAOException{
		entity.setEnable(false);
		this.update(entity);

	}

	@Override
	public void associateService(Employe employe, Service service) throws DAOException{
		service.addEmploye(employe);
		this.update(service);
	}

	@Override
	public Object validateCredential(String login, String password)  throws DAOException{
		Object utilisateur = null;
		try {
			String whereClause = "where login = " + "'"+login+"'"+ " and password = " +"'"+password+"'"; 
			session = HibernateSession.getSession();
			@SuppressWarnings("deprecation")
			Query<?> query = session.createQuery("From Utilisateur " + whereClause); 
			utilisateur =  query.uniqueResult();
			if (utilisateur != null) logger.info("Utilisateur trouver !");
			else logger.info("utilisateur non");
		} catch (Exception e) {
			throw new DAOException("ERROR:" + e.getClass() + ":" + e.getMessage());
		}

		return utilisateur;
	}
	
	@Override
	public void requestResponse(Demande demande, String reponse) throws DAOException {
		demande.setEtat(reponse);
		this.update(demande);
	}

	public static void closeSession() {
		HibernateSession.close();		
	}

	@Override
	public ObservableList<Departement> departementlistObservable() throws DAOException {
		return null;
	}

}