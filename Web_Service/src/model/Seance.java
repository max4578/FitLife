package model;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="seance")
public class Seance {

	/*Attributs*/
	private int id;
	private List<Exercice> list_exercice;
	private String nom;
	private Date dateCreation;
	
	/*Getter et setter*/
	@XmlAttribute
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@XmlElement
	public List<Exercice> getList_exercice() {
		return list_exercice;
	}
	public void setList_exercice(List<Exercice> list_exercice) {
		this.list_exercice = list_exercice;
	}
	
	@XmlElement
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	@XmlElement
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
	
	
	public Seance(int id,List<Exercice> list_exercice, String nom, Date dateCreation) {
		super();
		this.id=id;
		this.list_exercice = list_exercice;
		this.nom = nom;
		this.dateCreation = dateCreation;
	}
	
	public Seance(List<Exercice> list_exercice, String nom) {
		super();
		this.list_exercice = list_exercice;
		this.nom = nom;
	}
	
	public Seance() {
	
	}

}
