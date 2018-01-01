package model;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;

public class Aliment_Utilisateur extends Aliment {

	
	
	
	public Aliment_Utilisateur(int id,String nom, Double calorie,Double lipide, Double acideG,  Double glucide, Double sucre,
			Double proteine, Double quantiteType) {
		super(id,nom, calorie,lipide, acideG ,glucide, sucre, proteine, quantiteType);
	}
		

	public Aliment_Utilisateur(String nom, Double calorie,Double lipide, Double acideG,  Double glucide, Double sucre,
			Double proteine, Double quantiteType) {
		super(nom, calorie,lipide, acideG ,glucide, sucre, proteine, quantiteType);
	}


	public Boolean AjouterAliment(int idUser) throws IOException {
		URL url = new URL("http://localhost:9090/Web_Service/rest/aliment/ajout");
	    HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
		httpCon.setDoOutput(true);
		httpCon.setRequestMethod("POST");
		httpCon.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		
		String urlParameters = "nom="+getNom()+"&calorie="+getCalorie()+""
				+ "&lipide="+getLipide()+"&acideG="+getAcideG()
				+"&glucide="+getGlucide()
				+"&sucre="+getSucre()
				+"&proteine="+getProteine()+"&qtt="+getQuantiteType()
				+"&idUser="+idUser;

		
		DataOutputStream wr = new DataOutputStream(httpCon.getOutputStream());
		wr.writeBytes(urlParameters);
		
		wr.flush();
		wr.close();
		 
		OutputStreamWriter out = new OutputStreamWriter(
		      httpCon.getOutputStream());
		  System.out.println(httpCon.getResponseCode());
		  System.out.println(httpCon.getResponseMessage());
		  
		  out.close();
		return httpCon.getResponseMessage().equals("OK");		
	}
	
	public void ModifierAliment() {
		
	}
	
	public void SupprimerAliment() {
		
	}
}
