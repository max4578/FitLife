package REST;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import Singleton.Connexion;
import model.Exercice;
import model.List_Seance;
import model.Seance;
import oracle.jdbc.OracleTypes;

@Path("list_seance")
public class List_Seance_REST {
	static Connection con = Connexion.getInstance();

	@GET
	@Produces(MediaType.TEXT_XML)
	public Response getXml() throws SQLException {
		
		LinkedList<Seance> lseance= new LinkedList<Seance>();
		
		CallableStatement myStmt =con.prepareCall("BEGIN ?:= get_all_seance; END;");
		myStmt.registerOutParameter(1, OracleTypes.CURSOR);
		myStmt.execute();
		ResultSet rs = (ResultSet) myStmt.getObject(1);

		while (rs.next()) {
			java.util.Date newDate = rs.getTimestamp(3);
		    lseance.add(new Seance(rs.getInt(1),new LinkedList<Exercice>(),rs.getString(2),newDate));
		}
		for(Seance s:lseance) {
			s.setList_exercice(List_Exercice_REST.getList_seance(s.getId()));
		}
		myStmt.close();
		rs.close();
		List_Seance list= new List_Seance(lseance);
		return Response.status(Status.OK).entity(list).build();
	}
	
	
	
	@POST
	@Produces(MediaType.TEXT_XML)
	@Path("seance_user")
	public Response get_Seance_user(@QueryParam("idUser") int id) throws SQLException {
		
		LinkedList<Seance> lseance= new LinkedList<Seance>();
		
		CallableStatement myStmt =con.prepareCall("BEGIN ?:= get_seance_user(?); END;");
		myStmt.registerOutParameter(1, OracleTypes.CURSOR);
		myStmt.setInt(2, id);
		myStmt.execute();
		ResultSet rs = (ResultSet) myStmt.getObject(1);

		while (rs.next()) {
			java.util.Date newDate = rs.getTimestamp(3);
		    lseance.add(new Seance(rs.getInt(1),new LinkedList<Exercice>(),rs.getString(2),newDate));
		}
		for(Seance s:lseance) {
			s.setList_exercice(List_Exercice_REST.getList_seance(s.getId()));
		}
		myStmt.close();
		rs.close();
		List_Seance list= new List_Seance(lseance);
		return Response.status(Status.OK).entity(list).build();
	}
	
	
	public static List<Seance> getList(int id) throws SQLException {
		
		LinkedList<Seance> lseance= new LinkedList<Seance>();
		
		CallableStatement myStmt =con.prepareCall("BEGIN ?:= get_all_seance_journee(?); END;");
		myStmt.registerOutParameter(1, OracleTypes.CURSOR);
		myStmt.setInt(2,id);
		myStmt.execute();
		ResultSet rs = (ResultSet) myStmt.getObject(1);

		while (rs.next()) {
		    lseance.add(new Seance(rs.getInt(1),new LinkedList<Exercice>(),rs.getString(2),rs.getDate(3)));
		}
		for(Seance s:lseance) {
			s.setList_exercice(List_Exercice_REST.getList_seance(s.getId()));
		}
		myStmt.close();
		rs.close();
		return lseance;
	}
}