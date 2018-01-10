package REST;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.LinkedList;
import javax.ws.rs.Consumes;
import javax.ws.rs.QueryParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
		
		CallableStatement myStmt =con.prepareCall("BEGIN ?:= gestion_seance.get_seance(?); END;");
		myStmt.registerOutParameter(1, OracleTypes.CURSOR);
		myStmt.setInt(2, id);
		myStmt.execute();
		ResultSet rs = (ResultSet) myStmt.getObject(1);
		Seance seance=null;
		while (rs.next()) {
		    seance=new Seance(rs.getInt(1),new LinkedList<Exercice>(),rs.getString(2),rs.getDate(3));
		}
		myStmt.close();
		rs.close();
		return Response.status(Status.OK).entity(seance).build();
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("ajout")
	public Response CreateSeance(@QueryParam("idUser") int idUser,@QueryParam("nom") String nom) throws SQLException, ParseException {	

		
		CallableStatement myStmt =con.prepareCall("BEGIN gestion_seance.create_Seance(?,?); END;");
		myStmt.setInt(1,idUser);
		myStmt.setString(2,nom);
		myStmt.execute();
		myStmt.close();
		return Response.status(Status.OK).build();			

	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("ajouter_exercice")
	public Response AddExercice_seance(@QueryParam("idExercice") int idE,@QueryParam("idSeance") int idS,@QueryParam("repetition") int repet) throws SQLException, ParseException {	
		CallableStatement myStmt =con.prepareCall("BEGIN gestion_seance.add_exercice_Seance(?,?,?); END;");
		myStmt.setInt(1,idE);
		myStmt.setInt(2,idS);
		myStmt.setInt(3,repet);
		myStmt.execute();
		myStmt.close();
		return Response.status(Status.OK).build();			

	}
	
	
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("modification")
	public Response UpdateSeance(@QueryParam("idSeance") int idSeance,@QueryParam("nom") String nom) throws SQLException, ParseException {	

		
		CallableStatement myStmt =con.prepareCall("BEGIN gestion_seance.update_Seance(?,?); END;");
		myStmt.setInt(1,idSeance);
		myStmt.setString(2,nom);
		myStmt.execute();
		myStmt.close();
		return Response.status(Status.OK).build();			

	}
	
	
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("supprimer")
	public Response DeleteSeance(@QueryParam("idSeance") int idSeance) throws SQLException, ParseException {	

		
		CallableStatement myStmt =con.prepareCall("BEGIN gestion_seance.delete_Seance(?); END;");
		myStmt.setInt(1,idSeance);		
		myStmt.execute();
		myStmt.close();
		return Response.status(Status.OK).build();			

	}
}
