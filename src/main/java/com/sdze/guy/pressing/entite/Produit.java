package com.sdze.guy.pressing.entite;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Produit {
	@Id
	@GeneratedValue
	private Long id_prod;
	private String categorie;
	private double prix;
	@OneToMany(mappedBy="produit")
	private List<Commande> commandes;
	public Long getId_prod() {
		return id_prod;
	}
	public void setId_prod(Long id_prod) {
		this.id_prod = id_prod;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public List<Commande> getCommandes() {
		return commandes;
	}
	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Produit(String categorie, double prix) {
		super();
		this.categorie = categorie;
		this.prix = prix;
	}
	
	

}
