package com.sdze.guy.pressing.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.sdze.guy.pressing.entite.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
	@Query("select pro from Produit pro where pro.id_prod = ?1")
	public Produit ProduitById(Long id);
	
	@Query("select pro from Produit pro where pro.categorie = ?1")
	public Produit ProduitByCategory(String categorie);
	
	@Transactional
	@Modifying
	@Query("update Produit pro set pro.categorie = ?2, pro.prix = ?3 where pro.id_prod = ?1 ")
	public void updateProduit(Long id_prod,String categorie,double prix);

}
