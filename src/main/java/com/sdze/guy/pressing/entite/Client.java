package com.sdze.guy.pressing.entite;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client {
	@Id
	@GeneratedValue
	private Long id;
	private String nom;
	private String tel;
	private String email;
	private String adresse;
	@OneToMany(mappedBy="client",fetch=FetchType.LAZY)
	private List<Commande> commandes;
	
	@OneToMany(mappedBy="client",fetch=FetchType.LAZY)
	private List<Facture> factures;
	
	public List<Facture> getFactures() {
		return factures;
	}
	public void setFactures(List<Facture> factures) {
		this.factures = factures;
	}
	public Long getId_cli() {
		return id;
	}
	public void setId_cli(Long id_cli) {
		this.id = id_cli;
	}
	public String getNom_cli() {
		return nom;
	}
	public void setNom_cli(String nom_cli) {
		this.nom = nom_cli;
	}
	public String getTel_cli() {
		return tel;
	}
	public void setTel_cli(String tel_cli) {
		this.tel = tel_cli;
	}
	public String getEmail_cli() {
		return email;
	}
	public void setEmail_cli(String email_cli) {
		this.email = email_cli;
	}
	public String getAdresse_cli() {
		return adresse;
	}
	public void setAdresse_cli(String adresse_cli) {
		this.adresse = adresse_cli;
	}
	public List<Commande> getCommandes() {
		return commandes;
	}
	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}
	public Client(String nom_cli, String tel_cli, String email_cli, String adresse_cli) {
		super();
		this.nom = nom_cli;
		this.tel = tel_cli;
		this.email = email_cli;
		this.adresse = adresse_cli;
	}
	public Client() {
		super();
	}
	
	

}
