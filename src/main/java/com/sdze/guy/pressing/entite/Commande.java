package com.sdze.guy.pressing.entite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Commande {
	@Id
	@GeneratedValue
	private Long id_cmd;
	private int qte;
	@ManyToOne
	@JoinColumn(name="id_client")
	@JsonIgnore
	private Client client;
	@ManyToOne
	@JoinColumn(name="id_produit")
	@JsonIgnore
	private Produit produit;
	@ManyToOne
	@JoinColumn(name="id_facture")
	private Facture facture;
	private double total;
	public Long getId_cmd() {
		return id_cmd;
	}
	public void setId_cmd(Long id_cmd) {
		this.id_cmd = id_cmd;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public Facture getFacture() {
		return facture;
	}
	public void setFacture(Facture facture) {
		this.facture = facture;
	}
	public double getTotal() {
		return this.qte*this.produit.getPrix();
	}
	public void setTotal() {
		this.total = this.qte*this.produit.getPrix();
	}
	public Commande(int qte, Client client, Produit produit) {
		super();
		this.qte = qte;
		this.client = client;
		this.produit = produit;
	}
	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
