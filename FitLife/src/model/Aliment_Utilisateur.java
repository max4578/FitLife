package model;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;

import javax.xml.bind.annotation.XmlRootElement;

import webservice.Web_Service;

@XmlRootElement(name="aliment_user")
public class Aliment_Utilisateur extends Aliment {

	
	
	
	public Aliment_Utilisateur(int id,String nom, double calorie,double lipide, double acideG,  double glucide, double sucre,
			double proteine, double quantiteType) {
		super(id,nom, calorie,lipide, acideG ,glucide, sucre, proteine, quantiteType);
	}
		

	public Aliment_Utilisateur(String nom, double calorie,double lipide, double acideG,  double glucide, double sucre,
			double proteine, double quantiteType) {
		super(nom, calorie,lipide, acideG ,glucide, sucre, proteine, quantiteType);
	}


	public Aliment_Utilisateur() {
		// TODO Auto-generated constructor stub
	}


	public Boolean AjouterAliment(int idUser) throws IOException {
		
		   String reponse = Web_Service.getService()
			   		.path("aliment/ajout")
			   		.queryParam("nom", getNom())
			   		.queryParam("calorie", getCalorie()+"")
			   		.queryParam("lipide",getLipide()+"")
			   		.queryParam("acideG", getAcideG()+"")
			   		.queryParam("glucide", getGlucide()+"")
			   		.queryParam("sucre", getSucre()+"")
			   		.queryParam("proteine",getProteine()+"")
			   		.queryParam("qtt",getQuantiteType()+"")
			   		.queryParam("idUser",idUser+"")
					.post(String.class);
	return reponse.equals("OK");			
		
	}
	
	public void ModifierAliment() {
		
	}
	
	public void SupprimerAliment() {
		
	}
}
