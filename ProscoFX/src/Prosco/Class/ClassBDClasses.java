package Prosco.Class;



import java.sql.*;

import java.util.*;


public class ClassBDClasses {

	int m_idClasses;
	int m_ECOLES_idEcole;
	int m_nbCreches;
	int m_nbMaternelles;
	int m_nbColleges;
	int m_nbLycee;

		 
	 
	public ClassBDClasses(int ECOLES_idEcole) {
		this.m_ECOLES_idEcole = ECOLES_idEcole;

		try {
			ConnectBD BD = new ConnectBD();
			Vector<Integer> vect_idClasses = new Vector<Integer>();
			int idClasse;
			//VECTOR AVEC ID qui pointe sur vector avec info
			ResultSet res = BD.smt.executeQuery("SELECT IDCLASSES FROM APP.CLASSES WHERE ECOLES_IDECOLE =" + ECOLES_idEcole);
			
			while (res.next())
			{
				idClasse = res.getInt("IDCLASSES");
				vect_idClasses.add(idClasse);
				res.getInt("NB_CRECHES");
				res.getInt("NB_MATERNELLES");
				res.getInt("NB_COLLEGES");
				res.getInt("NB_LYCEES");	
			}
			 
			
		} catch (Exception e) {
			System.out.println("Problème de connexion à la BD : "
					+ e.getMessage());
			e.printStackTrace();
		}

	}
}
