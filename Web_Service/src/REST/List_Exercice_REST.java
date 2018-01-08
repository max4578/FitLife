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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import Singleton.Connexion;
import model.Aliment;
import model.Exercice;
import model.List_Aliment;
import model.List_Exercice;
import oracle.jdbc.OracleTypes;


@Path("list_exercice")
public class List_Exercice_REST {
	static Connection con = Connexion.getInstance();

	@POST
	@Produces(MediaType.TEXT_XML)
	public Response getXml() throws SQLException {
		
		LinkedList<Exercice> lex= new LinkedList<Exercice>();
		
		CallableStatement myStmt =con.prepareCall("BEGIN ?:= get_all_exercice; END;");
		myStmt.registerOutParameter(1, OracleTypes.CURSOR);
		myStmt.execute();
		ResultSet rs = (ResultSet) myStmt.getObject(1);

		while (rs.next()) {
		    lex.add(new Exercice(rs.getInt(1),rs.getString(2),rs.getString(4),rs.getString(3),
		    		rs.getInt(1)));
		}
		
		List_Exercice list= new List_Exercice(lex);
		return Response.status(Status.OK).entity(list).build();
	}

	public static List<Exercice> getList_seance(int id) throws SQLException {
		LinkedList<Exercice> lex= new LinkedList<Exercice>();
		
		CallableStatement myStmt =con.prepareCall("BEGIN ?:= get_all_exercice_seance(?); END;");
		myStmt.registerOutParameter(1, OracleTypes.CURSOR);
		myStmt.setInt(2, id);
		myStmt.execute();
		ResultSet rs = (ResultSet) myStmt.getObject(1);

		while (rs.next()) {
			for(int i=0;i<rs.getInt(5);i++)
		    lex.add(new Exercice(rs.getInt(1),rs.getString(2),rs.getString(4),rs.getString(3),
		    		rs.getInt(1)));
		}
	
		return lex;
	}

}
