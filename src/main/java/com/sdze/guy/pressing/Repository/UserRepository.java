package com.sdze.guy.pressing.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sdze.guy.pressing.entite.User;

public interface UserRepository extends JpaRepository<User,Integer> {
	@Query("SELECT user FROM User user WHERE user.id = ?1")
	public User UserById(Long id);

}
