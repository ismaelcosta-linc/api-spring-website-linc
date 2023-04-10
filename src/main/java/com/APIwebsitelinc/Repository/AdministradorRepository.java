package com.APIwebsitelinc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.APIwebsitelinc.Model.Administrador;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, String>{
	
	Administrador findByIdAdministrador(long idAdministrador);
	
	Administrador findByUsernameAdministrador(String usernameAdministrador);
	
}
