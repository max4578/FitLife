package model;

import java.sql.Date;
import java.util.List;

public class Seance {

	/*Attributs*/
	private List<Exercice> list_exercice;
	private String nom;
	private Date dateCreation;
	
	/*Getter et setter*/
	public List<Exercice> getList_exercice() {
		return list_exercice;
	}
	public void setList_exercice(List<Exercice> list_exercice) {
		this.list_exercice = list_exercice;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	
	

	/*Constructeur*/
	public Seance(List<Exercice> list_exercice, String nom, Date dateCreation) {
		super();
		this.list_exercice = list_exercice;
		this.nom = nom;
		this.dateCreation = dateCreation;
	}
	
	public Seance(List<Exercice> list_exercice, String nom) {
		super();
		this.list_exercice = list_exercice;
		this.nom = nom;
	}
}
