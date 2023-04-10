package com.APIwebsitelinc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.APIwebsitelinc.Model.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, String>{
	
	Servico findByIdServico(long idServico);
	
}
