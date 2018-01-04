package webservice;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class Web_Service {
	
	private static WebResource service=null;
	
	public static WebResource getService() {
		if(service==null)
			new Web_Service();
		return service;
	}
	
	
	public Web_Service() {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		service = client.resource(getBaseURI());
	}
	
	
	  private static URI getBaseURI() {
		   return UriBuilder.fromUri("http://localhost:9090/Web_Service/rest/").build();
	}
	
	

}
