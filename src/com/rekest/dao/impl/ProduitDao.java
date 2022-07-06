package com.rekest.dao.impl;

import java.util.List;

import com.rekest.entities.Departement;
import com.rekest.exeptions.DAOException;
import com.rekest.observableList.impl.ObservableListDepartement;

import javafx.collections.ObservableList;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProduitDao extends HibernateDao {

	private ObservableListDepartement departmentData;
	private static ProduitDao daoInstance = null;

	private ProduitDao() {
		departmentData = new ObservableListDepartement();
	}
	
	public static ProduitDao getCurrentInstance () {
		if (daoInstance == null) daoInstance = new ProduitDao();
		return daoInstance;
	}

	@Override
	public void save(Object entity) throws DAOException {
		super.save(entity);
		departmentData.add((Departement) entity);
	}

	@Override
	public void delete(Object entity) throws DAOException {
		super.delete(entity);
		departmentData.delete((Departement) entity);
	}

	@Override
	public List<Object> list(Object entityClass) throws DAOException {
		departmentData.clear();
		departmentData.addAll(super.list(entityClass));
		System.out.println("Callinggggggggggggggggggggggggggg");
		return super.list(entityClass);
	}

	
	@Override
	public ObservableList<Departement> departementlistObservable() throws DAOException {
	    return this.departmentData.getData();
	}
	
}