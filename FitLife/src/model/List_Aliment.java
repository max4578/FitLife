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


@XmlRootElement(name="list_aliment")
public class List_Aliment {

	private LinkedList<Aliment> list_aliment= new LinkedList<Aliment>();

	@XmlElement
	public LinkedList<Aliment> getList_aliment() {
		return list_aliment;
	}




	
	public List_Aliment() {
		
	}
	

	public List_Aliment(LinkedList<Aliment> lAlim) {
		list_aliment=lAlim;
		
	}
	
	
/*	
	public void getList_Perso(int idUser) {
		
		LinkedList<Aliment> typed_list=new LinkedList<Aliment>();
		String reponse = Web_Service.getService()
		   		.path("list_aliment/alim_user")
		   		.queryParam("idUser",idUser+"")
		   		.post(String.class);
		try {
			   JAXBContext jaxbContext = JAXBContext.newInstance(List_Aliment.class);
			   Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			   StringReader reader = new StringReader(reponse);
			   List_Aliment le = (List_Aliment) unmarshaller.unmarshal(reader);
			   list_aliment = le.getList_aliment();
			   for(Aliment a:list_aliment) {
				  typed_list.add(new Aliment(a.getId(),a.getNom(),a.getCalorie(),a.getLipide(),
						  a.getAcideG(),a.getGlucide(),a.getSucre(),a.getProteine(),a.getQuantiteType()));
			   }
			   list_aliment=typed_list;
		} catch (JAXBException e1) {
			System.out.println("JB ex;"+e1.getMessage());
		}	catch (NullPointerException e){
			System.out.println("NULL ex;"+e.getMessage());
		}
		
	}*/
	
	public List<Aliment> getList(int idUser) {
		String reponse = Web_Service.getService()
		   		.path("list_aliment")
		   		.queryParam("idUser",idUser+"")
		   		.post(String.class);
		try {
			   JAXBContext jaxbContext = JAXBContext.newInstance(List_Aliment.class);
			   Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			   StringReader reader = new StringReader(reponse);
			   List_Aliment le = (List_Aliment) unmarshaller.unmarshal(reader);
			   list_aliment = le.getList_aliment();
			
		} catch (JAXBException e1) {
			System.out.println("JB ex:"+e1.getMessage());
		}	catch (NullPointerException e){
			System.out.println("NULL ex:"+e.getMessage());
		}
		return list_aliment;
	}
}
