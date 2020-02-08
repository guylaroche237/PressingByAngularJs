package com.sdze.guy.pressing.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sdze.guy.pressing.entite.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
	
	@Query("SELECT client FROM Client client WHERE client.id = ?1")
	public Client ClientById(Long id);
	@Query("SELECT client FROM Client client WHERE client.nom = ?1")
	public Client ClientByName(String nom);
	@Query("SELECT client FROM Client client WHERE client.adresse = ?1")
	public Client ClientByAdresse(String adresse);
	
	@Query("SELECT client FROM Client client WHERE client.nom = ?1 and client.tel = ?2 ")
	public Client ClientByNameAndAdresse(String nom,String tel);
	

}
