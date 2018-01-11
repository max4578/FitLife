package REST;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import javax.ws.rs.Consumes;
import javax.ws.rs.QueryParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import Singleton.Connexion;
import oracle.jdbc.OracleTypes;


@Path("utilisateur")
public class Utilisateur_REST {
	Connection con = Connexion.getInstance();
	
	/*Création de l' utilisateur*/
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("ajout")
	public Response CreateUser(@QueryParam("nom") String nom,@QueryParam("prenom") String prenom,@QueryParam("email") String email,
			@QueryParam("password") String password,@QueryParam("sexe") String sexe,
			@QueryParam("dateN") String dateN,@QueryParam("poids") String poids,
			@QueryParam("taille") String taille) throws SQLException, ParseException {	

			CallableStatement myStmt =con.prepareCall("BEGIN  ?:=gestion_utilisateur.create_utilisateur(?,?,?,?,?,TO_DATE(?, 'yyyy/mm/dd'),?,?); END;");
			myStmt.registerOutParameter(1, java.sql.Types.INTEGER);
			myStmt.setString(2,nom);
			myStmt.setString(3,prenom);
			myStmt.setString(4,email);
			myStmt.setString(5,password);
			myStmt.setString(6,sexe);
			myStmt.setString(7,dateN);
			myStmt.setDouble(8,Double.parseDouble(poids));
			myStmt.setDouble(9,Double.parseDouble(taille));	
			myStmt.execute();
			if(myStmt.getInt(1)==1)
				return Response.status(Status.OK).entity("OK").build();
			else
				return Response.status(Status.OK).entity("FOUND").build();
		}			
	
	/*Modification de l' utilisateur*/
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("modifier")
	public Response UpdateUser(@QueryParam("nom") String nom,@QueryParam("prenom") String prenom,@QueryParam("email") String email,
			@QueryParam("password") String password,@QueryParam("sexe") String sexe,
			@QueryParam("dateN") String dateN,@QueryParam("poids") String poids,
			@QueryParam("taille") String taille) throws SQLException, ParseException {
		CallableStatement myStmt =con.prepareCall("BEGIN  gestion_utilisateur.update_utilisateur(?,?,?,?,?,TO_DATE(?, 'yyyy/mm/dd'),?,?); END;");	
		myStmt.setString(1,nom);
		myStmt.setString(2,prenom);
		myStmt.setString(3,email);
		myStmt.setString(4,password);
		myStmt.setString(5,sexe);
		myStmt.setString(6,dateN);
		myStmt.setDouble(7,Double.parseDouble(poids));
		myStmt.setDouble(8,Double.parseDouble(taille));		
		myStmt.executeUpdate();
		myStmt.close();
		return Response.status(Status.OK).build();
	}
	
	/*Retourne l' utilisateur en JSON*/
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("get_user")
	public Response getXml(@QueryParam("login") String email, @QueryParam("pass") String pass) throws Exception {	
		
		CallableStatement myStmt =con.prepareCall("BEGIN ?:= gestion_utilisateur.get_utilisateur(?,?); END;");
		myStmt.registerOutParameter(1, OracleTypes.CURSOR);
		myStmt.setString(2, email);
		myStmt.setString(3, pass);
		myStmt.execute();
		ResultSet rs = (ResultSet) myStmt.getObject(1);

		String JsonReturn=null;
		JsonReturn= convertToJSON(rs);
		myStmt.close();
		rs.close();
		return Response.status(Status.OK).entity(JsonReturn).build();
	}
	
	/*Methode qui permet de generer un script JSON*/
	public static String convertToJSON(ResultSet resultSet) throws Exception {

		String res = "{\n";

		if (resultSet.next()) {
			int total_rows = resultSet.getMetaData().getColumnCount();
			for (int i = 0; i < total_rows; i++) {

				res += "\t\"" + resultSet.getMetaData().getColumnLabel(i + 1).toLowerCase() + "\""; // TODO +1 ?
				res += ": \"" + resultSet.getObject(i + 1) + "\",\n";
			}
		} else
			return null;

		res = res.substring(0, res.length() - 2) + "\n}";

		return res;
}

	
}