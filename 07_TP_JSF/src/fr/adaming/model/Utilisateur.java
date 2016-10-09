/**
 * 
 */
package fr.adaming.model;

/**
 * @author inti0210
 *
 */
public class Utilisateur {
	
	/**
	 * Attributs
	 */
	
	private int id_utilisateur;
	private String nom;
	private String prenom;
	private String mail;
	private String mdp;
	
	
	/**
	 * Constructeur vide
	 */
	public Utilisateur() {
		super();
	}
	
	
	/**
	 * Constructeur avec paramètres
	 * @param nom
	 * @param prenom
	 * @param mail
	 * @param mdp
	 */
	public Utilisateur(String nom, String prenom, String mail, String mdp) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.mdp = mdp;
	}
	
	
	/**
	 * Constructeur avec param et id
	 * @param id_utilisateur
	 * @param nom
	 * @param prenom
	 * @param mail
	 * @param mdp
	 */
	public Utilisateur(int id_utilisateur, String nom, String prenom,
			String mail, String mdp) {
		super();
		this.id_utilisateur = id_utilisateur;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.mdp = mdp;
	}
	
	
	/**
	 * Getters et Setters
	 */
	/**
	 * @return the id_utilisateur
	 */
	public int getId_utilisateur() {
		return id_utilisateur;
	}
	/**
	 * @param id_utilisateur the id_utilisateur to set
	 */
	public void setId_utilisateur(int id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}
	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	/**
	 * @return the mdp
	 */
	public String getMdp() {
		return mdp;
	}
	/**
	 * @param password the mdp to set
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	
	/**
	 * Redéfinition de toString
	 */
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Utilisateur [id_utilisateur=" + id_utilisateur + ", nom=" + nom
				+ ", prenom=" + prenom + ", mail=" + mail + ", mdp="
				+ mdp + "]" + "\n";
	}
	

}
