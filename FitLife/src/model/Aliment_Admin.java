package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="aliment_admin")
public class Aliment_Admin extends Aliment {

	
	
	
	public Aliment_Admin(int id,String nom ,double calorie, double lipide, double acideG,  double glucide, double sucre,
			double proteine, double quantiteType) {
		super(id,nom, calorie, lipide, acideG, glucide, sucre, proteine, quantiteType);
	}
		

	public Aliment_Admin() {
		// TODO Auto-generated constructor stub
	}


	public void AjouterAliment() {
		
	}
	
	public void ModifierAliment() {
		
	}
	
	public void SupprimerAliment() {
		
	}
}
