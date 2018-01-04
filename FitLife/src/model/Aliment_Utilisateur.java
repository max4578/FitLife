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

	
	
	
	public Aliment_Utilisateur(int id,String nom, Double calorie,Double lipide, Double acideG,  Double glucide, Double sucre,
			Double proteine, Double quantiteType) {
		super(id,nom, calorie,lipide, acideG ,glucide, sucre, proteine, quantiteType);
	}
		

	public Aliment_Utilisateur(String nom, Double calorie,Double lipide, Double acideG,  Double glucide, Double sucre,
			Double proteine, Double quantiteType) {
		super(nom, calorie,lipide, acideG ,glucide, sucre, proteine, quantiteType);
	}


	public Aliment_Utilisateur() {
		// TODO Auto-generated constructor stub
	}


	public Boolean AjouterAliment(int idUser) throws IOException {
		
		   String reponse = Web_Service.getService()
			   		.path("aliment/ajout")
			   		.queryParam("nom", getNom())
			   		.queryParam("calorie", getCalorie().toString())
			   		.queryParam("lipide",getLipide().toString())
			   		.queryParam("acideG", getAcideG().toString())
			   		.queryParam("glucide", getGlucide().toString())
			   		.queryParam("sucre", getSucre().toString())
			   		.queryParam("proteine",getProteine().toString())
			   		.queryParam("qtt",getQuantiteType().toString())
			   		.queryParam("idUser",idUser+"")
					.post(String.class);
	return reponse.equals("OK");			
		
	}
	
	public void ModifierAliment() {
		
	}
	
	public void SupprimerAliment() {
		
	}
}
