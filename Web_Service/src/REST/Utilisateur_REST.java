package REST;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import Singleton.Connexion;
import model.Aliment;
import model.Utilisateur;
import oracle.jdbc.OracleTypes;


@Path("utilisateur")
public class Utilisateur_REST {
	Connection con = Connexion.getInstance();

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("ajout")
	public Response CreateUser(@FormParam("nom") String nom,@FormParam("prenom") String prenom,@FormParam("email") String email,
			@FormParam("password") String password,@FormParam("sexe") String sexe,
			@FormParam("dateN") String dateN,@FormParam("poids") String poids,
			@FormParam("taille") String taille) throws SQLException, ParseException {	
		
		CallableStatement myStmtBefore =con.prepareCall("BEGIN ?:= get_VerifUser(?); END;");
		myStmtBefore.registerOutParameter(1, OracleTypes.CURSOR);
		myStmtBefore.setString(2, email);
		myStmtBefore.execute();
		ResultSet rs = (ResultSet) myStmtBefore.getObject(1);
		int cpt=0;
		while (rs.next()) 
		    cpt++;
		
		if(cpt==0) {
			CallableStatement myStmt =con.prepareCall("BEGIN create_utilisateur(?,?,?,?,?,TO_DATE(?, 'yyyy/mm/dd'),?,?); END;");
			myStmt.setString(1,nom);
			myStmt.setString(2,prenom);
			myStmt.setString(3,email);
			myStmt.setString(4,password);
			myStmt.setString(5,sexe);
			myStmt.setString(6,dateN);
			myStmt.setDouble(7,Double.parseDouble(poids));
			myStmt.setDouble(8,Double.parseDouble(taille));		
			myStmt.execute();
			return Response.status(Status.OK).build();
		}else
			return Response.status(Status.FOUND).build();
				
	}
	
	
	@GET
	@Produces(MediaType.TEXT_XML)
	@Path("{email}/{pass}")
	public Response getXml(@PathParam("email") String email, @PathParam("pass") String pass) throws SQLException {	
		
		CallableStatement myStmt =con.prepareCall("BEGIN ?:= get_utilisateur(?,?); END;");
		myStmt.registerOutParameter(1, OracleTypes.CURSOR);
		myStmt.setString(2, email);
		myStmt.setString(3, pass);
		myStmt.execute();
		ResultSet rs = (ResultSet) myStmt.getObject(1);
		Utilisateur user=null;

		while (rs.next()) {
			java.util.Date newDate = rs.getTimestamp(7);
			System.out.println(newDate.toString());
		    user=new Utilisateur(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(5),
		    		rs.getString(6),rs.getString(4),newDate,rs.getDouble(8),rs.getDouble(9),rs.getString(10));
		   System.out.println(newDate.toString());
		}
		
		return Response.status(Status.OK).entity(user).build();
	}
	

	
}