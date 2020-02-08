package com.sdze.guy.pressing.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sdze.guy.pressing.Metier.PressingMetier;
import com.sdze.guy.pressing.Repository.UserRepository;
import com.sdze.guy.pressing.entite.Client;
import com.sdze.guy.pressing.entite.Commande;
import com.sdze.guy.pressing.entite.Facture;
import com.sdze.guy.pressing.entite.Produit;
import com.sdze.guy.pressing.entite.User;

@RestController
@RequestMapping("/pressing")

public class PressingController {
	
	@Autowired
	//@InjectService
	public PressingMetier pressing;
	
	@Autowired
	public UserRepository user;
	
	@GetMapping("/allusers")
	private List<User> getusers(){
		return user.findAll();
	}
	
	@GetMapping("/user/id/{id}")
	private User getUserId(@PathVariable Long id) {
	  return user.UserById(id);
	}
	
	@GetMapping("/allClients")
	private List<Client> getClients(){
		return pressing.allClient();
	}
	
	@GetMapping("/client/id/{id}")
	private Client getClient(@PathVariable Long id) {
		return pressing.getClientById(id); 
	}
	
	@GetMapping("/client/name/{nom}")
	private Client getClient(@PathVariable String nom) {
		return pressing.getClientByNamme(nom);
	}
	
	@GetMapping("/client/login")
	private Client getClientByNT(@RequestParam String nom, @RequestParam String tel) {
		return pressing.getClientByNameAndTel(nom, tel);
		
	}
	
	@GetMapping("/client/return/{nom}/{tel}")
	public Client returnClientByNT(@PathVariable String nom, @PathVariable String tel) {
		return pressing.getClientByNameAndTel(nom, tel);
		
	}
	
	
	
	@PostMapping("/client/save")
	private void saveClient(@RequestParam String nom,@RequestParam String tel,@RequestParam String email,@RequestParam String adresse) {
		Client c = new Client(nom,tel,email,adresse);
		
		 pressing.saveClient(c);
		
		
	}
	
	
	@DeleteMapping("/client/delete/{id}")
	private void deleteClient(@PathVariable Long id) {
		pressing.daleteClient(id);
	}
	
	
	@GetMapping("/allCommande")
	private List<Commande> getCommande(){
		return pressing.allCommande();
	}
	
	@GetMapping("/commande/id/{id}")
	private Commande getCommandebyId(@PathVariable Long id) {
		return pressing.getCommandeById(id);
	}
	
	@GetMapping("/commande/name/{idcl}")
	private List<Commande> getCommandebyClient(@PathVariable Long idcl) {
		return pressing.getCommandeByClient(idcl);
	}
	
	@PostMapping("/commande/save")
	private void saveCommande(@RequestParam int qte,@RequestParam Long  idclient,@RequestParam Long idproduit) {
		Client cl = pressing.getClientById(idclient);
		Produit pro = pressing.getProduitById(idproduit);
		Commande cmd = new Commande(qte,cl,pro);
		
		pressing.saveCommande(cmd);
		
	}
	
	@DeleteMapping("/commande/delete/{id}")
	private void deleteCommandeById(@PathVariable Long id) {
		pressing.deleteCommande(id);
	}
	
	@GetMapping("/commande/update")
	private void updCommande(@RequestParam Long id,@RequestParam int qte,@RequestParam Long id_produit) {
		pressing.updateCommande(id,qte,id_produit);
	}
	
	@GetMapping("/facture/allFacture")
	public List<Facture> allFacture(){
		return pressing.allFacture();
	}
	
	@GetMapping("/facture/id/{id}")
	public Facture getFacture(@PathVariable Long id){
		return pressing.getFactureById(id);
	}
	
	
	@GetMapping("/facture/client/{id}")
	public Facture allFactureClient(@PathVariable Long id){
		return pressing.getFactureByClient(id);
	}
	
	@GetMapping("/facture/client/{date}")
	public Facture allFactureClient(@PathVariable Date date){
		return pressing.getFactureByDate(date);
	}
	
	@GetMapping("/facture/all/client/{id}")
	public List<Facture> allFacture(@PathVariable Long id){
		return pressing.getAllFactureByClient(id);
	}
	
	@PostMapping("/facture/save/{id_cli}")
	public void saveFacture(@PathVariable Long id_cli) {
		Client cli = pressing.getClientById(id_cli);
		System.out.println("client"+cli);
		Facture fac = new Facture(cli);
		fac.setCommandes(cli.getCommandes());
		double sum = 0;
		for(Commande c: cli.getCommandes()) {
			sum = sum + c.getTotal();
			
		}
		fac.setTotal(sum);
		
	}
	
	@DeleteMapping("/facture/delete/{id}")
	public void deleteFactur(@PathVariable long id) {
		pressing.deleteFacture(id);
		
	}
	
	@GetMapping("/allProduits")
	private List<Produit> getProduit(){
		return pressing.allProduit();
	}
	
	@GetMapping("/produit/categorie")
	public Produit getProduitByCat(@RequestParam String categorie) {
		return pressing.getProduitByCategorie(categorie);
	}
	
	@GetMapping("/produit/update")
	public void updateProduit(@RequestParam Long id,@RequestParam String categorie,@RequestParam double prix) {
		pressing.updateProduit(id, categorie, prix);
		
	}
	
	
			

}
