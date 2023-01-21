import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientTest {
public static void main(String[] args) {
	try {
		 Registry reg = LocateRegistry.getRegistry(null); 
		    
         // Recherche dans le registre de l'objet distant
		  iCompte stub = (iCompte) reg.lookup("iCompte");
		  
	}catch(Exception e) { System.err.println(e.toString()); }
}
}
