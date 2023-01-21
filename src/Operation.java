import java.util.Date;

public class Operation {
	private int num; 
	private Date dateOperation; 
	private double montant;
	private Compte compte;
	public Operation() {
		super();
	}
	public Operation(int num, Date dateOperation, double montant, Compte compte) {
		super();
		this.num = num;
		this.dateOperation = dateOperation;
		this.montant = montant;
		this.compte = compte;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Date getDateOperation() {
		return dateOperation;
	}
	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	@Override
	public String toString() {
		return "Operation [num=" + num + ", dateOperation=" + dateOperation + ", montant=" + montant + ", compte="
				+ compte + "]";
	} 
	
	

}
