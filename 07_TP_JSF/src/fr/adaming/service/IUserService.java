package fr.adaming.service;

import java.util.ArrayList;

import fr.adaming.model.Utilisateur;

public interface IUserService {
	
	public ArrayList<Utilisateur> getAllUsersService();
	public Utilisateur getByIdService(int id);
	public void deleteService(int id);
	public void addService(Utilisateur u);
	public void updateService(Utilisateur utilisateur);

}
