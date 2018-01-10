package REST;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import Singleton.Connexion;
import model.Aliment;
import model.Consommation;
import model.List_Consommation;
import oracle.jdbc.OracleTypes;

public class List_Consommation_REST {
	static Connection con = Connexion.getInstance();
	
	@GET
	@Produces(MediaType.TEXT_XML)
	@Path("list_consommation")
	public Response getXml(@QueryParam("idJournee") int idJ) throws SQLException {
		
		LinkedList<Consommation> lcons= new LinkedList<Consommation>();
		
		CallableStatement myStmt =con.prepareCall("BEGIN ?:= gestion_aliment.get_all_alimentJournee(?); END;");
		myStmt.registerOutParameter(1, OracleTypes.CURSOR);
		myStmt.setInt(2, idJ);
		myStmt.execute();
		ResultSet rs = (ResultSet) myStmt.getObject(1);

		while (rs.next()) {
		    lcons.add(new Consommation(new Aliment(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getDouble(4),
		    		rs.getDouble(5),rs.getDouble(6),rs.getDouble(7),rs.getDouble(8),rs.getDouble(9)),rs.getDouble(10),rs.getString(11)));
		}
		myStmt.close();
		rs.close();
		List_Consommation list= new List_Consommation(lcons);
		return Response.status(Status.OK).entity(list).build();
	}

	public static LinkedList<Consommation> getList(int id) throws SQLException {

		LinkedList<Consommation> lcons= new LinkedList<Consommation>();
		
		
		CallableStatement myStmt2 =con.prepareCall("BEGIN ?:= gestion_aliment.get_all_alimentP_Journee(?); END;");
		myStmt2.registerOutParameter(1, OracleTypes.CURSOR);
		myStmt2.setInt(2, id);
		myStmt2.execute();
		ResultSet rs2 = (ResultSet) myStmt2.getObject(1);
		while (rs2.next()) {
		    lcons.add(new Consommation(new Aliment(rs2.getInt(1),rs2.getString(2),rs2.getDouble(3),rs2.getDouble(4),
		    		rs2.getDouble(5),rs2.getDouble(6),rs2.getDouble(7),rs2.getDouble(8),rs2.getDouble(9)),rs2.getDouble(11),rs2.getString(12)));
		}
		
		
		myStmt2.close();
		rs2.close();
	
		
		return lcons;
	}

}
