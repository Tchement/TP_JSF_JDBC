package fr.adaming.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AgentDaoImpl implements IAgentDao {
	
	public static final String urlDb="jdbc:mysql://localhost:3306/dbjspservlet";
	public static final String userDb="root";
	public static final String passwordDb="root";
	
	private Connection cx=null;
	private PreparedStatement ps=null;

	@Override
	public int isExistDao(String login, String mdp) {
		
		/**
		 * Chargement du driver
		 */
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			/**
			 * Création de la connexion
			 */
			cx=DriverManager.getConnection(urlDb, userDb, passwordDb);
			/**
			 * Créer la requête
			 */
			String sqlReq="SELECT count(id_agent) from agent where mail=? and password=?;";
			/**
			 * Créer un ps
			 */
			ps=cx.prepareStatement(sqlReq);
			/**
			 * Passer les valeurs des paramètres de la requête
			 */
			ps.setString(1, login);
			ps.setString(2, mdp);
			/**
			 * Envoyer la requête et récupérer le résultat
			 */
			ResultSet rs = ps.executeQuery();
			/**
			 * Utiliser le résultat
			 */
			rs.next();
			return rs.getInt(1);
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}finally{
			if(cx!=null){
				try {
					cx.close();
					if(ps!=null){
						ps.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}		
		
		return 0;
	}

}
