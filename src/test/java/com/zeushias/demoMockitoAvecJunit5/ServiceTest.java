package com.zeushias.demoMockitoAvecJunit5;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.zeushias.demoMockitoAvecJunit5.dao.IDao;
import com.zeushias.demoMockitoAvecJunit5.metier.Etudiant;
import com.zeushias.demoMockitoAvecJunit5.service.Service;

class ServiceTest {

	@Test
	void testLectureEtudiant() {
		
		IDao dao = Mockito.mock(IDao.class);
		
		Service service = new Service(dao);
		List<Etudiant> list = new ArrayList<Etudiant>();
		list.add(new Etudiant("OBERLE", "François", "francois@yahoo.fr", "10 rue des fermiers", "01024586","01/02/1990"));
		
		Mockito.when(dao.lireEtudiant()).thenReturn(list);

		List<Etudiant> etudiants = service.lireEtudiant();

		// 4. Comparer le résultat réel avec le résultat attendu

		Assertions.assertEquals(etudiants.get(0).getNom(), "OBERLE");
		Mockito.verify(dao).lireEtudiant();
	}

}
