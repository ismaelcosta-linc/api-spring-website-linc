package com.APIwebsitelinc.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.APIwebsitelinc.Model.Servico;
import com.APIwebsitelinc.Repository.ServicoRepository;

@Service(value = "servicoService")
public class ServicoService {
	
	@Autowired
	private ServicoRepository servicorepository;
	
	public Servico save(Servico servico) {
		return servicorepository.save(servico);
	}
	public Servico findByIdServico(long idServico) {
		return servicorepository.findByIdServico(idServico);
	}
	public List<Servico> findAllServicos(){
		return servicorepository.findAll();	
	}
	public void deletServicoByServico(Servico servico) {
		servicorepository.delete(servico);
	}
	public void deleteByIdServico(long idServico) {
		Servico servico1 = servicorepository.findByIdServico(idServico);
		servicorepository.delete(servico1);
	}
	public void removeByServico(Servico servico) {
		servicorepository.delete(servico);
	}
}
