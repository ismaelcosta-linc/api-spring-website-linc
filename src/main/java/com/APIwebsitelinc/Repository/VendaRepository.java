package com.APIwebsitelinc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.APIwebsitelinc.Model.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, String>{
	
	Venda findByIdVenda(long idVenda);
}
