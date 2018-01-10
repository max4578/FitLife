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

@Path("consommation")
public class Consommation_REST {

	Connection con = Connexion.getInstance();

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("ajout")
	public Response CreateConsommation(@QueryParam("aliment") int aliment,@QueryParam("journee") int journee,@QueryParam("qtt") Double qtt,
			@QueryParam("periode") String periode) throws SQLException, ParseException {	

		
		CallableStatement myStmt =con.prepareCall("BEGIN create_Consommation(?,?,?,?); END;");
		myStmt.setInt(1,aliment);
		myStmt.setInt(2,journee);
		myStmt.setDouble(3,qtt);	
		myStmt.setString(4,periode);
		myStmt.execute();
		myStmt.close();
		return Response.status(Status.OK).build();			

	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("modifier")
	public Response UpdateConsommation(@QueryParam("aliment") int aliment,@QueryParam("journee") int journee,@QueryParam("qtt") Double qtt,
			@QueryParam("periode") String periode) throws SQLException, ParseException {	

		
		CallableStatement myStmt =con.prepareCall("BEGIN update_Consommation(?,?,?,?); END;");
		myStmt.setInt(1,aliment);
		myStmt.setInt(2,journee);
		myStmt.setDouble(3,qtt);	
		myStmt.setString(4,periode);
		myStmt.execute();
		myStmt.close();
		return Response.status(Status.OK).build();			

	}
	
	
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("supprimer")
	public Response DeleteConsommation(@QueryParam("aliment") int aliment,@QueryParam("journee") int journee) throws SQLException, ParseException {	
		CallableStatement myStmt =con.prepareCall("BEGIN delete_Consommation(?,?); END;");
		myStmt.setInt(1,aliment);
		myStmt.setInt(2,journee);
		myStmt.execute();
		myStmt.close();
		return Response.status(Status.OK).build();			

	}
	

}