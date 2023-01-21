import java.io.Serializable;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class CompteCourant  extends   Compte implements Serializable  {
    private double taux; 
    
	public CompteCourant(int id, double solode, Date dateCreation, double taux , Operation operation) throws RemoteException {
		super(id, solode, dateCreation , operation);
		this.taux = taux;
	}
   
	public CompteCourant() throws RemoteException {
		super();
	}
	

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

	@Override
	public void verser(double montant) throws SQLException {
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
	 public boolean montantTaux(){
		 double montant = 0;
         if ((montant*taux) > getSolde() & (getSolde()<0)){
             return false;
         }
         else
         {
             return true;
         }
     }
	@Override
	public void retirer(double montant) throws SQLException {
		PreparedStatement prpstmt; 
		ResultSet res;

		Connection con = SingletonConnection.getConnection();
		prpstmt = con.prepareStatement("select ? from operation where num_cpt =  ?");
		prpstmt.setDouble(1, montant);
		prpstmt.setInt(2, 1);
		res=prpstmt.executeQuery();
		while(res.next()) {
			if(montantTaux()) {
				setSolde(getSolde()- montant);
				
			}
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
			if(montantTaux()) {
				setSolde(getSolde()- montant);
				System.out.println("le montant a envoyer est : " + montant);
				
			}
		}
		
	}

}
