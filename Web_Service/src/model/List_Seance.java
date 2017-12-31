package model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="list_seance")
public class List_Seance {

	private List<Seance> list_seance;

	@XmlElement
	public List<Seance> getList_seance() {
		return list_seance;
	}

	public List_Seance(List<Seance> lseance) {
		list_seance=lseance;
	}
	
	public List_Seance() {
		
	}
}
