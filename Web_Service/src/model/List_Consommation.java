package model;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class List_Consommation {

	
	private List<Consommation> list_consommation= new LinkedList<Consommation>();;

	
	@XmlElement
	public List<Consommation> getList_aliment(int idJournee) {
		
		return list_consommation;
	}


	
	public List_Consommation() {
		
	}
	
	
	public List_Consommation(List<Consommation> lcons) {
		list_consommation=lcons;
	}
	
}
