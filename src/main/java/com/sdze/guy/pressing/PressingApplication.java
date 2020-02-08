package com.sdze.guy.pressing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sdze.guy.pressing.Metier.PressingMetier;
import com.sdze.guy.pressing.Repository.UserRepository;
import com.sdze.guy.pressing.config.EnvoyerMail;
import com.sdze.guy.pressing.entite.Client;
import com.sdze.guy.pressing.entite.Produit;
import com.sdze.guy.pressing.entite.User;

@SpringBootApplication
public class PressingApplication implements CommandLineRunner {
	
	@Autowired
	public PressingMetier pressing ;
	@Autowired
	public UserRepository user;
	
	/*
	 * @Autowired(required=true) EnvoyerMail env;
	 * 
	 */
	public static void main(String[] args) {
		SpringApplication.run(PressingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Client cl = new Client("guy","679206443","guylaroche@gmail.com","Ange Raphaelle");
		Client admin = new Client("admin","123","admin@yahoo.fr","bonapriso");
		User u = new User("admin","12343","admin@yahoo.fr","NOso");
		User u1 = new User("gervis","12903","admin@yahoo.fr","boriso");
		User u2 = new User("makolo","1673","admin@yahoo.fr","boNABERI");
		user.save(u);user.save(u1);user.save(u2);
		
		//EnvoyerMail env = new EnvoyerMail();
		//env.envoyer();
		
		Produit pro = new Produit("Chemise",350.0);
		Produit pro1 = new Produit("tricot",225.0);
		Produit pro2 = new Produit("Pantalon jean",700.10);
		Produit pro3 = new Produit("Sous Vetement",300.60);
		Produit pro8 = new Produit("Veste Homme",1000.75);
		Produit pro7 = new Produit("Jupe",500.0);
		Produit pro6 = new Produit("Robe",400);
		Produit pro5 = new Produit("Short",200.0);
		Produit pro4 = new Produit("Maillot",350.0);
		Produit pro9 = new Produit("Chaussure",300.0);
		pressing.saveClient(cl);
		pressing.saveClient(admin);
		pressing.SaveProduit(pro);pressing.SaveProduit(pro1);pressing.SaveProduit(pro2);pressing.SaveProduit(pro3);pressing.SaveProduit(pro4);
		pressing.SaveProduit(pro5);pressing.SaveProduit(pro6);pressing.SaveProduit(pro7);pressing.SaveProduit(pro8);pressing.SaveProduit(pro9);
		
	}

}
