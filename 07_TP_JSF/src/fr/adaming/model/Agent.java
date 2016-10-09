package fr.adaming.model;

public class Agent {
	
	/**
	 * Attributs
	 */
	private int id_agent;
	private String login;
	private String mdp;
	
	
	/**
	 * Constructeur vide
	 */
	public Agent() {
		super();
	}
	
	
	/**
	 * Constructeur avec paramètres
	 * @param mail
	 * @param mdp
	 */
	public Agent(String login, String mdp) {
		super();
		this.login = login;
		this.mdp = mdp;
	}
	
	
	/**
	 * Constructeur avec param et id
	 * @param id_agent
	 * @param mail
	 * @param mdp
	 */
	public Agent(int id_agent, String login, String mdp) {
		super();
		this.id_agent = id_agent;
		this.login = login;
		this.mdp = mdp;
	}
	
	
	/**
	 * Getters et Setters
	 */
	/**
	 * @return the id_agent
	 */
	public int getId_agent() {
		return id_agent;
	}
	/**
	 * @param id_agent the id_agent to set
	 */
	public void setId_agent(int id_agent) {
		this.id_agent = id_agent;
	}
	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * @param mail the mail to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * @return the mdp
	 */
	public String getMdp() {
		return mdp;
	}
	/**
	 * @param mdp the mdp to set
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
		return "Agent [id_agent=" + id_agent + ", login=" + login + ", mdp="
				+ mdp + "]";
	}
	
		

}
