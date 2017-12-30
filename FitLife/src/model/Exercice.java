package model;

public class Exercice {
	
	
	/*Attributs*/
	private String nom;
	private String description;
	private String type;
	private int numeroPhoto;
	private Double valeur;
	
	
	/*Getters et setters*/
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getNumeroPhoto() {
		return numeroPhoto;
	}
	public void setNumeroPhoto(int numeroPhoto) {
		this.numeroPhoto = numeroPhoto;
	}
	public Double getValeur() {
		return valeur;
	}
	public void setValeur(Double valeur) {
		this.valeur = valeur;
	}
	
	
	/*Constructeur(s)*/
	
	public Exercice(String nom, String description, String type, int numeroPhoto, Double valeur) {
		super();
		this.nom = nom;
		this.description = description;
		this.type = type;
		this.numeroPhoto = numeroPhoto;
		this.valeur = valeur;
	}
	
	
	/*Methode(s)*/

}
