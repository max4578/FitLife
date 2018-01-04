package model;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;

import javax.xml.bind.annotation.XmlRootElement;


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
		
	}



}
