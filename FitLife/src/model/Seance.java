package model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import webservice.Web_Service;
@XmlRootElement(name="seance")
public class Seance {

	/*Attributs*/
	private int id;
	private List<Exercice> list_exercice=new LinkedList<Exercice>();
	private String nom;
	private String periode;
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
	@XmlElement
	public String getPeriode() {
		return periode;
	}
	public void setPeriode(String periode) {
		this.periode = periode;
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
	
	public Seance(String nom) {
		super();
		this.nom = nom;
	}
	
	
	public Seance() {
	
	}
	

	/*Methode*/
	
	public boolean AjouterSeance(int idUser) {

		   String reponse = Web_Service.getService()
				   		.path("seance/ajout")
				   		.queryParam("idUser", idUser+"")
				   		.queryParam("nom",nom)
						.post(String.class);
		return reponse.equals("OK");	
	}
	
	public boolean SupprimerSeance() {

		   String reponse = Web_Service.getService()
				   		.path("seance/supprimer")		
				   		.queryParam("idSeance", id+"")
						.post(String.class);
		return reponse.equals("OK");	
	}

	public boolean RetraitSeance(int idJ) {
		
		 String reponse = Web_Service.getService()
			   		.path("seance/retirer")		
			   		.queryParam("idSeance", id+"")
			   		.queryParam("idJournee", idJ+"")
			   		.queryParam("periode", periode+"")
					.post(String.class);
	return reponse.equals("OK");	
		
	}
	public boolean ModifierSeance() {

		   String reponse = Web_Service.getService()
				   		.path("seance/modification")
				   		.queryParam("idSeance", id+"")
				   		.queryParam("nom", nom)
						.post(String.class);
		return reponse.equals("OK");	
	}
	
	
	
	public boolean AjouterExercice(Exercice e,int repet) {
		for(int i=0;i<repet;i++)
		   list_exercice.add(e);
		
		   String reponse = Web_Service.getService()
				   		.path("seance/ajouter_exercice")
				   		.queryParam("idExercice", e.getId()+"")
				   		.queryParam("idSeance", id+"")
				   		.queryParam("repetition",repet+"")
						.post(String.class);
		return reponse.equals("OK");	
	}

	
	
	
	
	

	
}
