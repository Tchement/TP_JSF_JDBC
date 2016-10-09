package fr.adaming.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.adaming.model.Utilisateur;

public class UserDaoImpl implements IUserDao {

	public static final String urlDb = "jdbc:mysql://localhost:3306/dbjspservlet";
	public static final String userDb = "root";
	public static final String passwordDb = "root";

	private Connection cx = null;
	private PreparedStatement ps = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.adaming.dao.IUserDao#getArray()
	 */
	@Override
	public ArrayList<Utilisateur> getAllUsersDao() {
		ArrayList<Utilisateur> listUser = new ArrayList<Utilisateur>();

		/**
		 * Chargement du driver
		 */

		try {
			Class.forName("com.mysql.jdbc.Driver");
			/**
			 * Cr�ation de la connexion
			 */
			cx = DriverManager.getConnection(urlDb, userDb, passwordDb);
			/**
			 * Cr�er la requ�te
			 */
			String sqlReq = "SELECT * from utilisateur";
			/**
			 * Cr�er un ps
			 */
			ps = cx.prepareStatement(sqlReq);
			/**
			 * Envoyer la requ�te et r�cup�rer le r�sultat
			 */
			ResultSet rs = ps.executeQuery();
			/**
			 * Utiliser le r�sultat
			 */

			while (rs.next()) {
				listUser.add(new Utilisateur(rs.getInt(1), rs.getString(2), rs
						.getString(3), rs.getString(4), rs.getString(5)));
			}
			return listUser;

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		} finally {
			if (cx != null) {
				try {
					cx.close();
					if (ps != null) {
						ps.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.adaming.dao.IUserDao#getById()
	 */
	@Override
	public Utilisateur getByIdDao(int id_user) {
		/**
		 * Chargement du driver
		 */

		try {
			Class.forName("com.mysql.jdbc.Driver");
			/**
			 * Cr�ation de la connexion
			 */
			cx = DriverManager.getConnection(urlDb, userDb, passwordDb);
			/**
			 * Cr�er la requ�te
			 */
			String sqlReq = "SELECT * from utilisateur where id_utilisateur=?";
			/**
			 * Cr�er un ps
			 */
			ps = cx.prepareStatement(sqlReq);
			/**
			 * Passer les valeurs des param�tres de la requ�te
			 */
			ps.setInt(1, id_user);
			/**
			 * Envoyer la requ�te et r�cup�rer le r�sultat
			 */
			ResultSet rs = ps.executeQuery();
			/**
			 * Utiliser le r�sultat
			 */

			if (rs.next()) {
				return new Utilisateur(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getString(5));
			}

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		} finally {
			if (cx != null) {
				try {
					cx.close();
					if (ps != null) {
						ps.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.adaming.dao.IUserDao#delete()
	 */
	@Override
	public void deleteDao(int id_user) {

		/**
		 * Chargement du driver
		 */
		try {
			Class.forName("com.mysql.jdbc.Driver");
			/**
			 * Cr�ation de la connexion
			 */
			cx = DriverManager.getConnection(urlDb, userDb, passwordDb);
			/**
			 * Cr�er la requ�te
			 */
			String sqlReq = "DELETE FROM utilisateur where id_utilisateur=?";
			/**
			 * Cr�er un ps
			 */
			ps = cx.prepareStatement(sqlReq);
			/**
			 * Passer les valeurs des param�tres de la requ�te
			 */
			ps.setInt(1, id_user);
			/**
			 * Envoyer la requ�te
			 */
			ps.executeUpdate();
			/**
			 * Utiliser le r�sultat
			 */
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		} finally {
			if (cx != null) {
				try {
					cx.close();
					if (ps != null) {
						ps.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.adaming.dao.IUserDao#add()
	 */
	@Override
	public void addDao(Utilisateur utilisateur) {

		/**
		 * Chargement du driver
		 */
		try {
			Class.forName("com.mysql.jdbc.Driver");
			/**
			 * Cr�ation de la connexion
			 */
			cx = DriverManager.getConnection(urlDb, userDb, passwordDb);
			/**
			 * Cr�er la requ�te
			 */
			String sqlReq = "INSERT INTO utilisateur (nom,prenom,mail,password) values (?,?,?,?)";
			/**
			 * Cr�er un ps
			 */
			ps = cx.prepareStatement(sqlReq);
			/**
			 * Passer les valeurs des param�tres de la requ�te
			 */
			ps.setString(1, utilisateur.getNom());
			ps.setString(2, utilisateur.getPrenom());
			ps.setString(3, utilisateur.getMail());
			ps.setString(4, utilisateur.getMdp());
			/**
			 * Envoyer la requ�te
			 */
			ps.executeUpdate();
			/**
			 * Utiliser le r�sultat
			 */
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		} finally {
			if (cx != null) {
				try {
					cx.close();
					if (ps != null) {
						ps.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.adaming.dao.IUserDao#update()
	 */
	@Override
	public void updateDao(Utilisateur utilisateur) {
		/**
		 * Chargement du driver
		 */
		try {
			Class.forName("com.mysql.jdbc.Driver");
			/**
			 * Cr�ation de la connexion
			 */
			cx = DriverManager.getConnection(urlDb, userDb, passwordDb);
			/**
			 * Cr�er la requ�te
			 */
			String sqlReq = "UPDATE utilisateur set nom=?, prenom=?, mail=?, password=? WHERE id_utilisateur=?";
			/**
			 * Cr�er un ps
			 */
			ps = cx.prepareStatement(sqlReq);
			/**
			 * Passer les valeurs des param�tres de la requ�te
			 */
			ps.setString(1, utilisateur.getNom());
			ps.setString(2, utilisateur.getPrenom());
			ps.setString(3, utilisateur.getMail());
			ps.setString(4, utilisateur.getMdp());
			ps.setInt(5, utilisateur.getId_utilisateur());
			/**
			 * Envoyer la requ�te
			 */
			ps.executeUpdate();
			/**
			 * Utiliser le r�sultat
			 */
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		} finally {
			if (cx != null) {
				try {
					cx.close();
					if (ps != null) {
						ps.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
