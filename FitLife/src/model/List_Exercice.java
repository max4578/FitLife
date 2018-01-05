package model;

import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import webservice.Web_Service;

@XmlRootElement(name="list_exercice")
public class List_Exercice {
	private List<Exercice> list_exercice= new LinkedList<Exercice>();

	@XmlElement
	public List<Exercice> getList_exercice() {
		return list_exercice;
	}


	
	public List_Exercice() {
		
	}
	
	public List_Exercice(List<Exercice> lex) {
			list_exercice=lex;
	}
	
	
	
	public List<Exercice> getList() {
		String reponse = Web_Service.getService()
		   		.path("list_exercice")
		   		.post(String.class);
		try {
			   JAXBContext jaxbContext = JAXBContext.newInstance(List_Exercice.class);
			   Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			   StringReader reader = new StringReader(reponse);
			   List_Exercice le = (List_Exercice) unmarshaller.unmarshal(reader);
			   list_exercice = le.getList_exercice();
		} catch (JAXBException e1) {
			return null;
		}	catch (NullPointerException e){
			return null;
		}
		return list_exercice;
	}
}