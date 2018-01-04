package model;

import java.util.LinkedList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="list_aliment")
public class List_Aliment {

	private LinkedList<Aliment> list_aliment= new LinkedList<Aliment>();;
	
	@XmlElement
	public LinkedList<Aliment> getList_aliment() {
		return list_aliment;
	}


	
	public List_Aliment() {
		
	}
	

	public List_Aliment(LinkedList<Aliment> lAlim) {
		list_aliment=lAlim;
	}
}
