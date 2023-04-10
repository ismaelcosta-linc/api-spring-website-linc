package com.APIwebsitelinc.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.APIwebsitelinc.Model.Produto;
import com.APIwebsitelinc.Repository.ProdutoRepository;

@Service(value = "produtoService")
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtorepository;
	
	public Produto save(Produto produto) {
		return produtorepository.save(produto);
	}
	public Produto findByIdProduto(long idProduto) {
		return produtorepository.findByIdProduto(idProduto);
	}
	public Produto findBynomeProduto(String nome) {
		return produtorepository.findByNomeProduto(nome);
	}
	public List<Produto> findAllProdutos() {
		return produtorepository.findAll();
	}
	public void deleteByIdProduto(long idProduto) {
		Produto produto = produtorepository.findByIdProduto(idProduto);
		produtorepository.delete(produto);
	}
	public void removeByProduto(Produto produto) {
		produtorepository.delete(produto);
	}
}
