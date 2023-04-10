package com.APIwebsitelinc.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter public class Servico implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "increment", strategy = "increment") //Esta anotação faz o auto incremento para o Postgresql, o postgresql não vêm com auto incremento de id.
	@Column(name="idServico")
	private long idServico;
	@Column(name="idEstrangeiroCliente")
	private long idEstrangeiroCliente;
	@Column(name="nomeEstrangeiroCliente")
	private String nomeEstrangeiroCliente;
	@Column(name="idEstrangeiroAdministrador")
	private long idEstrangeiroAdministrador;
	@Column(name="nomeEstrangeiroAdministrador")
	private String nomeEstrangeiroAdministrador;
	@Column(name="tituloServico")
	private String tituloServico;
	@Column(name="dataAberturaServico")
	private String dataAberturaServico;
	@Column(name="descricaoServico")
	private String descricaoServico;
	@Column(name="statusServico")
	private String statusServico;
	@Column(name="precoServico")
	private double precoServico;
	@Column(name="disposicaoRemotoServico")
	private String disposicaoRemotoServico;
	@Column(name="tipoDispositivoServico")
	private String tipoDispositivoServico;
	@Column(name="disposicaoLayoutGenerico")
	private String disposicaoLayoutGenerico;
	@Column(name="tipoPlataformaSistema")
	private String tipoPlataformaSistema;
	
	
	
	public String getNomeEstrangeiroCliente() {
		return nomeEstrangeiroCliente;
	}
	public void setNomeEstrangeiroCliente(String nomeEstrangeiroCliente) {
		this.nomeEstrangeiroCliente = nomeEstrangeiroCliente;
	}
	public String getNomeEstrangeiroAdministrador() {
		return nomeEstrangeiroAdministrador;
	}
	public void setNomeEstrangeiroAdministrador(String nomeEstrangeiroAdministrador) {
		this.nomeEstrangeiroAdministrador = nomeEstrangeiroAdministrador;
	}
	public long getIdServico() {
		return idServico;
	}
	public void setIdServico(long idServico) {
		this.idServico = idServico;
	}
	public long getIdEstrangeiroCliente() {
		return idEstrangeiroCliente;
	}
	public void setIdEstrangeiroCliente(long idEstrangeiroCliente) {
		this.idEstrangeiroCliente = idEstrangeiroCliente;
	}
	public long getIdEstrangeiroAdministrador() {
		return idEstrangeiroAdministrador;
	}
	public void setIdEstrangeiroAdministrador(long idEstrangeiroAdministrador) {
		this.idEstrangeiroAdministrador = idEstrangeiroAdministrador;
	}
	public String getTituloServico() {
		return tituloServico;
	}
	public void setTituloServico(String tituloServico) {
		this.tituloServico = tituloServico;
	}
	public String getDataAberturaServico() {
		return dataAberturaServico;
	}
	public void setDataAberturaServico(String dataAberturaServico) {
		this.dataAberturaServico = dataAberturaServico;
	}
	public String getDescricaoServico() {
		return descricaoServico;
	}
	public void setDescricaoServico(String descricaoServico) {
		this.descricaoServico = descricaoServico;
	}
	public String getStatusServico() {
		return statusServico;
	}
	public void setStatusServico(String statusServico) {
		this.statusServico = statusServico;
	}
	public double getPrecoServico() {
		return precoServico;
	}
	public void setPrecoServico(double precoServico) {
		this.precoServico = precoServico;
	}
	public String getDisposicaoRemotoServico() {
		return disposicaoRemotoServico;
	}
	public void setDisposicaoRemotoServico(String disposicaoRemotoServico) {
		this.disposicaoRemotoServico = disposicaoRemotoServico;
	}
	public String getTipoDispositivoServico() {
		return tipoDispositivoServico;
	}
	public void setTipoDispositivoServico(String tipoDispositivoServico) {
		this.tipoDispositivoServico = tipoDispositivoServico;
	}
	public String getDisposicaoLayoutGenerico() {
		return disposicaoLayoutGenerico;
	}
	public void setDisposicaoLayoutGenerico(String disposicaoLayoutGenerico) {
		this.disposicaoLayoutGenerico = disposicaoLayoutGenerico;
	}
	public String getTipoPlataformaSistema() {
		return tipoPlataformaSistema;
	}
	public void setTipoPlataformaSistema(String tipoPlataformaSistema) {
		this.tipoPlataformaSistema = tipoPlataformaSistema;
	}
	
	
	
//	@JoinColumn(name = "idCliente")
//	@ManyToOne
//	@NotFound(action = NotFoundAction.IGNORE)  //Resolve o erro de execeção javax.persistence.EntityNotFoundException: Unable to find.
//	private Cliente clienteDoServico;
//	@JoinColumn(name = "idAdministrador")
//	@ManyToOne
//	@NotFound(action = NotFoundAction.IGNORE)  //Resolve o erro de execeção javax.persistence.EntityNotFoundException: Unable to find.
//	private Administrador administradorDoServico;
	

	
	
	
//	public Cliente getClienteDoServico() {
//		return clienteDoServico;
//	}
//	public void setClienteDoServico(Cliente clienteDoServico) {
//		this.clienteDoServico = clienteDoServico;
//	}
//	public Administrador getAdministradorDoServico() {
//		return administradorDoServico;
//	}
//	public void setAdministradorDoServico(Administrador administradorDoServico) {
//		this.administradorDoServico = administradorDoServico;
//	}
	

}
