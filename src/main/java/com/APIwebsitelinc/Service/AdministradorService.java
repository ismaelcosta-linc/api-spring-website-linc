package com.APIwebsitelinc.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.APIwebsitelinc.Model.Administrador;
import com.APIwebsitelinc.Repository.AdministradorRepository;

@Service(value = "administradorService")
public class AdministradorService {
	
	@Autowired
	private AdministradorRepository administradorrepository;
	
	
	public Administrador save(Administrador administrador) {
		return administradorrepository.save(administrador);
	}
	public Administrador findByIdAdministrador(long idAdministrador) {
		return administradorrepository.findByIdAdministrador(idAdministrador);
	}
	public Administrador findByUsernameAdministrador(String usernameAdministrador) {
		return administradorrepository.findByUsernameAdministrador(usernameAdministrador);
	}
	public List<Administrador> findAllAdministrador(){
		return administradorrepository.findAll();
	}
	public void deleteByIdAdministrador(long idAdministrador) {
		Administrador administrador = administradorrepository.findByIdAdministrador(idAdministrador);
		administradorrepository.delete(administrador);
	}
	public void removeByAdministrador(Administrador administrador) {
		administradorrepository.delete(administrador);
	}
}
