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

@XmlRootElement
public class List_Consommation {


	private List<Consommation> list_consommation= new LinkedList<Consommation>();
	
	@XmlElement
	public List<Consommation> getList() {
		return list_consommation;
	}
	
	
	public List<Consommation> getConsommation(int idJournee) {
		String reponse = Web_Service.getService()
		   		.path("list_consommation")
		   		.queryParam("idJournee", idJournee+"")
		   		.post(String.class);
		try {
			   JAXBContext jaxbContext = JAXBContext.newInstance(List_Consommation.class);
			   Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			   StringReader reader = new StringReader(reponse);
			   List_Consommation lc = (List_Consommation) unmarshaller.unmarshal(reader);
			   list_consommation = lc.getList();
		} catch (JAXBException e1) {
			return null;
		}	catch (NullPointerException e){
			return null;
		}
		return list_consommation;
	}


	
	public List_Consommation() {
		
	}
	
}
