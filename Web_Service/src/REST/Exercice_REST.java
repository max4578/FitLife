package REST;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import Singleton.Connexion;
import model.Exercice;
import oracle.jdbc.OracleTypes;

@Path("exercice")
public class Exercice_REST {

	Connection con = Connexion.getInstance();

	@GET
	@Produces(MediaType.TEXT_XML)
	@Path("{id}")
	public Response getXml(@PathParam("id") int id) throws SQLException {	
		
		CallableStatement myStmt =con.prepareCall("BEGIN ?:= get_exercice(?); END;");
		myStmt.registerOutParameter(1, OracleTypes.CURSOR);
		myStmt.setInt(2, id);
		myStmt.execute();
		ResultSet rs = (ResultSet) myStmt.getObject(1);
		Exercice exercice=null;
		while (rs.next()) {		
		    exercice=new Exercice(rs.getInt(1),rs.getString(2),rs.getString(4),rs.getString(3),
		    		rs.getInt(1));
		}
		myStmt.close();
		rs.close();
		return Response.status(Status.OK).entity(exercice).build();
	}
	

}
