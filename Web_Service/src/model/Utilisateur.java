package model;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Utilisateur{
	
	/*Attributs*/
	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String password;
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
	private String status;

	
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

	@XmlElement
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	
	@XmlElement
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	@XmlElement
	public Double getPoids() {
		return poids;
	}
	public void setPoids(Double poids) {
		this.poids = poids;
	}
	
	@XmlElement
	public Double getTaille() {
		return taille;
	}
	public void setTaille(Double taille) {
		this.taille = taille;
	}
	
	@XmlElement
	public Double getIMC() {
		return IMC;
	}
	public void setIMC(Double iMC) {
		IMC = iMC;
	}
	
	@XmlElement
	public Double getBesoin_lipide() {
		return besoin_lipide;
	}
	public void setBesoin_lipide(Double besoin_lipide) {
		this.besoin_lipide = besoin_lipide;
	}
	
	@XmlElement
	public Double getBesoin_acideG() {
		return besoin_acideG;
	}
	public void setBesoin_acideG(Double besoin_acideG) {
		this.besoin_acideG = besoin_acideG;
	}
	
	@XmlElement
	public Double getBesoin_proteine() {
		return besoin_proteine;
	}
	public void setBesoin_proteine(Double besoin_proteine) {
		this.besoin_proteine = besoin_proteine;
	}
	
	@XmlElement
	public Double getBesoin_glucide() {
		return besoin_glucide;
	}
	public void setBesoin_glucide(Double besoin_glucide) {
		this.besoin_glucide = besoin_glucide;
	}
	
	@XmlElement
	public Double getMetabolisme() {
		return metabolisme;
	}
	public void setMetabolisme(Double metabolisme) {
		this.metabolisme = metabolisme;
	}
	
	@XmlElement
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	/*Constructeur(s)*/
	public Utilisateur() {
	
	}
	
	
	public Utilisateur(int id,String nom, String prenom, String email, String password) {
		this.id=id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		
	}
	
	public Utilisateur(int id,String nom, String prenom, String email, String password, String sexe, Date dateNaissance,
			Double poids, Double taille,String status) {
		this.id=id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.sexe = sexe;
		this.dateNaissance = dateNaissance;
		this.poids = poids;
		this.taille = taille;
		this.status=status;
	}

	
}
