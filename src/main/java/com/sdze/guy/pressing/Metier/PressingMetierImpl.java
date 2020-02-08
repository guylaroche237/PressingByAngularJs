package com.sdze.guy.pressing.Metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdze.guy.pressing.Repository.ClientRepository;
import com.sdze.guy.pressing.Repository.CommandeRepository;
import com.sdze.guy.pressing.Repository.FactureRepository;
import com.sdze.guy.pressing.Repository.ProduitRepository;
import com.sdze.guy.pressing.entite.Client;
import com.sdze.guy.pressing.entite.Commande;
import com.sdze.guy.pressing.entite.Facture;
import com.sdze.guy.pressing.entite.Produit;

@Service
public class PressingMetierImpl implements PressingMetier{
	
	@Autowired
	public ClientRepository cli;
	@Autowired
	public CommandeRepository com;
	@Autowired
	public FactureRepository fac;
	@Autowired
	public ProduitRepository pro;

	@Override
	public List<Client> allClient() {
		// TODO Auto-generated method stub
		return cli.findAll();
	}

	@Override
	public Client getClientById(Long id) {
		// TODO Auto-generated method stub
		return cli.ClientById(id);
	}

	@Override
	public Client getClientByNamme(String nom) {
		// TODO Auto-generated method stub
		return cli.ClientByName(nom);
	}

	@Override
	public List<Commande> allCommande() {
		// TODO Auto-generated method stub
		return com.findAll();
	}

	@Override
	public Commande getCommandeById(Long id) {
		// TODO Auto-generated method stub
		return com.commandeById(id);
	}

	@Override
	public List<Produit> allProduit() {
		// TODO Auto-generated method stub
		return pro.findAll();
	}

	@Override
	public List<Facture> allFacture() {
		// TODO Auto-generated method stub
		return fac.findAll();
	}

	@Override
	public Facture getFactureById(Long id) {
		// TODO Auto-generated method stub
		return fac.factureById(id);
	}

	@Override
	public Facture getFactureByClient(Long id) {
		// TODO Auto-generated method stub
		return fac.factureByClient(id);
	}

	@Override
	public Facture getFactureByDate(Date date) {
		// TODO Auto-generated method stub
		return fac.factureByDate(date); 
	}

	@Override
	public Client getClientByAdresse(String adresse) {
		// TODO Auto-generated method stub
		return cli.ClientByAdresse(adresse);
	}

	@Override
	public List<Commande> getCommandeByClient(Long id) {
		// TODO Auto-generated method stub
		return com.commandeByClient(id);
	}

	@Override
	public List<Facture> getAllFactureByClient(long id) {
		// TODO Auto-generated method stub
		return fac.allFactureByClient(id);
	}

	@Override
	public void saveClient(Client client) {
		// TODO Auto-generated met
		cli.save(client);
		
	}

	@Override
	public void daleteClient(Long id) {
		// TODO Auto-generated method stub
		cli.deleteById(id);
		
	}

	@Override
	public Produit getProduitById(Long id) {
		// TODO Auto-generated method stub
		return pro.ProduitById(id);
	}

	@Override
	public void saveCommande(Commande cmd) {
		// TODO Auto-generated method stub
		com.save(cmd);
		
	}

	@Override
	public void deleteCommande(Long id) {
		// TODO Auto-generated method stub
		com.deleteById(id);
		
	}

	@Override
	public void updateCommande(Long id, int qte, Long id_produit) {
		// TODO Auto-generated method stub
		com.updateCommande(id, qte, id_produit);
		
	}

	@Override
	public void saveFacture(Facture facture) {
		// TODO Auto-generated method stub
		fac.save(facture);
		
	}

	@Override
	public void deleteFacture(Long id) {
		// TODO Auto-generated method stub
		fac.deleteById(id);
		
	}

	@Override
	public void updateProduit(Long id, String categorie, double prix) {
		// TODO Auto-generated method stub
		pro.updateProduit(id, categorie, prix);
		
	}

	@Override
	public Client getClientByNameAndTel(String nom, String tel) {
		// TODO Auto-generated method stub
		return cli.ClientByNameAndAdresse(nom, tel);
	}

	@Override
	public void SaveProduit(Produit p) {
		// TODO Auto-generated method stub
		pro.save(p);
		
	}

	@Override
	public Produit getProduitByCategorie(String categorie) {
		// TODO Auto-generated method stub
		return pro.ProduitByCategory(categorie);
	}

	

}
