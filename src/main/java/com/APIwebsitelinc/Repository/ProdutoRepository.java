package com.APIwebsitelinc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.APIwebsitelinc.Model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, String>{
	
	Produto findByIdProduto(long idProduto);
	
	Produto findByNomeProduto(String nomeProduto);
	
}
