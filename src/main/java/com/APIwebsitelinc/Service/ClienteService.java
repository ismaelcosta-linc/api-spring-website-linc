package com.APIwebsitelinc.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.APIwebsitelinc.Model.Cliente;
import com.APIwebsitelinc.Repository.ClienteRepository;

@Service(value = "clienteService")
public class ClienteService {

	@Autowired
	private ClienteRepository clienterepository;
	
	
	public Cliente save(Cliente cliente) {
		return clienterepository.save(cliente);
	}
	public List<Cliente> findAllClientes(){
		return clienterepository.findAll();
	}
	public Cliente findByIdCliente(long idCliente) {
		return clienterepository.findByIdCliente(idCliente);
	}
	public Cliente findByNomecliente(String nome) {
		return clienterepository.findByNomeCliente(nome);
	}
	public void deleteByIdCliente(long idCliente) {
		Cliente cliente = clienterepository.findByIdCliente(idCliente);
		clienterepository.delete(cliente);
	}
	public void removeByCliente(Cliente cliente) {
		clienterepository.delete(cliente);
	}	
}
