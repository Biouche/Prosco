/**
 * \\file          ClassBDEcole.java
 * \\author    bfaliu
 * \\version   1.0
 * \\date       29/09/2013
 * \\brief       Class pour la Base de Donn�e BDEcole
 *
 * \\details    Permet d'acc�der aux donn�es de chaques �coles par leur nom
 * 			  et de modifier / cr�er des �coles dans la base de donn�e
 */
package Prosco.Class;

import java.io.IOException;
import java.sql.ResultSet;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ClassBDEcole {

	String m_NOMECOLE;

	int m_idEcole;
	String m_adresse1;
	String m_adresse2;
	int m_codePostal;
	String m_Ville;
	String m_nomDirecteur;
	String m_nomResponsable;
	int m_numTelephone;
	int m_numFax;
	Image m_imgEcole;

	/**
	 * \\brief Constructeur de la classe BDEcoles \\details R�cup�re toutes les
	 * informations d'une �cole \\param String NOMECOLE Le nom de l'�cole
	 */
	public ClassBDEcole()
	{
		try {
			ConnectBD BD = new ConnectBD();
			
		}catch (Exception e) {
			System.out.println("Probl�me de connexion � la BD : "
					+ e.getMessage());
			e.printStackTrace();
		}
	}
	public ClassBDEcole(String NOMECOLE) {

		this.m_NOMECOLE = NOMECOLE;
		System.out.println(NOMECOLE);
		try {
			ConnectBD BD = new ConnectBD();

			ResultSet res = BD
					.setQuery("SELECT * FROM APP.ECOLES WHERE NOMECOLE = '"
							+ NOMECOLE + "'");
			
			// Positionnement du curseur
			res.next();

			this.m_idEcole = res.getInt("IDECOLE");
			this.m_adresse1 = res.getString("ADRESSE1");
			this.m_adresse2 = res.getString("ADRESSE2");
			this.m_codePostal = res.getInt("CODE_POSTAL");
			this.m_Ville = res.getString("VILLE");
			this.m_nomDirecteur = res.getString("NOM_DIRECTEUR");
			this.m_nomResponsable = res.getString("NOM_RESPONSABLE");
			this.m_imgEcole = new Image(res.getString("IMG_ECOLE"));
		} catch (Exception e) {
			System.out.println("Probl�me de connexion � la BD : "
					+ e.getMessage());
			e.printStackTrace();
		}

	}// ClassBDEcole

	/**
	 * \\brief Getters and setters
	 */
	public String getNomEcole() {

		return this.m_NOMECOLE;
	}

	public void setNomEcole(String newNomEcole) {
		this.m_NOMECOLE = newNomEcole;
	}

	public int getIdEcole() {
		return this.m_idEcole;
	}

	public String getAdresse1() {
		return this.m_adresse1;
	}

	public void setAdresse1(String newAdresse) {
		this.m_adresse1 = newAdresse;
	}

	public String getAdresse2() {
		return this.m_adresse2;
	}

	public void setAdresse2(String newAdresse) {
		this.m_adresse2 = newAdresse;
	}

	public int getCodePostal() {
		return this.m_codePostal;
	}

	public void setCodePostal(int newCodePostal) {
		this.m_codePostal = newCodePostal;
	}

	public String getVille() {
		return this.m_Ville;
	}

	public void setVille(String newVille) {
		this.m_Ville = newVille;
	}

	public String getNomDirecteur() {
		return this.m_nomDirecteur;
	}

	public void setNomDirecteur(String newNomDirecteur) {
		this.m_nomDirecteur = newNomDirecteur;
	}

	public String getNomResponsable() {
		return this.m_nomResponsable;
	}

	public void setNomResponsable(String newNomResponsable) {
		this.m_nomResponsable = newNomResponsable;
	}

	public int getNumTelephone() {
		return this.m_numTelephone;
	}

	public void setNumTelephone(int newNumTelephone) {
		this.m_numTelephone = newNumTelephone;
	}

	public int getNumFax() {
		return this.m_numFax;
	}

	public void setNumFax(int newNumFax) {
		this.m_numFax = newNumFax;
	}
	
	public Image getImgEcole() {
		return this.m_imgEcole;
	}

	public void setImgEcole(Image newImgEcole) {
		this.m_imgEcole = newImgEcole;
	}

	public void InsertNewEcole(String NOMECOLE, String adresse1,
			String adresse2, int codePostal, String Ville, String nomDirecteur,
			String nomResponsable, int numTelephone, int numFax,String imgEcole) {
		try {
			ConnectBD BD = new ConnectBD();
			
			String query = "INSERT INTO APP.ECOLES(NOMECOLE,ADRESSE1,ADRESSE2,CODE_POSTAL,VILLE,NOM_DIRECTEUR,NOM_RESPONSABLE,NUM_TELEPHONE,NUM_FAX,IMG_ECOLE)"
					+ " VALUES ("
					+ "'"+"dd"
					+"','"+adresse1
					+"','"+adresse2
					+"',"+codePostal
					+",'"+Ville
					+"','"+nomDirecteur
					+"','"+nomResponsable
					+"',"+numTelephone
					+","+numFax
					+",'"+imgEcole
					+"')";
			
			BD.smt.executeUpdate(query);
			
		} catch (Exception e) {
			System.out.println("Probl�me de connexion � la BD : "
					+ e.getMessage());
			e.printStackTrace();
		}
	}

	public void UpdateEcole(int idEcole,String NOMECOLE, String adresse1,
			String adresse2, int codePostal, String Ville, String nomDirecteur,
			String nomResponsable, int numTelephone, int numFax, String imgEcole) {
		
		try {
			ConnectBD BD = new ConnectBD();

			String query = "UPDATE APP.ECOLES SET NOMECOLE = '"+ NOMECOLE +
																"',ADRESSE1 = '" + adresse1  + 
																"',ADRESSE2 = '" + adresse2 + 
																"',CODE_POSTAL = " + codePostal +
																",VILLE = '" + Ville +
																"',NOM_DIRECTEUR = '" + nomDirecteur +
																"',NOM_RESPONSABLE = '" + nomResponsable +
																"',NUM_TELEPHONE = " + numTelephone +
																",NUM_FAX = " + numFax +
																",IMG_ECOLE = '" + imgEcole + "'" +
														  "WHERE IDECOLE = " + idEcole;
			
			BD.smt.executeUpdate(query);
			
		} catch (Exception e) {
			System.out.println("Problème de connexion à la BD : "
					+ e.getMessage());
			e.printStackTrace();
		}
	}

	public void chargerEcole(String IDECOLE, Object object) throws IOException {

		Node node = (Node) object;
		Stage stage = (Stage) node.getScene().getWindow();
		Parent root = null;

		root = FXMLLoader.load(getClass().getResource(
				"/Prosco/Resources/View/ViewInfoEcole.fxml"));

		Scene scene = new Scene(root);
		stage.setScene(scene);

		stage.show();

	}
}// BDEcoles
