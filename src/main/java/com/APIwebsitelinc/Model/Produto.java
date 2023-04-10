package com.APIwebsitelinc.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter public class Produto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "increment", strategy = "increment") //Esta anotação faz o auto incremento para o Postgresql, o postgresql não vêm com auto incremento de id.
	@Column(name="idProduto")
	private long idProduto;
	@Column(name="nomeProduto")
	private String nomeProduto;
	@Column(name="modeloMarcaProduto")
	private String modeloMarcaProduto;
	@Column(name="precoRevendaUnidade")
	private double precoRevendaUnidade;
	@Column(name="descricaoProduto")
	private String descricaoProduto;
	@Column(name="pathImagemProduto")
	private String pathImagemProduto;

	@Lob //Lob faz referência a Blob
	@Type(type = "org.hibernate.type.ImageType")
    @Column(columnDefinition = "BYTEA")
    private byte[] imagem;
	

	public byte[] getImagem() {
		return imagem;
	}
	public void setImagem(byte[] imagem) {
			this.imagem = imagem;
	}
	
	public long getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(long idProduto) {
		this.idProduto = idProduto;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getModeloMarcaProduto() {
		return modeloMarcaProduto;
	}
	public void setModeloMarcaProduto(String modeloMarcaProduto) {
		this.modeloMarcaProduto = modeloMarcaProduto;
	}
	public double getPrecoRevendaUnidade() {
		return precoRevendaUnidade;
	}
	public void setPrecoRevendaUnidade(double precoRevendaUnidade) {
		this.precoRevendaUnidade = precoRevendaUnidade;
	}
	public String getDescricaoProduto() {
		return descricaoProduto;
	}
	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}
	public String getPathImagemProduto() {
		return pathImagemProduto;
	}
	public void setPathImagemProduto(String pathImagemProduto) {
		this.pathImagemProduto = pathImagemProduto;
	}
	
	
	
	
//	@Lob //Lob faz referência a Blob
//	@Type(type = "org.hibernate.type.ImageType")
//	@Column(columnDefinition = "BYTEA")
//	private byte[] imagem;
//	
//	@JoinColumn(name = "idVenda")
//	@OneToOne
//	private Venda venda;

	

//	public byte[] getImagem() {
//		return imagem;
//	}
//
//	public void setImagem(byte[] imagem) {
//		this.imagem = imagem;
//	}
//
//	public Venda getVenda() {
//		return venda;
//	}
//
//	public void setVenda(Venda venda) {
//		this.venda = venda;
//	}

	
	


}
