package model;

public class Aliment {
	
	
	/*Attributs*/
	private String nom;
	private Double lipide;
	private Double acideG;
	private Double calorie;
	private Double glucide;
	private Double sucre;
	private Double proteine;
	private Double quantiteType;
	
	/*Getters ete setters;*/
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Double getLipide() {
		return lipide;
	}
	public void setLipide(Double lipide) {
		this.lipide = lipide;
	}
	public Double getAcideG() {
		return acideG;
	}
	public void setAcideG(Double acideG) {
		this.acideG = acideG;
	}
	public Double getCalorie() {
		return calorie;
	}
	public void setCalorie(Double calorie) {
		this.calorie = calorie;
	}
	public Double getGlucide() {
		return glucide;
	}
	public void setGlucide(Double glucide) {
		this.glucide = glucide;
	}
	public Double getSucre() {
		return sucre;
	}
	public void setSucre(Double sucre) {
		this.sucre = sucre;
	}
	public Double getProteine() {
		return proteine;
	}
	public void setProteine(Double proteine) {
		this.proteine = proteine;
	}
	public Double getQuantiteType() {
		return quantiteType;
	}
	public void setQuantiteType(Double quantiteType) {
		this.quantiteType = quantiteType;
	}


	/*Constructeur(s)*/
	
	public Aliment(String nom, Double lipide, Double acideG, Double calorie, Double glucide, Double sucre,
			Double proteine, Double quantiteType) {
		super();
		this.nom = nom;
		this.lipide = lipide;
		this.acideG = acideG;
		this.calorie = calorie;
		this.glucide = glucide;
		this.sucre = sucre;
		this.proteine = proteine;
		this.quantiteType = quantiteType;
	}
	
	
	
}
