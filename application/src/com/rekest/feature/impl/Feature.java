package com.rekest.feature.impl;

import java.util.ArrayList;
import java.util.List;

import com.rekest.dao.impl.HibernateDao;
import com.rekest.entities.Demande;
import com.rekest.entities.Departement;
import com.rekest.entities.Note;
import com.rekest.entities.Produit;
import com.rekest.entities.Role;
import com.rekest.entities.Service;
import com.rekest.entities.employes.Employe;
import com.rekest.entities.employes.Manager;
import com.rekest.entities.employes.Utilisateur;
import com.rekest.exeptions.DAOException;
import com.rekest.feature.IFeature;
import com.rekest.observableList.impl.ObservableListDemande;
import com.rekest.observableList.impl.ObservableListDepartement;
import com.rekest.observableList.impl.ObservableListEmploye;
import com.rekest.observableList.impl.ObservableListManager;
import com.rekest.observableList.impl.ObservableListNote;
import com.rekest.observableList.impl.ObservableListProduit;
import com.rekest.observableList.impl.ObservableListRole;
import com.rekest.observableList.impl.ObservableListService;
import com.rekest.observableList.impl.ObservableListUtilisateur;

import javafx.collections.ObservableList;

public class Feature implements IFeature {

	
	private static Feature instance = null;
	
	private Feature () {}

	public static Feature getCurrentInstance () {
		if (instance == null) instance = new Feature ();
		return instance;
	}
	
	public ObservableListDepartement OLDepartement = new ObservableListDepartement();
	public ObservableListEmploye OLEmploye = new ObservableListEmploye();
	public ObservableListProduit OLProduit = new ObservableListProduit();
	public ObservableListService OLService = new ObservableListService();
	public ObservableListRole OLRole = new ObservableListRole();
	public ObservableListDemande OLDemande = new ObservableListDemande();
	public ObservableListManager OLManager = new ObservableListManager();
	public ObservableListNote OLNote = new ObservableListNote();
	public ObservableListUtilisateur OLUtilisateur = new ObservableListUtilisateur();


	@Override
	public List<Departement> listerDepartements ()   {

		List<Object> objects;
		List<Departement> objs = new ArrayList<> ();
		try {
			objects = HibernateDao.getCurrentInstance ().list ( new Departement());
			
			for (Object obj : objects) {
				if (obj instanceof Departement) {
					objs.add ( (Departement) obj);
				}
			}
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objs;
	}

	@Override
	public List<Departement> listerDepartements (String whereClause)  {
		
		List<Object> objects;
		List<Departement> objs = new ArrayList<> ();
		try {
			objects = HibernateDao.getCurrentInstance ().list ( Departement.class, whereClause);
			for (Object obj : objects) {
				if (obj instanceof Departement) {
					objs.add ( (Departement) obj);
				}
			}
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		return objs;
	}

	@Override
	public boolean supprimerDepartement (Departement departement)   {
		 try {
			HibernateDao.getCurrentInstance ().delete ( departement);
			loadDepartementsObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean modifierDepartement (Departement departement)   {

		try {
			HibernateDao.getCurrentInstance ().update ( departement);
			loadDepartementsObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean creerDepartement (Departement departement)   {
	
		try {
			HibernateDao.getCurrentInstance ().save ( departement);
			loadDepartementsObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		
	}


	
	@Override
	public Departement rechercherDepartement (String whereClause)   {
		
		try {
			return (Departement) HibernateDao.getCurrentInstance ().find (  Departement.class, whereClause);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Departement rechercherDepartement (Integer primaryKey)  {
		try {
			return (Departement) HibernateDao.getCurrentInstance ().find ( new Departement ( ) , primaryKey);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}



	@Override
	public boolean activerUtilisateur (Utilisateur utilisateur)   {
		
		try {
			HibernateDao.getCurrentInstance ().enableAccount (utilisateur);
			loadUtilisateursObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean desactiverUtilisateur (Utilisateur utilisateur)   {
		
		try {
			HibernateDao.getCurrentInstance ().disableAccount (utilisateur);
			loadUtilisateursObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	/*
	@Override
	public boolean rafraichirUtilisateur (Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return HibernateDao.getCurrentInstance ().;
	}
	*/

	@Override
	public List<Utilisateur> listerUtilisateurs ()   {

		List<Object> objects;
		List<Utilisateur> objs = new ArrayList<> ();
		try {
			objects = HibernateDao.getCurrentInstance ().list ( new Utilisateur());
			
			for (Object obj : objects) {
				if (obj instanceof Utilisateur) {
					objs.add ( (Utilisateur) obj);
				}
			}
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objs;
	}

	@Override
	public List<Utilisateur> listerUtilisateurs (String whereClause)  {
		
		List<Object> objects;
		List<Utilisateur> objs = new ArrayList<> ();
		try {
			objects = HibernateDao.getCurrentInstance ().list ( Utilisateur.class, whereClause);
			for (Object obj : objects) {
				if (obj instanceof Utilisateur) {
					objs.add ( (Utilisateur) obj);
				}
			}
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		return objs;
	}

	@Override
	public boolean supprimerUtilisateur (Utilisateur utilisateur)   {
		 try {
			HibernateDao.getCurrentInstance ().delete ( utilisateur);
			loadUtilisateursObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean modifierUtilisateur (Utilisateur utilisateur)   {

		try {
			HibernateDao.getCurrentInstance ().update ( utilisateur);
			loadUtilisateursObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean creerUtilisateur (Utilisateur utilisateur)   {
	
		try {
			HibernateDao.getCurrentInstance ().save ( utilisateur);
			loadUtilisateursObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		
	}


	
	@Override
	public Utilisateur rechercherUtilisateur (String whereClause)   {
		
		try {
			return (Utilisateur) HibernateDao.getCurrentInstance ().find (  Utilisateur.class, whereClause);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Utilisateur rechercherUtilisateur (Integer primaryKey)  {
		try {
			return (Utilisateur) HibernateDao.getCurrentInstance ().find ( new Utilisateur ( ) , primaryKey);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Role> listerRoles ()   {

		List<Object> objects;
		List<Role> objs = new ArrayList<> ();
		try {
			objects = HibernateDao.getCurrentInstance ().list ( new Role());
			
			for (Object obj : objects) {
				if (obj instanceof Role) {
					objs.add ( (Role) obj);
				}
			}
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objs;
	}

	@Override
	public List<Role> listerRoles (String whereClause)  {
		
		List<Object> objects;
		List<Role> objs = new ArrayList<> ();
		try {
			objects = HibernateDao.getCurrentInstance ().list ( Role.class, whereClause);
			for (Object obj : objects) {
				if (obj instanceof Role) {
					objs.add ( (Role) obj);
				}
			}
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		return objs;
	}

	@Override
	public boolean supprimerRole (Role role)   {
		 try {
			HibernateDao.getCurrentInstance ().delete ( role);
			loadRoleObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean modifierRole (Role role)   {

		try {
			HibernateDao.getCurrentInstance ().update ( role);
			loadRoleObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean creerRole (Role role)   {
	
		try {
			HibernateDao.getCurrentInstance ().save ( role);
			loadRoleObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		
	}


	
	@Override
	public Role rechercherRole (String whereClause)   {
		
		try {
			return (Role) HibernateDao.getCurrentInstance ().find (  Role.class, whereClause);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Role rechercherRole (Integer primaryKey)  {
		try {
			return (Role) HibernateDao.getCurrentInstance ().find ( new Role ( ) , primaryKey);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Manager> listerManagers ()   {

		List<Object> objects;
		List<Manager> objs = new ArrayList<> ();
		try {
			objects = HibernateDao.getCurrentInstance ().list ( new Manager());
			
			for (Object obj : objects) {
				if (obj instanceof Manager) {
					objs.add ( (Manager) obj);
				}
			}
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objs;
	}

	@Override
	public List<Manager> listerManagers (String whereClause)  {
		
		List<Object> objects;
		List<Manager> objs = new ArrayList<> ();
		try {
			objects = HibernateDao.getCurrentInstance ().list ( Manager.class, whereClause);
			for (Object obj : objects) {
				if (obj instanceof Manager) {
					objs.add ( (Manager) obj);
				}
			}
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objs;
	}

	@Override
	public boolean supprimerManager (Manager manager)   {
		 try {
			HibernateDao.getCurrentInstance ().delete ( manager);
			loadManagerObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean modifierManager (Manager manager)   {

		try {
			HibernateDao.getCurrentInstance ().update ( manager);
			loadManagerObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean creerManager (Manager manager)   {
	
		try {
			HibernateDao.getCurrentInstance ().save ( manager);
			loadManagerObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		
	}


	
	@Override
	public Manager rechercherManager (String whereClause)   {
		
		try {
			return (Manager) HibernateDao.getCurrentInstance ().find (  Manager.class, whereClause);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Manager rechercherManager (Integer primaryKey)  {
		try {
			return (Manager) HibernateDao.getCurrentInstance ().find ( new Manager ( ) , primaryKey);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Employe> listerEmployes ()   {

		List<Object> objects;
		List<Employe> objs = new ArrayList<> ();
		try {
			objects = HibernateDao.getCurrentInstance ().list ( new Employe());
			
			for (Object obj : objects) {
				if (obj instanceof Employe) {
					objs.add ( (Employe) obj);
				}
			}
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objs;
	}

	@Override
	public List<Employe> listerEmployes (String whereClause)  {
		
		List<Object> objects;
		List<Employe> objs = new ArrayList<> ();
		try {
			objects = HibernateDao.getCurrentInstance ().list ( Employe.class, whereClause);
			for (Object obj : objects) {
				if (obj instanceof Employe) {
					objs.add ( (Employe) obj);
				}
			}
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		return objs;
	}

	@Override
	public boolean supprimerEmploye (Employe employe)   {
		 try {
			HibernateDao.getCurrentInstance ().delete ( employe);
			loadEmployesObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			System.err.println("BLEM EMPLOYE");
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean modifierEmploye (Employe employe)   {

		try {
			HibernateDao.getCurrentInstance ().update ( employe);
			loadEmployesObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean creerEmploye (Employe employe)   {
	
		try {
			HibernateDao.getCurrentInstance ().save ( employe);
			loadEmployesObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		
	}


	
	@Override
	public Employe rechercherEmploye (String whereClause)   {
		
		try {
			return (Employe) HibernateDao.getCurrentInstance ().find (  Employe.class, whereClause);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Employe rechercherEmploye (Integer primaryKey)  {
		try {
			return (Employe) HibernateDao.getCurrentInstance ().find ( new Employe ( ) , primaryKey);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Service> listerServices ()   {

		List<Object> objects;
		List<Service> objs = new ArrayList<> ();
		try {
			objects = HibernateDao.getCurrentInstance ().list ( new Service());
			
			for (Object obj : objects) {
				if (obj instanceof Service) {
					objs.add ( (Service) obj);
				}
			}
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objs;
	}

	@Override
	public List<Service> listerServices (String whereClause)  {
		
		List<Object> objects;
		List<Service> objs = new ArrayList<> ();
		try {
			objects = HibernateDao.getCurrentInstance ().list ( Service.class, whereClause);
			for (Object obj : objects) {
				if (obj instanceof Service) {
					objs.add ( (Service) obj);
				}
			}
			
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		return objs;
	}

	@Override
	public boolean supprimerService (Service service)   {
		 try {
			HibernateDao.getCurrentInstance ().delete ( service);
			loadServicesObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean modifierService (Service service)   {

		try {
			HibernateDao.getCurrentInstance ().update ( service);
			loadServicesObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean creerService (Service service)   {
	
		try {
			HibernateDao.getCurrentInstance ().save ( service);
			loadServicesObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		
	}


	
	@Override
	public Service rechercherService (String whereClause)   {
		
		try {
			return (Service) HibernateDao.getCurrentInstance ().find (  Service.class, whereClause);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Service rechercherService (Integer primaryKey)  {
		try {
			return (Service) HibernateDao.getCurrentInstance ().find ( new Service ( ) , primaryKey);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Produit> listerProduits ()   {

		List<Object> objects;
		List<Produit> objs = new ArrayList<> ();
		try {
			objects = HibernateDao.getCurrentInstance ().list ( new Produit());
			
			for (Object obj : objects) {
				if (obj instanceof Produit) {
					objs.add ( (Produit) obj);
				}
			}
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objs;
	}

	@Override
	public List<Produit> listerProduits (String whereClause)  {
		
		List<Object> objects;
		List<Produit> objs = new ArrayList<> ();
		try {
			objects = HibernateDao.getCurrentInstance ().list ( Produit.class, whereClause);
			for (Object obj : objects) {
				if (obj instanceof Produit) {
					objs.add ( (Produit) obj);
				}
			}
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		return objs;
	}

	@Override
	public boolean supprimerProduit (Produit produit)   {
		 try {
			HibernateDao.getCurrentInstance ().delete ( produit);
			loadProduitsObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean modifierProduit (Produit produit)   {

		try {
			HibernateDao.getCurrentInstance ().update ( produit);
			loadProduitsObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean creerProduit (Produit produit)   {
	
		try {
			HibernateDao.getCurrentInstance ().save ( produit);
			loadProduitsObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		
	}


	
	@Override
	public Produit rechercherProduit (String whereClause)   {
		
		try {
			return (Produit) HibernateDao.getCurrentInstance ().find (  Produit.class, whereClause);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Produit rechercherProduit (Integer primaryKey)  {
		try {
			return (Produit) HibernateDao.getCurrentInstance ().find ( new Produit ( ) , primaryKey);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Note> listerNotes ()    {
		Note truc = new Note();
		List<Note> objs = new ArrayList<> ();
		List<Object> objects;
		try {
			objects = HibernateDao.getCurrentInstance ().list ( truc);
			for  (Object obj : objects) {
				if  (obj instanceof Note) {
					objs.add (  (Note) obj);
				}
			}
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		return objs;
	}

	@Override
	public List<Note> listerNotes (String whereClause)   {

		List<Object> objects;
		List<Note> objs = new ArrayList<> ();
		try {
			objects = HibernateDao.getCurrentInstance ().list ( Note.class, whereClause);
			for  (Object obj : objects) {
				if  (obj instanceof Note) {
					objs.add (  (Note) obj);
				}
			}
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objs;
		
	}

	@Override
	public boolean supprimerNote (Note note)   {
		
		try {
			HibernateDao.getCurrentInstance ().delete ( note);
			loadNoteObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
	}

	@Override
	public boolean modifierNote (Note note)   {
		
		 try {
			HibernateDao.getCurrentInstance ().update ( note);
			loadNoteObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean creerNote (Note note)   {

		 try {
			HibernateDao.getCurrentInstance ().save ( note); 
			loadNoteObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public Note rechercherNote (String whereClause)   {
		
		try {
			return   (Note) HibernateDao.getCurrentInstance ().find ( Note.class, whereClause);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Note rechercherNote (Integer primaryKey)   {


		try {
			return   (Note) HibernateDao.getCurrentInstance ().find ( new Note(), primaryKey);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	@Override
	public List<Demande> listerDemandes ()    {
		
		List<Demande> objs = new ArrayList<> ();
		List<Object> objects;
		try {
			objects = HibernateDao.getCurrentInstance ().list ( new Demande());
			for  (Object obj : objects) {
				if  (obj instanceof Demande) {
					objs.add (  (Demande) obj);
				}
			}
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return objs;
	}

	@Override
	public List<Demande> listerDemandes (String whereClause)   {

		List<Object> objects;
		List<Demande> objs = new ArrayList<> ();
		try {
			objects = HibernateDao.getCurrentInstance ().list ( Demande.class, whereClause);
			
			for  (Object obj : objects) {
				if  (obj instanceof Demande) {
					objs.add (  (Demande) obj);
				}
			}
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return objs;
		
	}

	@Override
	public boolean supprimerDemande (Demande demande)   {
		
		try {
			HibernateDao.getCurrentInstance ().delete ( demande);
			loadDemandesObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean modifierDemande (Demande demande)   {
		
		 try {
			HibernateDao.getCurrentInstance ().update ( demande);
			loadDemandesObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean creerDemande (Demande demande)   {
		 try {
			HibernateDao.getCurrentInstance ().save ( demande);
			loadDemandesObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
	}

	@Override
	public Demande rechercherDemande (String whereClause)   {
		try {
			return   (Demande) HibernateDao.getCurrentInstance ().find ( Demande.class, whereClause);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Demande rechercherDemande (Integer primaryKey)   {
		
		try {
			return   (Demande) HibernateDao.getCurrentInstance ().find ( new Demande(), primaryKey);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getTheDaoImplementationClassname () {
		return null;
	}
	

	@Override
	public Integer RetournerNombreDemandesTotal () {
		return listerDemandes().size();
	}

	@Override
	public Integer RetournerNombreEmployesTotal () {
		return listerEmployes().size();
	}

	@Override
	public Integer RetournerNombreDepartementsTotal () {
		return listerDepartements().size();
	}

	@Override
	public Integer RetournerNombreServicesTotal () {
		return listerServices().size();
	}

	@Override
	public Integer RetournerNombreProduitsTotal () {
		return listerProduits().size();
	}
	
	@Override
	public ObservableList<Role> loadRoleObservableList()   {

	
		try {
			OLRole.clear();
			OLRole.addAll(  HibernateDao.getCurrentInstance ().list ( new Role() ));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return OLRole.getData();
		
	}

	@Override
	public ObservableList<Produit> loadProduitsObservableList()   {

		try {
			OLProduit.clear();
			OLProduit.addAll(  HibernateDao.getCurrentInstance ().list ( new Produit() ));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return OLProduit.getData();
		
	}

	@Override
	public ObservableList<Service> loadServicesObservableList()   {

		try {
			OLService.clear();
			OLService.addAll(  HibernateDao.getCurrentInstance ().list ( new Service() ));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return OLService.getData();
	}

	@Override
	public ObservableList<Departement> loadDepartementsObservableList()   {
		
		
		try {
			OLDepartement.clear();
			OLDepartement.addAll(  HibernateDao.getCurrentInstance ().list ( new Departement() ));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return OLDepartement.getData();
	}

	@Override
	public ObservableList<Demande> loadDemandesObservableList ()  {
		
		try {
			OLDemande.clear();
			OLDemande.addAll(  HibernateDao.getCurrentInstance ().list ( new Demande() ));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return OLDemande.getData();
	}

	@Override
	public ObservableList<Employe> loadEmployesObservableList ()  {
		
		try {
			OLEmploye.clear();
			OLEmploye.addAll(  HibernateDao.getCurrentInstance ().list ( new Employe() ));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return OLEmploye.getData();
	}


	@Override
	public ObservableList<Demande> loadDemandesByServiceObservableList (Service service)  {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ObservableList<Demande> loadDemandesByDirectionObservableList (Object direction)   {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ObservableList<Manager> loadManagerObservableList() {
		
		/*try {
			OLManager.clear();
			OLManager.addAll(  HibernateDao.getCurrentInstance ().list ( new Manager() ));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		return OLManager.getData();
	}

	@Override
	public ObservableList<Note> loadNoteObservableList() {
		
		try {
			OLNote.clear();
			OLNote.addAll(  HibernateDao.getCurrentInstance ().list ( new Note() ));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return OLNote.getData();
	}
	
	@Override
	public ObservableList<Utilisateur> loadUtilisateursObservableList() {
		
		try {
			OLUtilisateur.clear();
			OLUtilisateur.addAll(  HibernateDao.getCurrentInstance ().list ( new Utilisateur() ));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return OLUtilisateur.getData();
	}
	@Override
	public boolean repondreDemande (Demande demande, String reponse)    {
		try {
			HibernateDao.getCurrentInstance ().requestResponse (demande, reponse);
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
	}

	@Override
	public Object validerIdentifiants(String login, String password)   {
		
		Object obj = new Object();
		
		try {
			obj = HibernateDao.getCurrentInstance().validateCredential( login,  password);
			
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public boolean associerService(Employe employe, Service service)   {
		
		try {
			HibernateDao.getCurrentInstance().associateService( employe, service) ;
			loadEmployesObservableList();
			return true;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}






/*
 * 
 * 
 * 
 * 
	@Override
	public boolean setDemandeList (List<Demande> demandes) {
		clearDemandeList ();
		getCurrentDemandeObservableList ().addAll (demandes);    
	}
	
		@Override
	public boolean setProduitList (List<Produit> produits) {
		clearProduitList ();
		getCurrentProduitObservableList ().addAll (produits);    
	}
	
		@Override
	public boolean setEmployeList (List<Employe> employes) {
		clearEmployeList ();
		getCurrentEmployeObservableList ().addAll (employes);    
	}
	
		@Override
	public boolean setServiceList (List<Service> services) {
		clearServiceList ();
		getCurrentServiceObservableList ().addAll (services);    
	}
		
		@Override
	public boolean setServiceList (List<Service> services) {
		clearServiceList ();
		getCurrentServiceObservableList ().addAll (services);    
	}
		
		@Override
	public boolean setServiceList (List<Service> services) {
		clearServiceList ();
		getCurrentServiceObservableList ().addAll (services);    
	}
	
	
 */
	

}
