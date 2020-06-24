package com.zeushias.demoMockitoAvecJunit5.dao;

import java.util.List;

import com.zeushias.demoMockitoAvecJunit5.metier.Etudiant;
import com.zeushias.demoMockitoAvecJunit5.metier.Utilisateur;

public interface IDao {

	public List<Etudiant> lireEtudiant();
	
	public void creerUtilisateur(Utilisateur utilisateur);
}
