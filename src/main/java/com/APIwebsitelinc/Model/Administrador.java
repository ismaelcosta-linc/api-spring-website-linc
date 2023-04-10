package com.APIwebsitelinc.Model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Entity public class Administrador implements Serializable{ //, UserDetails{
	
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "increment", strategy = "increment") //Esta anotação faz o auto incremento para o Postgresql, o postgresql não vêm com auto incremento de id.
	@Column(name="idAdministrador")
	private long idAdministrador;
	@Column(name="usernameAdministrador")
	private String usernameAdministrador;
	@Column(name="passwordAdministrador")
	private String passwordAdministrador;
	@Column(name="nomeAdministrador")
	private String nomeAdministrador;
	@Column(name="celularAdministrador")
	private String celularAdministrador;
	@Column(name="enderecoAdministrador")
	private String enderecoAdministrador;
	
	
	
	
	
//	@OneToMany(mappedBy = "administradorDoServico")
//	@NotFound(action = NotFoundAction.IGNORE)  //Resolve o erro de execeção javax.persistence.EntityNotFoundException: Unable to find.
//	private List<Servico> servicos;
	
	
//	public List<Servico> getServicos() {
//		return servicos;
//	}
//	public void setServicos(List<Servico> servicos) {
//		this.servicos = servicos;
//	}
	
	
	
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	public long getIdAdministrador() {
		return idAdministrador;
	}
	public void setIdAdministrador(long idAdministrador) {
		this.idAdministrador = idAdministrador;
	}
	public String getUsernameAdministrador() {
		return usernameAdministrador;
	}
	public void setUsernameAdministrador(String usernameAdministrador) {
		this.usernameAdministrador = usernameAdministrador;
	}
	public String getPasswordAdministrador() {
		return passwordAdministrador;
	}
	public void setPasswordAdministrador(String passwordAdministrador) {
		this.passwordAdministrador = passwordAdministrador;
	}
	public String getNomeAdministrador() {
		return nomeAdministrador;
	}
	public void setNomeAdministrador(String nomeAdministrador) {
		this.nomeAdministrador = nomeAdministrador;
	}
	public String getCelularAdministrador() {
		return celularAdministrador;
	}
	public void setCelularAdministrador(String celularAdministrador) {
		this.celularAdministrador = celularAdministrador;
	}
	public String getEnderecoAdministrador() {
		return enderecoAdministrador;
	}
	public void setEnderecoAdministrador(String enderecoAdministrador) {
		this.enderecoAdministrador = enderecoAdministrador;
	}
	
//	@Override
//	public String getPassword() {
//		// TODO Auto-generated method stub
//		return this.passwordAdministrador;
//	}
//	@Override
//	public String getUsername() {
//		// TODO Auto-generated method stub
//		return this.usernameAdministrador;
//	}
//	@Override
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//	@Override
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return true;
//	}
	
}
