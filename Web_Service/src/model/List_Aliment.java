package model;

import java.util.LinkedList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="list_aliment")
public class List_Aliment {

	private LinkedList<Aliment> list_aliment= new LinkedList<Aliment>();
	private int nbrAlim_user;
	
	@XmlElement
	public LinkedList<Aliment> getList_aliment() {
		return list_aliment;
	}
	@XmlElement
	public int getNbrAlim_user() {
		return nbrAlim_user;
	}
	public void setNbrAlim_user(int nbrAlim_user) {
		this.nbrAlim_user = nbrAlim_user;
	}


	
	public List_Aliment() {
		
	}
	

	public List_Aliment(LinkedList<Aliment> lAlim,int nbr) {
		list_aliment=lAlim;
		nbrAlim_user=nbr;
	}

}
