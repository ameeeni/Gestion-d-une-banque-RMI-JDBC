import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class CompteEpargne extends Compte implements Serializable 
{ 
	private double decouvert; 
	
	public CompteEpargne() throws RemoteException {
		super();
	}

	public CompteEpargne(int id, double solde, Date dateCreation, double decouvert , Operation operation) throws RemoteException {
		super(id, solde , dateCreation , operation);
		this.decouvert = decouvert;
	}
	

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

	@Override
	public void verser(double montant) throws SQLException  {
		PreparedStatement prpstmt; 
		ResultSet res;

		Connection con = SingletonConnection.getConnection();
		prpstmt = con.prepareStatement("select ? from operation where num_cpt =  ?");
		prpstmt.setDouble(1, montant);
		prpstmt.setInt(2, 1);
		res=prpstmt.executeQuery();
		while(res.next()) {
			setSolde(montant+getSolde());
		}
	}

	@Override
	public void retirer(double montant) {
        System.out.println("Votre compte est Epargne vous ne pouvez pas retirer un montant");		
	}
	
	  public boolean montantDecouvert(){
          if (getSolde()<0){
              return false;
          }
          else
          {
              return true;
          }
      }

	@Override
	public void virement(double montant) throws SQLException {
		PreparedStatement prpstmt; 
		ResultSet res;

		Connection con = SingletonConnection.getConnection();
		prpstmt = con.prepareStatement("select ? from operation where num_cpt =  ?");
		prpstmt.setDouble(1, montant);
		prpstmt.setInt(2, 1);
		res=prpstmt.executeQuery();
		while(res.next()) {
			if( montantDecouvert()) {
				setSolde(getSolde()- montant);
				
			}
		}
		
	}

	@Override
	public String toString() {
		return "CompteEpargne [decouvert=" + decouvert + "]";
	}

	
}
