package com.rekest.entities.employes;

import jakarta.persistence.Entity;

@Entity
public class Manager extends Utilisateur {

	public Manager(String nom, String prenom, String telephone, String email, String adresse) {
		super(nom, prenom, telephone, email, adresse);
	}

	public Manager(String nom, String prenom) {
		super(nom, prenom);		
	}

	public Manager() {
		super();
	}

}
