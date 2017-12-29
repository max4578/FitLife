package REST;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import Singleton.Connexion;
import model.Aliment;
import model.Utilisateur;
import oracle.jdbc.OracleTypes;


@Path("utilisateur")
public class Utilisateur_REST {
	Connection con = Connexion.getInstance();

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("ajout")
	public Response CreateUser(@FormParam("nom") String nom,@FormParam("prenom") String prenom) throws SQLException {	
		
		System.out.println(nom+" "+prenom);
		CallableStatement myStmt =con.prepareCall("BEGIN ?:= get_aliment(?); END;");
		myStmt.registerOutParameter(1, OracleTypes.CURSOR);
		myStmt.execute();
		ResultSet rs = (ResultSet) myStmt.getObject(1);
		Aliment alim=null;
		while (rs.next()) {
		    alim=new Aliment(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getDouble(4),
		    		rs.getDouble(5),rs.getDouble(6),rs.getDouble(7),rs.getDouble(8),rs.getDouble(9));
		}
		
		return Response.status(Status.OK).entity(alim).build();
	}
	
}