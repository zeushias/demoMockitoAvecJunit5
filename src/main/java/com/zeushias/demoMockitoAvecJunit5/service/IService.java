package com.zeushias.demoMockitoAvecJunit5.service;

import java.util.List;

import com.zeushias.demoMockitoAvecJunit5.metier.Etudiant;
import com.zeushias.demoMockitoAvecJunit5.metier.Utilisateur;

public interface IService {

	public List<Etudiant> lireEtudiant();

	public void creerUtilisateur(Utilisateur utilisateur);
}
