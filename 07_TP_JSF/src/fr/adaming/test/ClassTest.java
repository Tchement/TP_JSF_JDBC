package fr.adaming.test;

import fr.adaming.model.Utilisateur;
import fr.adaming.service.AgentServiceImpl;
import fr.adaming.service.IAgentService;
import fr.adaming.service.IUserService;
import fr.adaming.service.UserServiceImpl;

public class ClassTest {

	public static void main(String[] args) {
		
		IAgentService asi = new AgentServiceImpl();
//		System.out.println(asi.isExistService("toto@tata", "tata"));
//		
		IUserService usi = new UserServiceImpl();
//		System.out.println(usi.getAllUsersService());
//		System.out.println(usi.getByIdService(2));
//		usi.deleteService(4);
//		usi.addService(new Utilisateur("Chement","Thibault","toto@gmail.com","motdePasseLolz"));
		usi.updateService(new Utilisateur(20,"ChementUPDATED","ThibaultUPDATED","toto@gmail.comUPDATED","motdePasseLolzUPDATED"));
		
		

	}

}
