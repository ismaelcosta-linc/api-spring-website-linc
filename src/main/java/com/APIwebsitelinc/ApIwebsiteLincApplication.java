package com.APIwebsitelinc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.APIwebsitelinc.Model.Administrador;
import com.APIwebsitelinc.Repository.AdministradorRepository;
import com.APIwebsitelinc.Service.AdministradorService;

@SpringBootApplication
public class ApIwebsiteLincApplication {

//	public static AdministradorService administradorService;
//	@Autowired
//	private static AdministradorService administradorService;
	
	public static void main(String[] args) {
		SpringApplication.run(ApIwebsiteLincApplication.class, args);

//		Administrador adm = new Administrador();
//			adm.setNomeAdministrador("Ismael");
//			adm.setCelularAdministrador("981770681");
//			adm.setEnderecoAdministrador("Martinho Lutero - 71. PB");
//			adm.setUsernameAdministrador("isma");
//			adm.setPasswordAdministrador("cnleamsi");
//		administradorService.save(adm);

		
//		Administrador administrador = new Administrador();
//		administrador.setUsernameAdministrador("isma");
//		System.out.println(new BCryptPasswordEncoder().encode("123"));
		
//		administradorService.save(administrador);
	}

}
