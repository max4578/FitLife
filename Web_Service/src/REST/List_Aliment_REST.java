package REST;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
	
	/*Recupère la liste des aliments de l' utilisateur*/
	@POST
	@Produces(MediaType.TEXT_XML)
	public Response getXml(@QueryParam("idUser") int idUser) throws SQLException {		
		LinkedList<Aliment> lalim= new LinkedList<Aliment>();
		CallableStatement myStmt2 =con.prepareCall("BEGIN ?:= gestion_aliment.get_all_aliment_user(?); END;");
		myStmt2.registerOutParameter(1, OracleTypes.CURSOR);
		myStmt2.setInt(2, idUser);
		myStmt2.execute();
		ResultSet rs2 = (ResultSet) myStmt2.getObject(1);
		int cpt=0;
		while (rs2.next()) {
		    lalim.add(new Aliment(rs2.getInt(1),rs2.getString(2),rs2.getDouble(3),rs2.getDouble(4),
		    		rs2.getDouble(5),rs2.getDouble(6),rs2.getDouble(7),rs2.getDouble(8),rs2.getDouble(9)));
		    cpt++;
		}	
		myStmt2.close();
		rs2.close();
		List_Aliment list= new List_Aliment(lalim,cpt);
		return Response.status(Status.OK).entity(list).build();
	}
	
		

}
