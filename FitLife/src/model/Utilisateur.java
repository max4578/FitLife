package model;

import java.util.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

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
	private Double metabolisme;
	
	
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
	public Double getMetabolisme() {
		return metabolisme;
	}
	public void setMetabolisme(Double metabolisme) {
		this.metabolisme = metabolisme;
	}
	/*Constructeur(s)*/
	public Utilisateur(String nom, String prenom, String email, String password) {
		super(nom, prenom, email, password);
		
	}
	
	public Utilisateur(String nom, String prenom, String email, String password, String sexe, Date dateNaissance,
			Double poids, Double taille) {
		super(nom, prenom, email, password);
		this.sexe = sexe;
		this.dateNaissance = dateNaissance;
		this.poids = poids;
		this.taille = taille;
	}
	

	/* Définition des méthode */
	public Boolean inscription() {
		return null;
		
	}
	
	public Boolean modifierInfoPhysique() {
		return null;
	}
	
	/***
	 * Calcul de l'IMC de l'utilisateur
	 */
	public void calculIMC() {
		IMC = poids / (taille*taille);
	}
	
	/***
	 * Calcul le métabolisme de la personne
	 */
	public void calculerMetabolisme() {
		LocalDate date = dateNaissance.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		if(this.sexe.equals("F")) {
			setMetabolisme((poids * 9.99) + (6.25 * taille) - (5 * (calculAge(date))) - 161);
			System.out.println(calculAge(date));
		}else {
			setMetabolisme((poids * 9.99) + (6.25 * taille) - (5 * (calculAge(date))) + 5);
			System.out.println(calculAge(date));
		}
	}
	
	/***
	 * Calcul l'age de la personne
	 * @param dateNaissance
	 * @return
	 */
    public int calculAge(LocalDate dateNaissance) {
    	LocalDate aujourdhui = LocalDate.now(); 
        if (dateNaissance != null) {
            return Period.between(dateNaissance, aujourdhui).getYears();
        } else {
            return 0;
        }
    }

}
