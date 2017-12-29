package model;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name="aliment")
public class Aliment {
	
	
	/*Attributs*/
	private int id;
	private String nom;
	private Double calorie;
	private Double lipide;
	private Double acideG;
	
	private Double glucide;
	private Double sucre;
	private Double proteine;
	private Double quantiteType;
	
	/*Getters ete setters;*/
	

	@XmlAttribute
	public int getId() {
		return id;
	}
	public void setID(int Id) {
		id = Id;
	}
	
	@XmlElement
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	@XmlElement
	public Double getCalorie() {
		return calorie;
	}
	public void setCalorie(Double calorie) {
		this.calorie = calorie;
	}
	
	@XmlElement
	public Double getLipide() {
		return lipide;
	}

	public void setLipide(Double lipide) {
		this.lipide = lipide;
	}
	
	@XmlElement
	public Double getAcideG() {
		return acideG;
	}
	public void setAcideG(Double acideG) {
		this.acideG = acideG;
	}
	


	@XmlElement
	public Double getGlucide() {
		return glucide;
	}
	public void setGlucide(Double glucide) {
		this.glucide = glucide;
	}
	
	@XmlElement
	public Double getSucre() {
		return sucre;
	}
	public void setSucre(Double sucre) {
		this.sucre = sucre;
	}
	
	@XmlElement
	public Double getProteine() {
		return proteine;
	}
	public void setProteine(Double proteine) {
		this.proteine = proteine;
	}
	
	@XmlElement
	public Double getQuantiteType() {
		return quantiteType;
	}
	public void setQuantiteType(Double quantiteType) {
		this.quantiteType = quantiteType;
	}


	/*Constructeur(s)*/
	public Aliment() {
	
	}

	
	
	public Aliment(int id,String nom,  Double calorie, Double lipide, Double acideG, Double glucide, Double sucre,
			Double proteine, Double quantiteType) {
		this.id=id;
		this.nom = nom;
		this.calorie = calorie;
		this.lipide = lipide;
		this.acideG = acideG;	
		this.glucide = glucide;
		this.sucre = sucre;
		this.proteine = proteine;
		this.quantiteType = quantiteType;
	}
	
	public Aliment(String nom,  Double calorie, Double lipide, Double acideG, Double glucide, Double sucre,
			Double proteine, Double quantiteType) {
		
		this.nom = nom;
		this.calorie = calorie;
		this.lipide = lipide;
		this.acideG = acideG;	
		this.glucide = glucide;
		this.sucre = sucre;
		this.proteine = proteine;
		this.quantiteType = quantiteType;
	}
	
	
	
	public Boolean ajoutAliment() {
		return true;
	}
	
}
