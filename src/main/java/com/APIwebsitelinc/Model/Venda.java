package com.APIwebsitelinc.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Entity public class Venda implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "increment", strategy = "increment") //Esta anotação faz o auto incremento para o Postgresql, o postgresql não vêm com auto incremento de id.
	@Column(name="idVenda")
	private long idVenda;
	@Column(name="idEstrangeiroCliente")
	private long idEstrangeiroCliente;
	@Column(name="nomeEstrangeiroCliente")
	private String nomeEstrangeiroCliente;
	@Column(name="idEstrangeiroProduto")
	private long idEstrangeiroProduto;
	@Column(name="nomeEstrangeiroProduto")
	private String nomeEstrangeiroProduto;
	@Column(name="observacaoVenda")
	private String observacaoVenda;
	@Column(name="quantItemVenda")
	private int quantItemVenda;
	@Column(name="customizacaoVenda")
	private String customizacaoVenda;
	
	
	public String getNomeEstrangeiroCliente() {
		return nomeEstrangeiroCliente;
	}
	public void setNomeEstrangeiroCliente(String nomeEstrangeiroCliente) {
		this.nomeEstrangeiroCliente = nomeEstrangeiroCliente;
	}
	public String getNomeEstrangeiroProduto() {
		return nomeEstrangeiroProduto;
	}
	public void setNomeEstrangeiroProduto(String nomeEstrangeiroProduto) {
		this.nomeEstrangeiroProduto = nomeEstrangeiroProduto;
	}
	public long getIdVenda() {
		return idVenda;
	}
	public void setIdVenda(long idVenda) {
		this.idVenda = idVenda;
	}
	public long getIdEstrangeiroCliente() {
		return idEstrangeiroCliente;
	}
	public void setIdEstrangeiroCliente(long idEstrangeiroCliente) {
		this.idEstrangeiroCliente = idEstrangeiroCliente;
	}
	public long getIdEstrangeiroProduto() {
		return idEstrangeiroProduto;
	}
	public void setIdEstrangeiroProduto(long idEstrangeiroProduto) {
		this.idEstrangeiroProduto = idEstrangeiroProduto;
	}
	public String getObservacaoVenda() {
		return observacaoVenda;
	}
	public void setObservacaoVenda(String observacaoVenda) {
		this.observacaoVenda = observacaoVenda;
	}
	public int getQuantItemVenda() {
		return quantItemVenda;
	}
	public void setQuantItemVenda(int quantItemVenda) {
		this.quantItemVenda = quantItemVenda;
	}
	public String getCustomizacaoVenda() {
		return customizacaoVenda;
	}
	public void setCustomizacaoVenda(String customizacaoVenda) {
		this.customizacaoVenda = customizacaoVenda;
	}
	
	
}
