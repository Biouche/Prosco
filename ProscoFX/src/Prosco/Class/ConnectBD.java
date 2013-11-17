/**
 * \file          ConnectBD.java
 * \author    bfaliu
 * \version   1.0
 * \date       29/09/2013
 * \brief      Classe qui permet de cr�er la connexion aux bases de donn�es
 *
 */

package Prosco.Class;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectBD {

	ResultSet res;
	Statement smt;

	public ConnectBD() {

		try {
			// Chargement du pilote JDBC org.apache.derby.jdbc.EmbeddedDriver
			Class driverClass = Class
					.forName("org.apache.derby.jdbc.EmbeddedDriver");
			DriverManager.registerDriver((Driver) driverClass.newInstance());

			// Connexion � la base tp_jdbc, dans le r�pertoire local du projet
			Connection con = DriverManager.getConnection("jdbc:derby:BD/BD1");

			// Utilisation de la connexion de fa�on classique
			smt = con.createStatement();
			
		}

		catch (Exception e) {
			System.out.println("Probl�me de connexion � la BD : "
					+ e.getMessage());
			e.printStackTrace();
		}

	} // ConectBD

	public ResultSet setQuery(String Query) throws SQLException {
		// R�cup�ration des informations voulues
		res = smt.executeQuery(Query);
		return res;
	}

}
