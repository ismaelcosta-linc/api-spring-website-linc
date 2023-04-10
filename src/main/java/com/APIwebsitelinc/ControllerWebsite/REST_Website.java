package com.APIwebsitelinc.ControllerWebsite;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.APIwebsitelinc.Model.Cliente;
import com.APIwebsitelinc.Model.Produto;
import com.APIwebsitelinc.Model.Servico;
import com.APIwebsitelinc.Model.Venda;
import com.APIwebsitelinc.Service.ClienteService;
import com.APIwebsitelinc.Service.ProdutoService;
import com.APIwebsitelinc.Service.ServicoService;
import com.APIwebsitelinc.Service.VendaService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class REST_Website {
	
	@Autowired
	public ClienteService clienteService;
	
	@Autowired
	public ProdutoService produtoService;
	
	@Autowired
	public VendaService vendaService;
	
	@Autowired
	public ServicoService servicoService;
	
	
	
	@PostMapping("/login-cliente")
	public Cliente loginCliente(@RequestBody Cliente cliente) {
		List<Cliente> listaCliente = clienteService.findAllClientes();
		for(int cont = 0; cont < listaCliente.size(); cont++) {
			if(listaCliente.get(cont).getUsernameCliente() != null && listaCliente.get(cont).getPasswordCliente() != null) {
				if(listaCliente.get(cont).getUsernameCliente().equals(cliente.getUsernameCliente())&&
					listaCliente.get(cont).getPasswordCliente().equals(cliente.getPasswordCliente())) {
						return listaCliente.get(cont);
				}
			}
		}
		Cliente cliente1 = new Cliente();
		return cliente1;
	}

	@PostMapping("/cadastrar-cliente")
	void cadastrarCliente(@RequestBody Cliente cliente) {
		clienteService.save(cliente);
	//	{"idCliente": 4, "usernameCliente": "isma", "passwordCliente": "123", "nomeCliente": "ismael", "celularCliente": "12345678", "enderecoCliente": "Martilho Lutero"}
	}
	
	@GetMapping("/loja")
	public List<Produto> openLoja(){
		List<Produto> listaProduto = produtoService.findAllProdutos();
		List<Produto> produtosSelecionados = new ArrayList<Produto>();
		 for(int cont = 0; cont < listaProduto.size() && cont < 10; cont ++){
		 	if(listaProduto.get(cont).getImagem() != null){
				listaProduto.get(cont).setPathImagemProduto("data:image/jpeg;base64," + Base64.getEncoder().encodeToString(listaProduto.get(cont).getImagem()));
				produtosSelecionados.add(listaProduto.get(cont));
		 	}else{
				break;
			}
		 }
		return produtosSelecionados;
	}

	@PostMapping("/loja")
	public List<Produto> searchProduto(@RequestBody String nomeProduto){
		List<Produto> listaProduto = produtoService.findAllProdutos();
		List<Produto> produtosSelecionados = new ArrayList<Produto>();
		for(int cont = 0; cont < listaProduto.size(); cont++) {
			if(listaProduto.get(cont).getNomeProduto() != null) {
				if(listaProduto.get(cont).getNomeProduto().equalsIgnoreCase(nomeProduto)) {
					if(listaProduto.get(cont).getImagem() != null){
						listaProduto.get(cont).setPathImagemProduto("data:image/jpeg;base64," + Base64.getEncoder().encodeToString(listaProduto.get(cont).getImagem()));
					}
					produtosSelecionados.add(listaProduto.get(cont));
				}
			}
		}
		return produtosSelecionados;
	}

	@PostMapping("/loja-item")
	public Produto lojaItem(@RequestBody long idProduto){
		List<Produto> listaProduto = produtoService.findAllProdutos();
		Produto produto1 = new Produto();
		for(int cont = 0; cont < listaProduto.size(); cont++) {
			if(listaProduto.get(cont).getIdProduto() != 0) {
				if(listaProduto.get(cont).getIdProduto() == idProduto) {
					if(listaProduto.get(cont).getImagem() != null){
						listaProduto.get(cont).setPathImagemProduto("data:image/jpeg;base64," + Base64.getEncoder().encodeToString(listaProduto.get(cont).getImagem()));
					}
					produto1 = listaProduto.get(cont);
				}
			}
		}
		return produto1;
	}

	@PostMapping("/finalizar-compra")
	public void confirmarCompra(@RequestBody Venda venda) {
		vendaService.save(venda);
	}
	
	@PostMapping("/finalizar-servico")
	public void confirmarServico(@RequestBody Servico servico) {
		servicoService.save(servico);
	}

}






























