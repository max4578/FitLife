package REST;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import Singleton.Connexion;
import model.Exercice;
import model.Seance;
import oracle.jdbc.OracleTypes;

@Path("seance")
public class Seance_REST {
	Connection con = Connexion.getInstance();

	@GET
	@Produces(MediaType.TEXT_XML)
	@Path("{id}")
	public Response getXml(@PathParam("id") int id) throws SQLException {	
		
		CallableStatement myStmt =con.prepareCall("BEGIN ?:= get_seance(?); END;");
		myStmt.registerOutParameter(1, OracleTypes.CURSOR);
		myStmt.setInt(2, id);
		myStmt.execute();
		ResultSet rs = (ResultSet) myStmt.getObject(1);
		Seance seance=null;
		while (rs.next()) {
			/*(List<Exercice> list_exercice, String nom, Date dateCreation)*/
		    seance=new Seance(rs.getInt(1),new LinkedList<Exercice>(),rs.getString(2),rs.getDate(3));
		}
		
		return Response.status(Status.OK).entity(seance).build();
	}
}
