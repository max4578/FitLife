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


@XmlRootElement(name="list_seance")
public class List_Seance {

	private List<Seance> list_seance= new LinkedList<Seance>();;

	@XmlElement
	public List<Seance> getList_seance() {
		return list_seance;
	}

	public List_Seance(List<Seance> lseance) {
		list_seance=lseance;
	}
	
	public List_Seance() {
		
	}
	
	
	public List<Seance> getSeance(int idU) {
		String reponse = Web_Service.getService()
		   		.path("list_seance/seance_user")
		   		.queryParam("idUser", idU+"")
		   		.post(String.class);
		try {
			   JAXBContext jaxbContext = JAXBContext.newInstance(List_Seance.class);
			   Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			   StringReader reader = new StringReader(reponse);
			   List_Seance lc = (List_Seance) unmarshaller.unmarshal(reader);
			   list_seance = lc.getList_seance();
		} catch (JAXBException e1) {
			return null;
		}	catch (NullPointerException e){
			return null;
		}
		return list_seance;
	}
}