import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public abstract class Compte  extends UnicastRemoteObject implements Serializable , iCompte{
 private int id ;
 private double solde; 
 private Date dateCreation;
 private Operation operation;
public Compte() throws RemoteException {
	super();
}
public Compte(int id, double solde, Date dateCreation , Operation  operation) throws RemoteException {
	super();
	this.id = id;
	this.solde = solde;
	this.dateCreation = dateCreation;
	this.operation=operation;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public double getSolde() {
	return solde;
}
public void setSolde(double solde) {
	this.solde = solde;
}
public Date getDateCreation() {
	return dateCreation;
}
public void setDateCreation(Date dateCreation) {
	this.dateCreation = dateCreation;
}

public Operation getOperation() {
	return operation;
}
public void setOperation(Operation operation) {
	this.operation = operation;
}
@Override
public String toString() {
	return "Compte [id=" + id + ", solode=" + solde + ", dateCreation=" + dateCreation + "]";
}

}
