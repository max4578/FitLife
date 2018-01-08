package model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="exercice")
public class Exercice {
	
	/*Attributs*/
	private int id;
	private String nom;
	private String description;
	private String type;
	private int numeroPhoto;
	private double valeur;
	
	
	/*Getters et setters*/
	@XmlAttribute
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@XmlElement
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	@XmlElement
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@XmlElement
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@XmlElement
	public int getNumeroPhoto() {
		return numeroPhoto;
	}
	public void setNumeroPhoto(int numeroPhoto) {
		this.numeroPhoto = numeroPhoto;
	}
	
	@XmlElement
	public double getValeur() {
		return valeur;
	}
	public void setValeur(double valeur) {
		this.valeur = valeur;
	}
	
	
	/*Constructeur(s)*/
	
	public Exercice(int id,String nom, String description, String type, int numeroPhoto, double valeur) {
		this.id=id;
		this.nom = nom;
		this.description = description;
		this.type = type;
		this.numeroPhoto = numeroPhoto;
		this.valeur = valeur;
	}
	
	
	public Exercice() {
		
	}

	
	public Exercice(int id,String nom, String description, String type, int numeroPhoto) {
		this.id=id;
		this.nom = nom;
		this.description = description;
		this.type = type;
		this.numeroPhoto = numeroPhoto;
	}
	
	
	public Exercice(String nom, String description, String type, int numeroPhoto, double valeur) {
		super();
		this.nom = nom;
		this.description = description;
		this.type = type;
		this.numeroPhoto = numeroPhoto;
		this.valeur = valeur;
	}
	
	
	/*Methode(s)*/
	
	

}
