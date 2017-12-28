package REST;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import Singleton.Connexion;
import model.Aliment;
import model.List_Aliment;
import oracle.jdbc.OracleTypes;


@Path("list_aliment")
public class List_Aliment_REST {
	Connection con = Connexion.getInstance();

	@GET
	@Produces(MediaType.TEXT_XML)
	public Response getXml() throws SQLException {
		
		LinkedList<Aliment> lalim= new LinkedList<Aliment>();
		
		CallableStatement myStmt =con.prepareCall("BEGIN ?:= get_all_aliment; END;");
		myStmt.registerOutParameter(1, OracleTypes.CURSOR);
		myStmt.execute();
		ResultSet rs = (ResultSet) myStmt.getObject(1);

		while (rs.next()) {
		    lalim.add(new Aliment(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getDouble(4),
		    		rs.getDouble(5),rs.getDouble(6),rs.getDouble(7),rs.getDouble(8),rs.getDouble(9)));
		}
		
		List_Aliment list= new List_Aliment(lalim);
		return Response.status(Status.OK).entity(list).build();
	}

}
