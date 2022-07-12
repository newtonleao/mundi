package br.com.alura.mvc.mundi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.mvc.mundi.model.User;


public interface UserRepository extends JpaRepository<User, String>{
	
	User findByUsername(String username);
	
}
