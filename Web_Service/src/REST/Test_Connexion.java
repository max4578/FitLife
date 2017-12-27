package REST;

import java.sql.Connection;
import java.sql.SQLException;

import Singleton.Connexion;

public class Test_Connexion {

	public static void main(String[] args) {
		Connection con= Connexion.getInstance();
		try {
			if(con.isClosed())
				System.out.println("La base de donnée est innacessible"+con.isClosed());
			else
				System.out.println("Connexion effectuée");
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
