package model;

public class Consommation {
	
	
	/*Attributs*/
	private Aliment aliment;
	private Double quantite;
	private String periode;
	
	
	/*Getters et setters*/
	public Aliment getAliment() {
		return aliment;
	}
	public void setAliment(Aliment aliment) {
		this.aliment = aliment;
	}
	public Double getQuantite() {
		return quantite;
	}
	public void setQuantite(Double quantite) {
		this.quantite = quantite;
	}
	public String getPeriode() {
		return periode;
	}
	public void setPeriode(String periode) {
		this.periode = periode;
	}
	
	/*Constructeur(s)*/
	public Consommation(Aliment aliment, Double quantite, String periode) {
		super();
		this.aliment = aliment;
		this.quantite = quantite;
		this.periode = periode;
	}

	
	/*Methode*/
	
	
}
