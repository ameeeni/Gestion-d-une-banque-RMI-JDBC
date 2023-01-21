import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.sql.SQLException;

public class Server  {

	public static void main(String[] args) {
		try {
		LocateRegistry.createRegistry(1099);
		String url="rmi//localhost:1099/iCompte" ; 
				
		System.out.println("Serveur prêt");
		CompteEpargne obj1 = new CompteEpargne();
		CompteCourant obj2 = new CompteCourant();
		Naming.rebind ( url , obj1); 
		Naming.rebind ( url , obj2); 

		
		}
		catch(Exception e){
			System.out.println ("Erreur serveur : "+e);
			}
		
		

		
	}

	

}
