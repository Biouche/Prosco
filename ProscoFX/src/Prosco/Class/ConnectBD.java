/**
 * \file          ConnectBD.java
 * \author    bfaliu
 * \version   1.0
 * \date       29/09/2013
 * \brief      Classe qui permet de créer la connexion aux bases de données
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

			// Connexion à la base tp_jdbc, dans le répertoire local du projet
			Connection con = DriverManager.getConnection("jdbc:derby:BD/BD1");

			// Utilisation de la connexion de façon classique
			smt = con.createStatement();
		}

		catch (Exception e) {
			System.out.println("Problème de connexion à la BD : "
					+ e.getMessage());
			e.printStackTrace();
		}

	} // ConectBD

	public ResultSet setQuery(String Query) throws SQLException {
		// Récupération des informations voulues
		res = smt.executeQuery(Query);
		return res;
	}

}
