package com.zeushias.demoMockitoAvecJunit5.service;

import java.util.List;

import com.zeushias.demoMockitoAvecJunit5.dao.IDao;
import com.zeushias.demoMockitoAvecJunit5.metier.Etudiant;
import com.zeushias.demoMockitoAvecJunit5.metier.Utilisateur;

public class Service implements IService {
	
	private IDao dao;
	
	

	public Service(IDao dao) {
		super();
		this.dao = dao;
	}

	public List<Etudiant> lireEtudiant() {
		return dao.lireEtudiant();
	}

	public void creerUtilisateur(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		
	}

}
