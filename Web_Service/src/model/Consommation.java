package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

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
	
	
}
