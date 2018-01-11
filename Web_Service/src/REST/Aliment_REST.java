package REST;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import javax.ws.rs.Consumes;
import javax.ws.rs.QueryParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import Singleton.Connexion;

@Path("aliment")
public class Aliment_REST {
	/*Creation de la connexion DB*/
	Connection con = Connexion.getInstance();
	
	
	/*Ajoute un aliment avec ses informations passé dans la requète*/
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
	
	/*Modifie un aliment avec ses informations passé dans la requète*/
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
	
	/*Supprime un aliment avec son ID passé dans la requète*/
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
	
