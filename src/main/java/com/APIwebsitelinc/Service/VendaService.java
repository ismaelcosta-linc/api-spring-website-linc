package com.APIwebsitelinc.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.APIwebsitelinc.Model.Venda;
import com.APIwebsitelinc.Repository.VendaRepository;

@Service(value = "vendaservice")
public class VendaService {
	
	@Autowired
	private VendaRepository vendarepository;
	
	public Venda save(Venda venda) {
		return vendarepository.save(venda);
	}
	public Venda findByIdVenda(long idVenda) {
		return vendarepository.findByIdVenda(idVenda);
	}
	public List<Venda> findAllVenda(){
		return vendarepository.findAll();
	}
	public void deleteByIdVenda(long idVenda) {
		Venda venda = vendarepository.findByIdVenda(idVenda);
		vendarepository.delete(venda);
	}
	public void removeByVenda(Venda venda) {
		vendarepository.delete(venda);
	}
}
