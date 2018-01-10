package REST;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

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
import model.Aliment;
import oracle.jdbc.OracleTypes;

@Path("aliment")
public class Aliment_REST {
	Connection con = Connexion.getInstance();

	@GET
	@Produces(MediaType.TEXT_XML)
	@Path("{id}")
	public Response getXml(@PathParam("id") int id) throws SQLException {	
		
		CallableStatement myStmt =con.prepareCall("BEGIN ?:= gestion_aliment.get_aliment(?); END;");
		myStmt.registerOutParameter(1, OracleTypes.CURSOR);
		myStmt.setInt(2, id);
		myStmt.execute();
		ResultSet rs = (ResultSet) myStmt.getObject(1);
		Aliment alim=null;
		while (rs.next()) {
		    alim=new Aliment(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getDouble(4),
		    		rs.getDouble(5),rs.getDouble(6),rs.getDouble(7),rs.getDouble(8),rs.getDouble(9));
		}
		myStmt.close();
		rs.close();
		return Response.status(Status.OK).entity(alim).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("ajout")
	public Response CreateAliment(@QueryParam("nom") String nom,@QueryParam("calorie") Double calorie,@QueryParam("lipide") Double lipide,
			@QueryParam("acideG") Double acideG,@QueryParam("glucide") Double glucide,
			@QueryParam("sucre") Double sucre,@QueryParam("proteine") Double proteine,
			@QueryParam("qtt") Double qtt,@QueryParam("idUser") int id) throws SQLException, ParseException {	

		
		CallableStatement myStmt =con.prepareCall("BEGIN gestion_aliment.create_Aliment_User(?,?,?,?,?,?,?,?,?); END;");
		myStmt.setString(1,nom);
		myStmt.setDouble(2,calorie);
		myStmt.setDouble(3,lipide);
		myStmt.setDouble(4,acideG);
		myStmt.setDouble(5,glucide);
		myStmt.setDouble(6,sucre);
		myStmt.setDouble(7,proteine);
		myStmt.setDouble(8,qtt);	
		myStmt.setInt(9,id);	
		myStmt.execute();
		myStmt.close();
		return Response.status(Status.OK).build();			
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("modification")
	public Response UpdateAliment(@QueryParam("nom") String nom,@QueryParam("calorie") Double calorie,@QueryParam("lipide") Double lipide,
			@QueryParam("acideG") Double acideG,@QueryParam("glucide") Double glucide,
			@QueryParam("sucre") Double sucre,@QueryParam("proteine") Double proteine,
			@QueryParam("qtt") Double qtt,@QueryParam("idAlim") int id) throws SQLException, ParseException {	

		
		CallableStatement myStmt =con.prepareCall("BEGIN gestion_aliment.update_Aliment_User(?,?,?,?,?,?,?,?,?); END;");
		myStmt.setString(1,nom);
		myStmt.setDouble(2,calorie);
		myStmt.setDouble(3,lipide);
		myStmt.setDouble(4,acideG);
		myStmt.setDouble(5,glucide);
		myStmt.setDouble(6,sucre);
		myStmt.setDouble(7,proteine);
		myStmt.setDouble(8,qtt);	
		myStmt.setInt(9,id);	
		myStmt.execute();
		myStmt.close();
		return Response.status(Status.OK).build();			
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("supprimer")
	public Response DeleteAliment(@QueryParam("idAlim") int id) throws SQLException, ParseException {		
		CallableStatement myStmt =con.prepareCall("BEGIN gestion_aliment.delete_Aliment_User(?); END;");
		myStmt.setInt(1,id);	
		myStmt.execute();
		myStmt.close();
		return Response.status(Status.OK).build();			
	}
}
	
