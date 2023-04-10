//package com.APIwebsitelinc.ControllerWebsite;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.APIwebsitelinc.Model.Cliente;
//import com.APIwebsitelinc.Model.Produto;
//import com.APIwebsitelinc.Model.Servico;
//import com.APIwebsitelinc.Model.Venda;
//import com.APIwebsitelinc.ODT.ClienteODT;
//import com.APIwebsitelinc.ODT.LoginODT;
//import com.APIwebsitelinc.Service.ClienteService;
//import com.APIwebsitelinc.Service.ProdutoService;
//import com.APIwebsitelinc.Service.ServicoService;
//import com.APIwebsitelinc.Service.VendaService;
//
//@Controller
//public class Website {
//	
//	@Autowired
//	private ClienteService clienteservice;
//	
//	@Autowired
//	private ServicoService servicoservice;
//	
//	@Autowired
//	private ProdutoService produtoservice;
//	
//	@Autowired
//	private VendaService compraservice;
//	
//	
//	private Cliente clienteglobal;
//	
//	private Produto produtoglobal;
//	
//	
//	public Runnable thread_temporizador = new Runnable() {
//		public void run() {
//			try {
//				Thread.sleep(60000 * 20);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			clienteglobal = null;
//		}
//	};
//	
//	public void limpacompra() {
//		this.produtoglobal = null;
//	}
//	
//	
//	@GetMapping(value="/")
//	public String index() {
//		limpacompra();
//		return "website/index.html";
//	}
//	@GetMapping("/sobre")
//	public String sobre() {
//		limpacompra();
//		return "website/sobre.html";
//	}
//	
//	
//	@GetMapping("/login")
//	public String login_get() {
//		limpacompra();
//		return "website/login.html";
//	}
//	@PostMapping("/login")
//	public String login_post(LoginODT loginodt, HttpServletRequest request) throws InterruptedException {
//		
//		Thread.sleep(2000);
//		List<Cliente> listaclientes = clienteservice.findAllClientes();
//
//		for(int cont=1; cont <= listaclientes.size(); cont++) {
//			if(clienteservice.findByIdCliente(cont) != null) {
//				if(clienteservice.findByIdCliente(cont).getLogin().equals(loginodt.getUsername()) &&
//					clienteservice.findByIdCliente(cont).getSenha().equals(loginodt.getPassword())) {
//						
//						this.clienteglobal = clienteservice.findByIdCliente(cont);
//						new Thread(thread_temporizador).start();
//						
//						String ipAddress = request.getHeader("X-FORWARDED-FOR");
//						if (ipAddress == null) {
//							ipAddress = request.getRemoteAddr();
//						}
//						clienteglobal.setIpCliente(ipAddress);
//						clienteservice.save(clienteglobal);
//											
//						return "website/login-aprovado.html";
//				}
//			}
//		}
//		return "redirect:/login";
//	}
//	
//	
//	@GetMapping("/cadastro")
//	public String cadastro_get() {
//		limpacompra();
//		return "website/cadastro-website.html";
//	}
//	@PostMapping("/cadastro")
//	public String cadastro_post(ClienteODT clienteodt, HttpServletRequest request) {
//		
//		String ipAddress = request.getHeader("X-FORWARDED-FOR");
//		if (ipAddress == null) {
//			ipAddress = request.getRemoteAddr();
//		}
//		List<Cliente> listaCliente0 = clienteservice.findAllClientes();
//		int contIp = 0;
//		for(int cont =0; cont < listaCliente0.size(); cont++) {
//			if(listaCliente0.get(cont) != null) {
//				if(ipAddress.equals(listaCliente0.get(cont).getIpCliente())) {
//					contIp = contIp + 1;
//				}
//			}
//		}
//		if(contIp > 20) {
//			System.out.println("O limite de cadastro para este ip foi atingido");
//			return "redirect:/";
//		}
//		
//		
//		Cliente cliente1 = new Cliente();
//		
//		cliente1.setLogin(clienteodt.getLogin());
//		cliente1.setSenha(clienteodt.getSenha());
//		cliente1.setNomecliente(clienteodt.getNomecliente());
//		cliente1.setCelularCliente(clienteodt.getCelularCliente());
//		cliente1.setEnderecoCliente(clienteodt.getEnderecoCliente());
//		
//		List<Servico> listaDeServico1 = new ArrayList<Servico>();
//		ArrayList<Produto> listaDeProduto1 = new ArrayList<Produto>();
//		
//		cliente1.setServicos(listaDeServico1);
//		cliente1.setProdutos(listaDeProduto1);
//		
//		List<Cliente> listaCliente = clienteservice.findAllClientes();
//		for(int cont =0; cont < listaCliente.size(); cont++) {
//			if(listaCliente.get(cont) != null) {
//				if(listaCliente.get(cont).getLogin().equals(clienteodt.getLogin())) {
//					System.out.println("Username já cadastrado!");
//					return "redirect:/cadastro";
//				}
//			}
//		}
//		
//		clienteservice.save(cliente1);
//		
//		return "redirect:/login";
//	}
//	
//	
//	@GetMapping("/reparacao-de-dispositivos")
//	public String reparacao_dispositivos_get() {
//		limpacompra();
//		if(this.clienteglobal == null) {
//			return "redirect:/login";
//		}else {
//			return "website/reparacao-de-dispositivos.html";
//		}
//	}
//	@GetMapping("/suporte-servico-tecnico-informatica")
//	public String suporte_servico_tecnico_informatica_get() {
//		limpacompra();
//		if(this.clienteglobal == null) {
//			return "redirect:/login";
//		}else {
//			return "website/suporte-servico-tecnico-informatica.html";
//		}
//	}
//	@PostMapping("/suporte-servico-tecnico-informatica")
//	public String suporte_servico_tecnico_informatica_post(Servico servico) {
//		if(this.clienteglobal == null) {
//			return "redirect:/login";
//		}else {
//			
//			servico.setTituloDoServico("Suporte Servico Técnico");
//		//	LocalDateTime now = LocalDateTime.now();servico.setDataDeAberturaDoServico(now.toString());
//			LocalDate data = LocalDate.now();servico.setDataDeAberturaDoServico(data.toString());
//			
//			servico.setStatusservico("Pendente");
//			
//			servicoservice.save(servico);
//			
//			return "redirect:/";
//		}
//	}
//	
//	
//	@GetMapping("/criacao-desenvolvimento-sistemas")
//	public String criacao_desenvolvimento_sistemas_get() {
//		limpacompra();
//		if(this.clienteglobal == null) {
//			return "redirect:/login";
//		}else {
//			return "website/criacao-desenvolvimento-sistemas.html";
//		}
//	}
//	@PostMapping("/criacao-desenvolvimento-sistemas")
//	public String criacao_desenvolvimento_sistemas_post(Servico servico) {
//		if(this.clienteglobal == null) {
//			return "redirect:/login";
//		}else {
//			
//			servico.setTituloDoServico("Desenvolvimento de Sistemas");
//			LocalDateTime now = LocalDateTime.now();servico.setDataDeAberturaDoServico(now.toString());
//			servico.setStatusservico("Pendente");
//			
//			servicoservice.save(servico);
//			
//			return "redirect:/";
//		}
//	}
//	
//	
//	@GetMapping("/loja")
//	public ModelAndView loja_get() {
//		limpacompra();
//		if(this.clienteglobal == null) {
//			ModelAndView mv = new ModelAndView("website/login.html");
//			return mv;
//		}else {
//			List<Produto> produtos = produtoservice.findAllProdutos();
//			ModelAndView mv = new ModelAndView("website/loja-lista-website.html");
//			mv.addObject("produtos", produtos);
//			
//			return mv;
//		}
//	}
//	@PostMapping("/loja")
//	public ModelAndView loja_post(String nomeProduto) {
//		if(this.clienteglobal == null) {
//			ModelAndView mv = new ModelAndView("website/login.html");
//			return mv;
//		}else {
//			List<Produto> produtos = new ArrayList<Produto>();
//			for(int cont=1; cont < produtoservice.findAllProdutos().size(); cont++) {
//				if(produtoservice.findByIdProduto(cont).getNomeDoProduto().equalsIgnoreCase(nomeProduto) == true) {
//					produtos.add(produtoservice.findByIdProduto(cont));
//				}
//			}
//			ModelAndView mv = new ModelAndView("website/loja-lista-website.html");
//			mv.addObject("produtos", produtos);
//			
//			return mv;
//		}
//	}
//	@GetMapping("/iten-venda/{idProduto}")
//	public ModelAndView iten_venda_get(@PathVariable("idProduto") long idProduto) {
//		limpacompra();
//		if(this.clienteglobal == null) {
//			ModelAndView mv = new ModelAndView("website/login.html");
//			return mv;
//		}else {
//			this.produtoglobal = produtoservice.findByIdProduto(idProduto);
//			
//			Produto produto = produtoservice.findByIdProduto(idProduto);
//			ModelAndView mv = new ModelAndView("website/iten-venda.html");
//			mv.addObject("produto", produto);
//			
//			return mv;
//		}
//	}
//	@PostMapping("/finalizar-compra")
//	public String finaliza_compra_post(Venda venda) {
//		
//		if(this.clienteglobal == null) {
//			return "redirect:/login";
//		}else {
//			venda.setClienteDaVenda(clienteglobal);
//			venda.setProduto(produtoglobal);
//			
//			compraservice.save(venda);
//			
//			limpacompra();
//			
//			return "redirect:/";
//		}
//	}
//	
//}
//
//
//
//
//
//
//
//
//
