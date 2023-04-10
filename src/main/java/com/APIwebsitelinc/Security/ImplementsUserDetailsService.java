//package com.APIwebsitelinc.Security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Repository;
//
//import com.APIwebsitelinc.Model.Administrador;
//import com.APIwebsitelinc.Repository.AdministradorRepository;
//
//@Repository
//public class ImplementsUserDetailsService implements UserDetailsService{
//	
//	@Autowired
//	private AdministradorRepository administradorRepository;
//
//	@Override
//	public UserDetails loadUserByUsername(String username_administrador) throws UsernameNotFoundException {
//		
//		Administrador adminstrador = administradorRepository.findByUsernameAdministrador(username_administrador);
//		
//		if(username_administrador == null) {
//			throw new UsernameNotFoundException("Username não foi encontrado");
//		}
//		
//		return adminstrador;
//	}
//
//}
