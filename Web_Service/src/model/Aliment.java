package model;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name="aliment")
public class Aliment {
	
	
	/*Attributs*/
	private int id;
	private String nom;
	private double calorie;
	private double lipide;
	private double acideG;	
	private double glucide;
	private double sucre;
	private double proteine;
	private double quantiteType;
	
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
	public double getCalorie() {
		return calorie;
	}
	public void setCalorie(double calorie) {
		this.calorie = calorie;
	}
	
	@XmlElement
	public double getLipide() {
		return lipide;
	}

	public void setLipide(double lipide) {
		this.lipide = lipide;
	}
	
	@XmlElement
	public double getAcideG() {
		return acideG;
	}
	public void setAcideG(double acideG) {
		this.acideG = acideG;
	}
	


	@XmlElement
	public double getGlucide() {
		return glucide;
	}
	public void setGlucide(double glucide) {
		this.glucide = glucide;
	}
	
	@XmlElement
	public double getSucre() {
		return sucre;
	}
	public void setSucre(double sucre) {
		this.sucre = sucre;
	}
	
	@XmlElement
	public double getProteine() {
		return proteine;
	}
	public void setProteine(double proteine) {
		this.proteine = proteine;
	}
	
	@XmlElement
	public double getQuantiteType() {
		return quantiteType;
	}
	public void setQuantiteType(double quantiteType) {
		this.quantiteType = quantiteType;
	}


	/*Constructeur(s)*/

	
	
	public Aliment(int id,String nom,  double calorie, double lipide, double acideG, double glucide, double sucre,
			double proteine, double quantiteType) {
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
	
	public Aliment(String nom,  double calorie, double lipide, double acideG, double glucide, double sucre,
			double proteine, double quantiteType) {
		
		this.nom = nom;
		this.calorie = calorie;
		this.lipide = lipide;
		this.acideG = acideG;	
		this.glucide = glucide;
		this.sucre = sucre;
		this.proteine = proteine;
		this.quantiteType = quantiteType;
	}
	
	
	public Aliment() {
	
	}

	

	
}
