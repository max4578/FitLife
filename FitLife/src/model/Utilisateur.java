package model;

import java.util.Date;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import webservice.Web_Service;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

@XmlRootElement
public class Utilisateur extends Personne{
	
	/*Attribut*/
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
		super();
		
	}
	
	
	public Utilisateur(String nom, String prenom, String email, String password) {
		super(nom, prenom, email, password);
		
	}
	
	public Utilisateur(String nom, String prenom, String email, String password, String sexe, Date dateNaissance,
			Double poids, Double taille) {
		super(nom, prenom, email, password);
		this.sexe = sexe;
		this.dateNaissance = dateNaissance;
		this.poids = poids;
		this.taille = taille;
	}
	

	/* D�finition des m�thode */
	public Boolean ModifierInfoCompte() throws IOException, ParseException {

		   String reponse = Web_Service.getService()
				   		.path("utilisateur/modifier").queryParam("nom", getNom())
				   		.queryParam("prenom", getPrenom()).queryParam("email",getEmail())
				   		.queryParam("password", getPassword()).queryParam("sexe", getSexe())
				   		.queryParam("dateN", new SimpleDateFormat("yyyy/MM/dd").format(getDateNaissance()))
				   		.queryParam("poids", poids.toString()).queryParam("taille",taille.toString())
						.post(String.class);
		return true;			
	}
    
	
	public Boolean inscription() throws IOException, ParseException {

		   String reponse = Web_Service.getService()
				   		.path("utilisateur/ajout").queryParam("nom", getNom())
				   		.queryParam("prenom", getPrenom()).queryParam("email",getEmail())
				   		.queryParam("password", getPassword()).queryParam("sexe", getSexe())
				   		.queryParam("dateN", new SimpleDateFormat("yyyy/MM/dd").format(getDateNaissance()))
				   		.queryParam("poids", poids.toString()).queryParam("taille",taille.toString())
						.post(String.class);
		return reponse.equals("OK");			
	}
	
	public Boolean modifierInfoPhysique() throws IOException {
		return true;	
	}
	
	/***
	 * Calcul de l'IMC de l'utilisateur
	 */
	public void calculIMC() {
		IMC = poids / (taille*taille);
	}
	
	/***
	 * Calcul le m�tabolisme de la personne
	 */
	public void calculerMetabolisme() {
		LocalDate date = dateNaissance.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		if(this.sexe.equals("F")) {
			setMetabolisme((poids * 9.99) + (6.25 * taille) - (5 * (calculAge(date))) - 161);
			System.out.println(calculAge(date));
		}else {
			setMetabolisme((poids * 9.99) + (6.25 * taille) - (5 * (calculAge(date))) + 5);
			System.out.println(calculAge(date));
		}
	}
	
	/***
	 * Calcul l'age de la personne
	 * @param dateNaissance
	 * @return
	 */
    public int calculAge(LocalDate dateNaissance) {
    	LocalDate aujourdhui = LocalDate.now(); 
        if (dateNaissance != null) {
            return Period.between(dateNaissance, aujourdhui).getYears();
        } else {
            return 0;
        }
    }


  public void Besoin(Double metabolisme) {
    	besoin_proteine = getPoids() * 2;
    	besoin_lipide = getPoids();
    	besoin_glucide = metabolisme - besoin_proteine - besoin_lipide;
    }
    
    public Boolean connexion(String email , String pass) {
		   String xmlAnswer = Web_Service.getService()
				   		.path("utilisateur/"+email+"/"+pass)
						.accept(MediaType.TEXT_XML)
						.get(String.class);

		   /*Conversiondu XML en classe mapp�e*/
			try {
				   JAXBContext jaxbContext = JAXBContext.newInstance(Utilisateur.class);
				   Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
				   StringReader reader = new StringReader(xmlAnswer);
				   Utilisateur u = (Utilisateur) unmarshaller.unmarshal(reader);
				   setId(u.getId());
				   setNom(u.getNom());
				   setPrenom(u.getPrenom());
				   setEmail(u.getEmail());
				   setPassword(u.getPassword());
				   sexe=u.getSexe();
				   dateNaissance=u.getDateNaissance();
				   poids=u.getPoids();
				   taille=u.getTaille();
				   calculIMC();
				   calculerMetabolisme();
			} catch (JAXBException e1) {
				return false;
			}	catch (NullPointerException e){
				return false;
			}
    	return true;
    }
    
    
    public Boolean AppelAjoutAliment(Aliment_Utilisateur alim) throws IOException {
    	System.out.println(getId());
    	return alim.AjouterAliment(getId());
    }
    
}
