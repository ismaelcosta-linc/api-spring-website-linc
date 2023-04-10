package com.APIwebsitelinc.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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

import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Entity public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@GenericGenerator(name = "increment", strategy = "increment") //Esta anotação faz o auto incremento para o Postgresql, o postgresql não vêm com auto incremento de id.
	@Column(name="idCliente")
	private long idCliente;
	@Column(name="usernameCliente")
	private String usernameCliente;
	@Column(name="passwordCliente")
	private String passwordCliente;
	@Column(name="nomeCliente")
	private String nomeCliente;
	@Column(name="celularCliente")
	private String celularCliente;
	@Column(name="enderecoCliente")
	private String enderecoCliente;
	
	
	public long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}
	public String getUsernameCliente() {
		return usernameCliente;
	}
	public void setUsernameCliente(String usernameCliente) {
		this.usernameCliente = usernameCliente;
	}
	public String getPasswordCliente() {
		return passwordCliente;
	}
	public void setPasswordCliente(String passwordCliente) {
		this.passwordCliente = passwordCliente;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getCelularCliente() {
		return celularCliente;
	}
	public void setCelularCliente(String celularCliente) {
		this.celularCliente = celularCliente;
	}
	public String getEnderecoCliente() {
		return enderecoCliente;
	}
	public void setEnderecoCliente(String enderecoCliente) {
		this.enderecoCliente = enderecoCliente;
	}
	
	
	
	
//	@OneToMany(mappedBy = "clienteDoServico")
//	@NotFound(action = NotFoundAction.IGNORE) //Resolve o erro de execeção javax.persistence.EntityNotFoundException: Unable to find.
//	private List<Servico> servicos;
//	@OneToMany(mappedBy = "clienteDaVenda")
//	private List<Venda> vendas;
//	private ArrayList<Produto> produtos; //Todo Cliente tem Serviço e Produto. Mas não necessariametne há um relacionamento entre cliente e produto, apenas registro.
	
	
	
	
//	public List<Servico> getServicos() {
//		return servicos;
//	}
//	public void setServicos(List<Servico> servicos) {
//		this.servicos = servicos;
//	}
//	public List<Venda> getVendas() {
//		return vendas;
//	}
//	public void setVendas(List<Venda> vendas) {
//		this.vendas = vendas;
//	}
//	public ArrayList<Produto> getProdutos() {
//		return produtos;
//	}
//	public void setProdutos(ArrayList<Produto> produtos) {
//		this.produtos = produtos;
//	}
	
	
	

}
