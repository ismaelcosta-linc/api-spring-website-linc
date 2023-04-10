package com.APIwebsitelinc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.APIwebsitelinc.Model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String>{

	Cliente findByIdCliente(long idCliente);
	
	Cliente findByNomeCliente(String nomeCliente);
	
}
