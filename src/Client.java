
public class Client {
  private int code; 
  private String nom;
  private String prenom; 
  private String email; 
  private Compte compte;
public Client() {
	super();
}
public Client(int code, String nom, String prenom, String email, Compte compte) {
	super();
	this.code = code;
	this.nom = nom;
	this.prenom = prenom;
	this.email = email;
	this.compte = compte;
}
public int getCode() {
	return code;
}
public void setCode(int code) {
	this.code = code;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Compte getCompte() {
	return compte;
}
public void setCompte(Compte compte) {
	this.compte = compte;
}
@Override
public String toString() {
	return "Client [code=" + code + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", compte=" + compte
			+ "]";
} 
  
}
