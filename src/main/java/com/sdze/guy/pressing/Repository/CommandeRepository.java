package com.sdze.guy.pressing.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.sdze.guy.pressing.entite.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
	@Query("select cmd from Commande cmd where cmd.id_cmd = ?1")
	public Commande commandeById(Long id);
	
	@Query("SELECT cmd FROM Commande cmd WHERE cmd.client.id = ?1")
	public List<Commande> commandeByClient(Long id_cli);
	
	@Transactional
	@Modifying
	@Query("update Commande cmd set cmd.qte = ?2, cmd.produit.id_prod = ?3 where cmd.id_cmd = ?1 ")
    void updateCommande(Long id_cmd,int qte,Long id_produit);
	
	

}
