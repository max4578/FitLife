package model;

import java.sql.Date;

public class Utilisateur extends Personne{
	
	/*Attribut*/
	private String sexe;
	private Date dateNaissance;
	private Double poids;
	private Double taille;
	private Double IMC;
	private Double besoin_lipide;
	private Double besoin_acideG;
	private Double besoin_proteine;
	private Double besoin_glucide;
	
	
	/*Getters et setters*/	

	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public Double getPoids() {
		return poids;
	}
	public void setPoids(Double poids) {
		this.poids = poids;
	}
	public Double getTaille() {
		return taille;
	}
	public void setTaille(Double taille) {
		this.taille = taille;
	}
	public Double getIMC() {
		return IMC;
	}
	public void setIMC(Double iMC) {
		IMC = iMC;
	}
	public Double getBesoin_lipide() {
		return besoin_lipide;
	}
	public void setBesoin_lipide(Double besoin_lipide) {
		this.besoin_lipide = besoin_lipide;
	}
	public Double getBesoin_acideG() {
		return besoin_acideG;
	}
	public void setBesoin_acideG(Double besoin_acideG) {
		this.besoin_acideG = besoin_acideG;
	}
	public Double getBesoin_proteine() {
		return besoin_proteine;
	}
	public void setBesoin_proteine(Double besoin_proteine) {
		this.besoin_proteine = besoin_proteine;
	}
	public Double getBesoin_glucide() {
		return besoin_glucide;
	}
	public void setBesoin_glucide(Double besoin_glucide) {
		this.besoin_glucide = besoin_glucide;
	}

	
	/*Constructeur(s)*/
	public Utilisateur(String nom, String prenom, String email, String password, String sexe, Date dateNaissance,
			Double poids, Double taille, Double iMC, Double besoin_lipide, Double besoin_acideG, Double besoin_proteine,
			Double besoin_glucide) {
		super(nom, prenom, email, password);
		this.sexe = sexe;
		this.dateNaissance = dateNaissance;
		this.poids = poids;
		this.taille = taille;
		IMC = iMC;
		this.besoin_lipide = besoin_lipide;
		this.besoin_acideG = besoin_acideG;
		this.besoin_proteine = besoin_proteine;
		this.besoin_glucide = besoin_glucide;
	}
	
	
	
	/*Définition des méthodes*/
	public Boolean Inscritption() {
		return null;
		
	}
	

	
	
	
	public Boolean ModifierInfoPhysique() {
		return null;
		
	}
	

}
