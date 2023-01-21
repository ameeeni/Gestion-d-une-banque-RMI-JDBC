import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnection {
	private static Connection connexion;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connexion =DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_banque" , "root", "");
		}catch(Exception e) 
		{e.printStackTrace();}
	}
	public static Connection getConnection( ) {
		return connexion;
	}
}
