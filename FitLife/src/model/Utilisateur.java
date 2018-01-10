package model;

import java.util.Date;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.json.JSONObject;
import webservice.Web_Service;
import java.io.IOException;
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
	private double poids;
	private double taille;
	private double IMC;
	private double besoin_lipide;
	private double besoin_acideG;
	private double besoin_proteine;
	private double besoin_glucide;
	private double metabolisme;
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
	public double getPoids() {
		return poids;
	}
	public void setPoids(double poids) {
		this.poids = poids;
	}
	
	@XmlElement
	public double getTaille() {
		return taille;
	}
	public void setTaille(double taille) {
		this.taille = taille;
	}
	
	@XmlElement
	public double getIMC() {
		return IMC;
	}
	public void setIMC(double iMC) {
		IMC = iMC;
	}
	
	@XmlElement
	public double getBesoin_lipide() {
		return besoin_lipide;
	}
	public void setBesoin_lipide(double besoin_lipide) {
		this.besoin_lipide = besoin_lipide;
	}
	
	@XmlElement
	public double getBesoin_acideG() {
		return besoin_acideG;
	}
	public void setBesoin_acideG(double besoin_acideG) {
		this.besoin_acideG = besoin_acideG;
	}
	
	@XmlElement
	public double getBesoin_proteine() {
		return besoin_proteine;
	}
	public void setBesoin_proteine(double besoin_proteine) {
		this.besoin_proteine = besoin_proteine;
	}
	
	@XmlElement
	public double getBesoin_glucide() {
		return besoin_glucide;
	}
	public void setBesoin_glucide(double besoin_glucide) {
		this.besoin_glucide = besoin_glucide;
	}
	
	@XmlElement
	public double getMetabolisme() {
		return metabolisme;
	}
	public void setMetabolisme(double metabolisme) {
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
			double poids, double taille) {
		super(nom, prenom, email, password);
		this.sexe = sexe;
		this.dateNaissance = dateNaissance;
		this.poids = poids;
		this.taille = taille;
	}
	

	/* Définition des méthode */
	public Boolean ModifierInfoCompte() throws IOException, ParseException {

		   String reponse = Web_Service.getService()
				   		.path("utilisateur/modifier").queryParam("nom", getNom())
				   		.queryParam("prenom", getPrenom()).queryParam("email",getEmail())
				   		.queryParam("password", getPassword()).queryParam("sexe", getSexe())
				   		.queryParam("dateN", new SimpleDateFormat("yyyy/MM/dd").format(getDateNaissance()))
				   		.queryParam("poids", poids+"").queryParam("taille",taille+"")
						.post(String.class);
		return true;			
	}
    
	
	public Boolean inscription() throws IOException, ParseException {

		   String reponse = Web_Service.getService()
				   		.path("utilisateur/ajout").queryParam("nom", getNom())
				   		.queryParam("prenom", getPrenom()).queryParam("email",getEmail())
				   		.queryParam("password", getPassword()).queryParam("sexe", getSexe())
				   		.queryParam("dateN", new SimpleDateFormat("yyyy/MM/dd").format(getDateNaissance()))
				   		.queryParam("poids", poids+"").queryParam("taille",taille+"")
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
        double tailleEnM= taille/100;
        IMC = poids / (tailleEnM*tailleEnM);
    }
	
	/***
	 * Calcul le métabolisme de la personne
	 */
	public void calculerMetabolisme() {
		LocalDate date = dateNaissance.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		if(this.sexe.equals("F")) {
			setMetabolisme((poids * 9.99) + (6.25 * taille) - (5 * (calculAge(date))) - 161);
		}else {
			setMetabolisme((poids * 9.99) + (6.25 * taille) - (5 * (calculAge(date))) + 5);
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


  public void Besoin(double metabolisme) {
    	besoin_proteine = getPoids() * 2;
    	besoin_lipide = getPoids();
    	besoin_glucide = metabolisme - besoin_proteine - besoin_lipide;
    }
    
    public Boolean connexion(String email , String pass) throws ParseException {
		   String JSONAnswer = Web_Service.getService()
				   		.path("utilisateur/get_user")
				   		.queryParam("login",email)
				   		.queryParam("pass",pass)
						.accept(MediaType.APPLICATION_JSON)
						.post(String.class);

		   /*Conversiondu XML en classe mappée*/
			try {
				 JSONObject o= new JSONObject(JSONAnswer);
				 setId(o.getInt("idutilisateur"));
				 setNom(o.getString("nom"));
				 setPrenom(o.getString("prenom"));
				 setEmail(o.getString("email"));
				 setPassword(o.getString("mdp"));
				 sexe=o.getString("sexe");
				 String s = o.getString("datenaissance");
				 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S");
				 Date d = sdf.parse(s);
				 dateNaissance=d;
				 poids=o.getDouble("poids");
				 taille=o.getDouble("taille");
				 calculIMC();
				 calculerMetabolisme();
		/*	} catch (JAXBException e1) {
				return false;*/
			}	catch (NullPointerException e){
				return false;
			}
    	return true;
    }
    
    
    public Boolean AppelAjoutAliment(Aliment alim) throws IOException {
    	System.out.println(getId());
    	return alim.AjouterAliment(getId());
    }
    
}
