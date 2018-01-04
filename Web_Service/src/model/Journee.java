package model;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="journee")
public class Journee {
	
	
	/*Attributs*/
	private int id;
	private Date date;
	private List<Seance> listSeance;
	private List<Consommation> listConsom;
	private Double lipide_consom;
	private Double acideG_consom;
	private Double calorie_consom;
	private Double glucide_consom;
	private Double facteur_activite;
	
	
	/*Getters et setters*/
	@XmlAttribute
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@XmlElement
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@XmlElement
	public List<Seance> getListSeance() {
		return listSeance;
	}
	public void setListSeance(List<Seance> listSeance) {
		this.listSeance = listSeance;
	}
	
	@XmlElement
	public List<Consommation> getListConsom() {
		return listConsom;
	}
	public void setListConsom(List<Consommation> listConsom) {
		this.listConsom = listConsom;
	}
	

	
	@XmlElement
	public Double getLipide_consom() {
		return lipide_consom;
	}
	public void setLipide_consom(Double lipide_consom) {
		this.lipide_consom = lipide_consom;
	}
	
	@XmlElement
	public Double getAcideG_consom() {
		return acideG_consom;
	}
	public void setAcideG_consom(Double acideG_consom) {
		this.acideG_consom = acideG_consom;
	}
	
	@XmlElement
	public Double getCalorie_consom() {
		return calorie_consom;
	}
	public void setCalorie_consom(Double calorie_consom) {
		this.calorie_consom = calorie_consom;
	}
	
	@XmlElement
	public Double getGlucide_consom() {
		return glucide_consom;
	}
	public void setGlucide_consom(Double glucide_consom) {
		this.glucide_consom = glucide_consom;
	}
	
	@XmlElement
	public Double getFacteur_activite() {
		return facteur_activite;
	}
	public void setFacteur_activite(Double facteur_activite) {
		this.facteur_activite = facteur_activite;
	}

	
	/*Constructeur(s)*/
	
	public Journee(Date date, List<Seance> listSeance,  List<Consommation> list_c, Double lipide_consom,
			Double acideG_consom, Double calorie_consom, Double glucide_consom, Double facteur_activite) {
		super();
		this.date = date;
		this.listSeance = listSeance;
		this.listConsom = list_c;
		this.lipide_consom = lipide_consom;
		this.acideG_consom = acideG_consom;
		this.calorie_consom = calorie_consom;
		this.glucide_consom = glucide_consom;
		this.facteur_activite = facteur_activite;
	}
	
	public Journee(int id,Date date, List<Seance> listSeance,List<Consommation> list_c) {
		this.id=id;
		this.date = date;
		this.listSeance = listSeance;
		this.listConsom = list_c;
	
	}
	
	public Journee(int id,Date date) {
		this.id=id;
		this.date = date;
	}
	
	
	public Journee() {
			
	}


}
