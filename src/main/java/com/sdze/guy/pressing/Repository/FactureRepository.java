package com.sdze.guy.pressing.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sdze.guy.pressing.entite.Facture;

public interface FactureRepository extends JpaRepository<Facture,Long>{
	@Query("select fac from Facture fac where fac.id_fac = ?1")
	public Facture factureById(Long id);
	
	@Query("select fac from Facture fac where fac.date = ?1")
	public Facture factureByDate(Date date);
	
	@Query("SELECT facture From Facture facture WHERE facture.client.id = ?1")
	public List<Facture> allFactureByClient(long idcli);
	
	@Query("SELECT facture From Facture facture WHERE facture.client.id = ?1")
	public Facture factureByClient(long idcli);
	
	

}
