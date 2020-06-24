package com.zeushias.demoMockitoAvecJunit5.dao;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zeushias.demoMockitoAvecJunit5.metier.Etudiant;
import com.zeushias.demoMockitoAvecJunit5.metier.Utilisateur;

public class Dao implements IDao {

	public static String password = "root";

	// information de la base de donnee

	static String url = "jdbc:mysql://localhost/ges_ecole_ensup";
	static String login = "root";

	static Connection cn = null;
	static Statement st = null;
	static ResultSet rs = null;

	/**
	 * liste des  étudiants
	 */
	public List<Etudiant> lireEtudiant() {
		
		List<Etudiant> list = new ArrayList<Etudiant>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			st = getConnexion();
			String sql = "select * from personne";

			// etape 4 executer la requette
			System.out.println("Liste des etudiants ");
			rs = st.executeQuery(sql);

			// etape5 parcours du resultSet
			
			while (rs.next()) {
				Etudiant etudiant = new Etudiant(rs.getInt("idPersonne"), rs.getString("nom"), rs.getString("prenom"),
						rs.getString("email"), rs.getString("adresse"), rs.getString("telephone"),
						rs.getString("date_naissance"));
				list.add(etudiant);
			}
			list.stream().forEach(System.out::println);

		} catch (SQLException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} finally {

			// etape 5 liberer les ressources
			try {
				cn.close();
				st.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return list;
	}

	public void creerUtilisateur(Utilisateur utilisateur) {

	}

	private Statement getConnexion() {

		try {
			cn = DriverManager.getConnection(url, login, password);

			// etape 3 creation du statement
			st = cn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return st;
	}

}
