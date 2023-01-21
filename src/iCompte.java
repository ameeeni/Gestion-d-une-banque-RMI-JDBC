import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

public interface iCompte extends Remote {
	 void verser(double montant) throws RemoteException, SQLException;
	 void retirer(double montant) throws RemoteException, SQLException ; 
	 void virement(double montant) throws RemoteException, SQLException;

}
