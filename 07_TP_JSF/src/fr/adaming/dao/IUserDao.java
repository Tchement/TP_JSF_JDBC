package fr.adaming.dao;

import java.util.ArrayList;

import fr.adaming.model.Utilisateur;

public interface IUserDao {
	
	public ArrayList<Utilisateur> getAllUsersDao();
	public Utilisateur getByIdDao(int id);
	public void deleteDao(int id);
	public void addDao(Utilisateur u);
	public void updateDao(Utilisateur u);

}
