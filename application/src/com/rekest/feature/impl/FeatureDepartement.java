package com.rekest.feature.impl;

import java.util.ArrayList;
import java.util.List;

import com.rekest.dao.IDao;
import com.rekest.dao.impl.DepartementDao;
import com.rekest.entities.Departement;
import com.rekest.exeptions.DAOException;
import com.rekest.feature.IFeature;

import javafx.collections.ObservableList;

public class FeatureDepartement implements IFeature {

	private static IFeature instance = new FeatureDepartement();
	private IDao dao  = DepartementDao.getCurrentInstance();

	public static IFeature getInstance  () {
		return instance;
	}
	
	@Override
	public List<Departement> listerDepartements () throws DAOException   {

		List<Object> objects = dao.list ( Departement.class);
		List<Departement> objs = new ArrayList<> ();
		for (Object obj : objects) {
			if  (obj instanceof Departement) {
				objs.add ( (Departement) obj);
			}
		}
		return objs;
	}

	@Override
	public void clearDepartementList() throws DAOException {
		getCurrentDepartmentObservableList().clear();
	}
	
	@Override
	public void setDepartmentList(List<Departement> departements) throws DAOException {
		clearDepartementList();
		getCurrentDepartmentObservableList().addAll(departements);  
	}

	@Override
	public void supprimerDepartement (Departement departement) throws DAOException {
		  dao.delete (departement);
	}

	@Override
	public void modifierDepartement (Departement departement) throws DAOException {
		  dao.update (departement);
	}

	@Override
	public void creerDepartement (Departement departement) throws DAOException  {
		  dao.save (departement);
	}
	
	@Override
	public ObservableList<Departement> loadDepartementObservableList() throws DAOException {
		dao.list(Departement.class);
        return dao.departementlistObservable();
	}
	
	@Override
	public ObservableList<Departement> getCurrentDepartmentObservableList() throws DAOException {
            return dao.departementlistObservable();
	}

	@Override
	public Departement rechercherDepartement (String whereClause) throws DAOException {
		return  (Departement) dao.find ( Departement.class, whereClause);
	}

	@Override
	public Departement rechercherDepartement (Integer primaryKey) throws DAOException  {

		Departement dep   = new Departement();
		return  (Departement) dao.find ( dep, primaryKey);
	}

}
