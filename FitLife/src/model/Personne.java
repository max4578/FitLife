package model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Personne {
	
	/*Attributs*/
	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String password;
	
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
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	@XmlElement
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@XmlElement
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	/*Constructeur(s)*/
	public Personne(String nom, String prenom, String email, String password) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
	}
	
	public Personne(int id,String nom, String prenom, String email, String password) {
		this.setId(id);
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
	}
	
	public Personne() {
		
	}
	
	
	
	

}
