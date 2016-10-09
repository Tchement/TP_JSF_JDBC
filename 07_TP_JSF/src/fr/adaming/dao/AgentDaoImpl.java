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
			 * Cr�ation de la connexion
			 */
			cx=DriverManager.getConnection(urlDb, userDb, passwordDb);
			/**
			 * Cr�er la requ�te
			 */
			String sqlReq="SELECT count(id_agent) from agent where mail=? and password=?;";
			/**
			 * Cr�er un ps
			 */
			ps=cx.prepareStatement(sqlReq);
			/**
			 * Passer les valeurs des param�tres de la requ�te
			 */
			ps.setString(1, login);
			ps.setString(2, mdp);
			/**
			 * Envoyer la requ�te et r�cup�rer le r�sultat
			 */
			ResultSet rs = ps.executeQuery();
			/**
			 * Utiliser le r�sultat
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
