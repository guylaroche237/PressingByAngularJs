package com.sdze.guy.pressing.entite;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Facture {
	@Id
	@GeneratedValue
	private Long id_fac;
	private Date date;
	@OneToMany(mappedBy="facture")
	private List<Commande> commandes;
	private double total;
	@ManyToOne
	@JoinColumn(name="id_client")
	private Client client;
	public Long getId_fac() {
		return id_fac;
	}
	public void setId_fac(Long id_fac) {
		this.id_fac = id_fac;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<Commande> getCommandes() {
		return commandes;
	}
	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Facture(Client client) {
		super();
		this.date = new Date();
		this.client = client;
	}
	public Facture() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
