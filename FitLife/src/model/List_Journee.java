package model;

import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import webservice.Web_Service;

@XmlRootElement(name="list_journee")
public class List_Journee {
	
	private List<Journee> list_journee= new LinkedList<Journee>();

	@XmlElement
	public List<Journee> getList_journee() {
		return list_journee;
	}
	
	
	public List_Journee(List<Journee> ljournee) {
		list_journee=ljournee;
	}

	
	public List_Journee() {
		
	}


	public void FindList_journee_user(int id) {
		 String xmlAnswer = Web_Service.getService()
			   		.path("list_journee/journees_utilisateur")
			   		.queryParam("idUser", id+"")
					.accept(MediaType.TEXT_XML)
					.post(String.class);

	   /*Conversiondu XML en classe mappée*/
		try {
			   JAXBContext jaxbContext = JAXBContext.newInstance(List_Journee.class);
			   Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			   StringReader reader = new StringReader(xmlAnswer);
			   
			   List_Journee lj = (List_Journee) unmarshaller.unmarshal(reader);
			   list_journee=lj.getList_journee();
			   System.out.println("boucle liste journee");
			   for(Journee j : list_journee) {
				   System.out.println("id de la journee: "+j.getId());
			   }
		} catch (JAXBException e1) {
			 System.out.println("Erreur JaxB"+e1.getMessage());
		}	catch (NullPointerException e){
			 System.out.println("Erreur null"+e.getMessage());
		}
	}
}