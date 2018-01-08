package model;

import java.io.StringReader;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import webservice.Web_Service;
@XmlRootElement(name="journee")
public class Journee {
	
	
	/*Attributs*/
	private int id;
	private Date date;
	private List<Seance> listSeance= new LinkedList<Seance>();
	private List<Consommation> listConsom= new LinkedList<Consommation>();
	private double lipide_consom;
	private double acideG_consom;
	private double calorie_consom;
	private double glucide_consom;
	private double proteine_consom;

	
	
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
	public double getLipide_consom() {
		return lipide_consom;
	}
	public void setLipide_consom(double lipide_consom) {
		this.lipide_consom = lipide_consom;
	}
	
	@XmlElement
	public double getAcideG_consom() {
		return acideG_consom;
	}
	public void setAcideG_consom(double acideG_consom) {
		this.acideG_consom = acideG_consom;
	}
	
	@XmlElement
	public double getCalorie_consom() {
		return calorie_consom;
	}
	public void setCalorie_consom(double calorie_consom) {
		this.calorie_consom = calorie_consom;
	}
	
	@XmlElement
	public double getGlucide_consom() {
		return glucide_consom;
	}
	public void setGlucide_consom(double glucide_consom) {
		this.glucide_consom = glucide_consom;
	}
	

	@XmlElement
	public double getProteine_consom() {
		return proteine_consom;
	}
	public void setProteine_consom(double proteine_consom) {
		this.proteine_consom = proteine_consom;
	}

	
	/*Constructeur(s)*/
	
	public Journee(Date date, List<Seance> listSeance,  List<Consommation> list_c, double lipide_consom,
			double acideG_consom, double calorie_consom, double glucide_consom, double facteur_activite) {
		super();
		this.date = date;
		this.listSeance = listSeance;
		this.listConsom = list_c;
		this.lipide_consom = lipide_consom;
		this.acideG_consom = acideG_consom;
		this.calorie_consom = calorie_consom;
		this.glucide_consom = glucide_consom;
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
	
	
	/*Méthode(s)*/
	
	public boolean NouvelleJournee(int idU) {
		
		String reponse = Web_Service.getService()
				   		.path("journee/ajout")
				   		.queryParam("idUser",idU+"")
						.post(String.class);
		
		String reponse2 = Web_Service.getService()
		   		.path("journee/get_journee")
		   		.queryParam("idUser",idU+"")
				.post(String.class);
		try {
			   JAXBContext jaxbContext = JAXBContext.newInstance(Journee.class);
			   Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			   StringReader reader = new StringReader(reponse2);
			   Journee j = (Journee) unmarshaller.unmarshal(reader);
			   id=j.getId();
			   date=j.getDate();
			   listSeance=j.getListSeance();
			   listConsom=j.getListConsom();
			   
			   
		} catch (JAXBException e1) {
			return false;
		}	catch (NullPointerException e){
			return false;
		}
		return reponse.equals("OK");
	}
	
	
	public void calculConsommation() {
		calorie_consom = 0;
		proteine_consom = 0;
		lipide_consom = 0;
		glucide_consom = 0;
		for(Consommation a : listConsom) {
			calorie_consom += a.getAliment().getCalorie()*(a.getQuantite()/a.getAliment().getQuantiteType());
			proteine_consom += a.getAliment().getProteine()*(a.getQuantite()/a.getAliment().getQuantiteType());
			lipide_consom += a.getAliment().getLipide()*(a.getQuantite()/a.getAliment().getQuantiteType());
			glucide_consom += a.getAliment().getGlucide()*(a.getQuantite()/a.getAliment().getQuantiteType());
		}
	}


	
	public void AppelRetirerAliment() {
		
	}
	
	public boolean AjouterSeance(Seance s,String periode) {
		listSeance.add(s);
		String reponse = Web_Service.getService()
				   		.path("journee/ajouter_seance")
				   		.queryParam("idJournee",id+"")
				   		.queryParam("idSeance", s.getId()+"")
				   		.queryParam("periode",periode)
						.post(String.class);
		return reponse.equals("OK");	
	}
}
