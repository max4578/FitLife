package model;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="list_exercice")
public class List_Exercice {
	private List<Exercice> list_exercice= new LinkedList<Exercice>();;

	@XmlElement
	public List<Exercice> getList_exercice() {
		return list_exercice;
	}


	
	public List_Exercice() {
		
	}
	
	public List_Exercice(List<Exercice> lex) {
			list_exercice=lex;
	}
}
