package com.sdze.guy.pressing.Metier;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sdze.guy.pressing.entite.Client;
import com.sdze.guy.pressing.entite.Commande;
import com.sdze.guy.pressing.entite.Facture;
import com.sdze.guy.pressing.entite.Produit;

public interface PressingMetier {
	
	public List<Client> allClient();
	public Client getClientById(Long id);
	public Client getClientByNamme(String nom);
	public Client getClientByAdresse(String adresse);
	public void saveClient(Client client);
	public void daleteClient(Long id);
	public Client getClientByNameAndTel(String nom,String tel);
	
	public List<Commande> allCommande();
	public Commande getCommandeById(Long id);
	public List<Commande> getCommandeByClient(Long id);
	public void saveCommande(Commande cmd);
	public void deleteCommande(Long id);
	public void updateCommande(Long id,int qte, Long id_produit);
	
	
	public List<Produit> allProduit();
	public Produit getProduitById(Long id);
	public Produit getProduitByCategorie(String categorie);
	public void updateProduit(Long id, String categorie,double prix);
	public void SaveProduit(Produit p);
	
	
	public List<Facture> allFacture();
	public Facture getFactureById(Long id);
	public Facture getFactureByClient(Long id);
	public Facture getFactureByDate(Date date);
	public List<Facture> getAllFactureByClient(long id);
	public void saveFacture(Facture facture);
	public void deleteFacture(Long id);
	

}
