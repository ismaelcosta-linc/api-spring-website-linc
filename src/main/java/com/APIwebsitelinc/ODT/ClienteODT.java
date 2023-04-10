package com.APIwebsitelinc.ODT;

import java.util.Date;

public class ClienteODT {
	
	private String login;
	private String senha;
	private String nomecliente;
	private String celularCliente;
	private String emailCliente;
	private String enderecoCliente;
	private Date   dataNascCliente;
	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNomecliente() {
		return nomecliente;
	}
	public void setNomecliente(String nomecliente) {
		this.nomecliente = nomecliente;
	}
	public String getCelularCliente() {
		return celularCliente;
	}
	public void setCelularCliente(String celularCliente) {
		this.celularCliente = celularCliente;
	}
	public String getEmailCliente() {
		return emailCliente;
	}
	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}
	public String getEnderecoCliente() {
		return enderecoCliente;
	}
	public void setEnderecoCliente(String enderecoCliente) {
		this.enderecoCliente = enderecoCliente;
	}
	public Date getDataNascCliente() {
		return dataNascCliente;
	}
	public void setDataNascCliente(Date dataNascCliente) {
		this.dataNascCliente = dataNascCliente;
	}
	
}
