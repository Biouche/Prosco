package Prosco.Class;



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
			Vector vect = new Vector () ;
			//VECTOR AVEC ID qui pointe sur vector avec info 
		} catch (Exception e) {
			System.out.println("Problème de connexion à la BD : "
					+ e.getMessage());
			e.printStackTrace();
		}

	}
}
