package model;

import java.text.SimpleDateFormat;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import webservice.Web_Service;

@XmlRootElement
public class Consommation {
	
	
	/*Attributs*/
	private Aliment aliment;
	private double quantite;
	private String periode;
	
	
	/*Getters et setters*/
	@XmlElement
	public Aliment getAliment() {
		return aliment;
	}
	public void setAliment(Aliment aliment) {
		this.aliment = aliment;
	}
	
	@XmlElement
	public double getQuantite() {
		return quantite;
	}
	public void setQuantite(double quantite) {
		this.quantite = quantite;
	}
	
	@XmlElement
	public String getPeriode() {
		return periode;
	}
	public void setPeriode(String periode) {
		this.periode = periode;
	}
	
	/*Constructeur(s)*/
	public Consommation(Aliment aliment, double quantite, String periode) {
		super();
		this.aliment = aliment;
		this.quantite = quantite;
		this.periode = periode;
	}
	
	
	/*Constructeur(s)*/
	public Consommation() {
	
	}

	
	/*Methode*/
	
	public boolean AjouterConsom(int idJ) {

		   String reponse = Web_Service.getService()
				   		.path("consommation/ajout")
				   		.queryParam("aliment", aliment.getId()+"")
				   		.queryParam("journee",idJ+"").queryParam("qtt",quantite+"")
				   		.queryParam("periode", periode)
				   		.queryParam("type", aliment.getClass().getName())
						.post(String.class);
		return reponse.equals("OK");	
	}
	
	public boolean RetirerConsom(int idJ) {

		   String reponse = Web_Service.getService()
				   		.path("consommation/supprimer")
				   		.queryParam("aliment", aliment.getId()+"")
				   		.queryParam("journee",idJ+"").queryParam("type", aliment.getClass().getName())
						.post(String.class);
		return reponse.equals("OK");	
	}

	public boolean ModifierConsom(int idJ) {

		   String reponse = Web_Service.getService()
				   		.path("consommation/modification")
				   		.queryParam("aliment", aliment.getId()+"")
				   		.queryParam("journee",idJ+"").queryParam("qtt",quantite+"")
				   		.queryParam("periode", periode).queryParam("type", aliment.getClass().getName())
				   	
						.post(String.class);
		return reponse.equals("OK");	
	}
	
}
