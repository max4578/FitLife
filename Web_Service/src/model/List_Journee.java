package model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="list_journee")
public class List_Journee {
	private List<Journee> list_journee;

	@XmlElement
	public List<Journee> getList_journee() {
		return list_journee;
	}
	
	
	public List_Journee(List<Journee> ljournee) {
		list_journee=ljournee;
	}

	
	public List_Journee() {
		
	}
}
