// package com.APIwebsitelinc.ControllerAdministrador;

// import java.io.IOException;
// import java.util.ArrayList;
// import java.util.List;

// import javax.servlet.http.HttpSession;

// import org.springframework.beans.factory.annotation.Autowired;
// // import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.ResponseBody;
// import org.springframework.web.multipart.MultipartFile;
// import org.springframework.web.servlet.ModelAndView;

// import com.APIwebsitelinc.Model.Administrador;
// import com.APIwebsitelinc.Model.Cliente;
// import com.APIwebsitelinc.Model.Produto;
// import com.APIwebsitelinc.Model.Servico;
// import com.APIwebsitelinc.Model.Venda;
// import com.APIwebsitelinc.Service.AdministradorService;
// import com.APIwebsitelinc.Service.ClienteService;
// import com.APIwebsitelinc.Service.ProdutoService;
// import com.APIwebsitelinc.Service.ServicoService;
// import com.APIwebsitelinc.Service.VendaService;

// @Controller
// public class AdministradorController {
	
// 	@Autowired
// 	private ClienteService clienteservice;
	
// 	@Autowired
// 	private ServicoService servicoservice;
	
// 	@Autowired
// 	private ProdutoService produtoservice;
	
// 	@Autowired
// 	private VendaService vendaservice;
	
// 	@Autowired
// 	private AdministradorService Administradorservice;
//	
//	
//	private static String chaveglobaladministrador = "kTG3W1rK18zBurT48oDpFV4SVurdPQMm8c6kuTipLQaQdCPAMLQlock";
//	private int permissaomaster = 0;
//	
//	public long idServicoGlobal;
//	
////	Atividades Administraor:
////		/administrador
////		/listar-clientes-cadastrados
////		/cadastrar-novo-administrador
////		/listar-administradores-cadastrado
////		/servicos-administrador-expecifico/{idAdministrador}
////		/cadastrar-novo-produto
////		/listar-produtos-cadastrados
////		/editar-produto/{idProduto}
////		/excluir-produto/{idProduto}
////		/imagem/{idProduto}
////		/listar-produtos-vendidos
////		/exibir-cliente-especifico/{idCliente}
//		
//	
//	@GetMapping("/login-administrador")
//	public String login_administrador() throws InterruptedException {
//		
//		Thread.sleep(2000);
//		
//		List<Administrador> listaAdministrador = Administradorservice.findAllAdministrador();
//		for(int cont =0; cont < listaAdministrador.size(); cont++) {
//			if(listaAdministrador.get(cont) != null) {
//				if(listaAdministrador.get(cont).getUsername().equals("linc")){
//					return "administrador/login/login-administrador1.html";
//				}
//			}
//		}
//		Administrador administrador = new Administrador();
//			administrador.setUsernameAdministrador("linc");
//			administrador.setPasswordAdministrador(new BCryptPasswordEncoder().encode("cnlinc"));
//			administrador.setNomeAdministrador("Ismael.Costa");
//			administrador.setCelularAdministrador("(83)98177-0681");
//			administrador.setEnderecoAdministrador("Rua Matinho Lutero 71 - JP");
//		Administradorservice.save(administrador);
//		
//		return "administrador/login/login-administrador1.html";
//	}
//	
//	@GetMapping("/logout-administrador")
//	public String logout_administrador(HttpSession session) {
//		session.invalidate();
//		return "redirect:/login-administrador";
//	}
//	
//	@GetMapping("/administrador")
//	public String acessar_get(){
//		return "administrador/home-administrador.html";
//	}
//	
//	@GetMapping("/acesso-master")
//	public String acesso_master_get() {
//	return "administrador/master/acesso-master.html";
//	}
//	@PostMapping("/acesso-master")
//	public String acesso_master_post(String chave) throws InterruptedException {
//		Thread.sleep(1500);
//		System.out.println(chave);
//		if(chave.equals(chaveglobaladministrador)) {
//			this.permissaomaster = 1;
//			return "redirect:/listar-servicos-cadastrados";
//		}else {
//			return "redirect:/administrador";
//		}
//	}
//	@GetMapping("/sair-master")
//	public String sair_master_get() {
//		this.permissaomaster = 0;
//		return "redirect:/administrador";
//	}
//	
//	
//	//###################################################################################################################
//	//	CLIENTE
//	//###################################################################################################################
//	@GetMapping("/cadastrar-novo-cliente")
//	public String cadastrar_cliente_get() {
//		if(permissaomaster == 1) {
//			return "website/cadastro-website.html";
//		}else {
//			return "redirect:/administrador";
//		}
//	}
//	@PostMapping("/cadastrar-novo-cliente")
//	public String cadastrar_cliente_post(Cliente cliente) {
//		if(permissaomaster == 1) {
//			List<Servico> listaDeServico1 = new ArrayList<Servico>();
//			ArrayList<Produto> listaDeProduto1 = new ArrayList<Produto>();
//			
//			cliente.setServicos(listaDeServico1);
//			cliente.setProdutos(listaDeProduto1);
//			
//			clienteservice.save(cliente);
//			
//			return "redirect:/listar-clientes-cadastrados";
//		}else {
//			return "redirect:/administrador";
//		}
//	}
//	@GetMapping("/editar-cliente/{idCliente}")
//	public ModelAndView editar_cliente_get(@PathVariable("idCliente") long idCliente) {
//		if(permissaomaster == 1) {
//			Cliente cliente1 = clienteservice.findByIdCliente(idCliente);
//			ModelAndView mv = new ModelAndView("administrador/clientes/editar-cliente-administrador.html");
//			mv.addObject("cliente1", cliente1);
//			
//			return mv;
//		}else {
//			ModelAndView mv = new ModelAndView("redirect:/administrador");
//			return mv;
//		}
//	}
//	@PostMapping("/editar-cliente/{idCliente}")
//	public String editar_cliente_post(Cliente cliente) {
//		if(permissaomaster == 1) {
//			// MUITO IMPORTANTE: 
//			//O Thymeleaf está sendo responsável por guardar os dados do cliente durante a edição
//			//Parece que passar todos os dados do cliente pelo thymeleaf me faz perder os demais dados dele.
//			
//			clienteservice.save(cliente);
//			
//			return "redirect:/listar-clientes-cadastrados";
//		}else {
//			return "redirect:/administrador";
//		}
//	}
//	@GetMapping("/listar-clientes-cadastrados")
//	public ModelAndView listar_clientes_get() {
//		List<Cliente> listaDeClientes = clienteservice.findAllClientes();
//		ModelAndView mv = new ModelAndView("administrador/clientes/lista-clientes-administrador.html");
//		mv.addObject("clientes", listaDeClientes);
//		
//		return mv;
//	}
//	@GetMapping("/listar-servicos-do-cliente/{idCliente}")
//	public ModelAndView listar_servicos_do_cliente_get(@PathVariable("idCliente") long idCliente) {
//
//			Cliente cliente1 = clienteservice.findByIdCliente(idCliente);
//			List<Servico> listaDeServicos = cliente1.getServicos();
//			ModelAndView mv = new ModelAndView("administrador/clientes/lista-servicos-do-cliente.html");
//			mv.addObject("listaDeServicos", listaDeServicos);
//			
//			return mv;
//
//	}
//	
//	@GetMapping("/excluir-cliente/{idCliente}")
//	public String excluir_cliente_get(@PathVariable("idCliente") long idCliente){
//		if(permissaomaster == 1) {
//			
//			Cliente cliente1 = clienteservice.findByIdCliente(idCliente);
//			List<Servico> listadeServicos = cliente1.getServicos();
//			
//			for(int cont =0; cont < listadeServicos.size(); cont++) {
//				servicoservice.deletServicoByServico(listadeServicos.get(cont));
//			}
//			clienteservice.save(cliente1);
//			clienteservice.deleteByIdCliente(idCliente);
//			
//			return "redirect:/listar-clientes-cadastrados";
//		}else {
//			return "redirect:/administrador";
//		}
//	}
//	
//	//###################################################################################################################
//	//	SERVICO
//	//###################################################################################################################
//	@GetMapping("/cadastrar-novo-servico")
//	public String cadastrar_servico_get() {
//		if(permissaomaster == 1) {
//			return "administrador/servicos/cadastro-servico-administrador.html";
//		}else {
//			return "redirect:/administrador";
//		}
//	}
//	@PostMapping("/cadastrar-novo-servico")
//	public ModelAndView cadastrar_servico_post(Servico servico) { 
//		if(permissaomaster == 1) {
//			//IMPORTANTE:
//			//O objeto servico que vem do formulário não possui id porque não foi inicializado.
//			//Parece que após o salvamento no banco, o objeto é automaticamente inicializado.
//			//Então primeiro eu devo salvar ou inicializar manualmente:
//			
//			//Na verdade Parece que o objeto só ganha ID somente após passar pelo save(objeto).
//			//Então eu tenho que fazer primeiro o save(objeto), e em seguida recupera-lo para trabalhar com ele.
//			//Parece que a única maneira de recuperar ele do banco após salvar é requisitando o último salvamento realizado.
//			
//			//Já constatei que o objeto passado pelo formulário somente recebe um id após o save(object),
//			//e não é necessário recuperar ele do banco após salvar, o próprio objetozero passa a ter id para trabalhar. Então preciso savar antes de tudo.
//			//Também constatei que pegar todos os objetos do banco e cocar numa lista, depois requisitar seu tamanho -1 é igual ao index final da lista.
//			
//			servicoservice.save(servico);
//			this.idServicoGlobal = servico.getIdServico();
//			//FUNCIONOU, this.idServicoGlobal agora possui o id de Servicozero
//			
//			ModelAndView mv = new ModelAndView("administrador/servicos/selecionar-cliente-do-servico.html");
//			List<Cliente> clientes = clienteservice.findAllClientes();
//			mv.addObject("clientes", clientes);
//			
//			return mv;
//		}else {
//			ModelAndView mv = new ModelAndView("redirect:/administrador");
//			return mv;
//		}
//	}
//	@GetMapping("/selecionar-cliente-do-servico/{idCliente}")
//	public ModelAndView selecionar_cliente_do_servico_get(@PathVariable("idCliente") long idCliente) {
//		if(permissaomaster == 1) {
//			//String.valueOf() transforma inteiro em String, e Integer.parseInt() para inteiro dnv.
//			//Parece que a forma correta de settar relacionamentos é setar o maior dentro do menor;
//			
//			Cliente cliente1 = clienteservice.findByIdCliente(idCliente);
//			Servico servico1 = servicoservice.findByIdServico(idServicoGlobal);
//			
//			servico1.setIdEstrangeiroCliente(idCliente);//Ainda é necessario settar o idEstrangeiroCliente dentro do Servico.
//			
//			servico1.setClienteDoServico(cliente1);
//			//PASSOU A FUNCIONAR TUDO
//			servicoservice.save(servico1);
//			
//			List<Administrador> listaAdministradorSemSenha = Administradorservice.findAllAdministrador();
//			
//			for(int cont=0; cont < listaAdministradorSemSenha.size(); cont ++) {//Não pode ser <= , tem que ser <
//				listaAdministradorSemSenha.get(cont).setPasswordAdministrador(null);
//			}
//			
//			ModelAndView mv = new ModelAndView("administrador/servicos/selecionar-administrador-do-servico.html");
//			mv.addObject("administradores", listaAdministradorSemSenha);
//			
//			return mv;
//		}else {
//			ModelAndView mv = new ModelAndView("redirect:/administrador");
//			return mv;
//		}
//	}
//	@GetMapping("/selecionar-administrador-do-servico/{idAdministrador}")
//	public String selecionar_administrador_do_servico_get(@PathVariable("idAdministrador") long idAdministrador){
//		if(permissaomaster == 1) {
//			Servico servico1 = servicoservice.findByIdServico(idServicoGlobal);
//			Administrador Administrador1 = Administradorservice.findByIdAdministrador(idAdministrador);
//			
//			servico1.setIdEstrangeiroAdministrador(idAdministrador);
//			servico1.setAdministradorDoServico(Administrador1);
//			
//			servicoservice.save(servico1);
//			
//			return "redirect:/listar-servicos-cadastrados";
//		}else {
//			return "redirect:/administrador";
//		}
//	}
//	
//	
//	@GetMapping("/listar-servicos-cadastrados")
//	public ModelAndView listar_servicos_cadastrados_get() {
//
//			List<Servico> listadeservico = servicoservice.findAllServicos();
//			ModelAndView mv = new ModelAndView("administrador/servicos/lista-servicos-administrador.html");
//			mv.addObject("listaDeServicos", listadeservico);
//			
//			return mv;
//
//	}
//	
//	@GetMapping("/editar-servico/{idServico}")
//	public ModelAndView editar_servico_get(@PathVariable("idServico") long idServico) {
//		if(permissaomaster == 1) {
//			this.idServicoGlobal = idServico;
//			Servico servico1 = servicoservice.findByIdServico(idServico); 
//			ModelAndView mv = new ModelAndView("administrador/servicos/editar-servico-administrador.html");
//			mv.addObject("servico1", servico1);
//			
//			return mv;
//		}else {
//			ModelAndView mv = new ModelAndView("redirect:/administrador");
//			return mv;
//		}
//	}
//	@PostMapping("/editar-servico/{idServico}")
//	public ModelAndView editar_servico_post(Servico servico) {
//		if(permissaomaster == 1) {
//			// MUITO IMPORTANTE: 
//			//O Thymeleaf está sendo responsável por guardar os dados do servico durante a edição
//			//Parece que passar todos os dados do serviço pelo thymeleaf me faz perder os Ids dele.
//	
//			servico.setIdServico(this.idServicoGlobal);
//			servico.setAdministradorDoServico(null);
//			servicoservice.save(servico);
//			
//			ModelAndView mv = new ModelAndView("administrador/servicos/selecionar-cliente-do-servico.html");
//			List<Cliente> clientes = clienteservice.findAllClientes();
//			mv.addObject("clientes", clientes);
//			
//			return mv;
//		}else {
//			ModelAndView mv = new ModelAndView("redirect:/administrador");
//			return mv;
//		}
//	}
//	
//	@GetMapping("/excluir-servico/{idServico}")
//	public String excluir_servico_get(@PathVariable("idServico") long idServico){
//		if(permissaomaster == 1) {
//			
//			Servico servico1 = servicoservice.findByIdServico(idServico);
//			
//			servicoservice.deletServicoByServico(servico1);
//			
//			return "redirect:/listar-servicos-cadastrados";
//		}else {
//			return "redirect:/administrador";
//		}
//	}
//	
//
	// //###################################################################################################################
	// //	PRODUTO
	// //###################################################################################################################
	// @GetMapping("/cadastrar-novo-produto")
	// public String cadastrar_produto_get() {
	// 	return "administrador/produtos/cadastro-produto-administrador.html";
	// }
	// @PostMapping("/cadastrar-novo-produto")
	// public String cadastrar_produto_post(Produto produto, @RequestParam("imagemProduto") MultipartFile file) throws IOException {
		
	// 	try {
	// 		produto.setImagem(file.getBytes());
	// 	} catch (IOException e) {
	// 		e.printStackTrace();
	// 	}
		
	// 	produtoservice.save(produto);
		
	// 	return "redirect:/administrador";
	// }
	// @GetMapping("/listar-produtos-cadastrados")
	// public ModelAndView listar_produto() {
		
	// 	List<Produto> listaDeProdutos = produtoservice.findAllProdutos();
	// 	ModelAndView mv = new ModelAndView("administrador/produtos/lista-produtos-administrador.html");
	// 	mv.addObject("produtos", listaDeProdutos);
		
	// 	return mv;
	// }
	// @GetMapping("/editar-produto/{idProduto}")
	// public ModelAndView editar_produto_get(@PathVariable("idProduto") long idProduto) {
		
	// 	Produto produto1 = produtoservice.findByIdProduto(idProduto);
	// 	ModelAndView mv = new ModelAndView("administrador/produtos/editar-produto-administrador.html");
	// 	mv.addObject("produto1", produto1);
		
	// 	return mv;
	// }
	// @PostMapping("/editar-produto/{idProduto}")
	// public String editar_produto_post(Produto produto) {
		
	// 	// MUITO IMPORTANTE: 
	// 	//O Thymeleaf está sendo responsável por guardar os dados do produto durante a edição
	// 	//Parece que passar todos os dados do produto pelo thymeleaf me faz perder os demais dados dele.
		
	// 	produtoservice.save(produto);
		
	// 	return "administrador/home-administrador.html";
	// }
	
	// @GetMapping("/imagem/{idProduto}")
	// @ResponseBody
	// public byte[] exibir_imagem_produto_get(@PathVariable("idProduto") Integer idProduto) {
		
	// 	Produto produto1 = produtoservice.findByIdProduto(idProduto);
	// 	return produto1.getImagem();
	// }
	// @GetMapping("/listar-produtos-vendidos")
	// public ModelAndView listar_produtos_vendidos_get() {
	// 	List<Venda> listadeVendas = vendaservice.findAllVenda();
	// 	ModelAndView mv = new ModelAndView("administrador/produtos/lista-produtos-vendidos.html");
	// 	mv.addObject("listadeVendas", listadeVendas);
		
	// 	return mv;
	// }
//	@GetMapping("/exibir-cliente-especifico/{idCliente}")
//	public ModelAndView exibir_cliente_especifico_get(@PathVariable("idCliente") long idCliente) {
//		Cliente cliente1 = clienteservice.findByIdCliente(idCliente);
//		ModelAndView mv = new ModelAndView("administrador/clientes/exibir-cliente-especifico.html");
//		mv.addObject("cliente", cliente1);
//		
//		return mv;
//	}	
//	
//	@GetMapping("/excluir-produto/{idProduto}")
//	public String excluir_produto_get(@PathVariable("idProduto") long idProduto){
//			
//		Produto produto1 = produtoservice.findByIdProduto(idProduto);
//		produtoservice.deletByProduto(produto1);
//		
//		return "redirect:/listar-produtos-cadastrados";
//
//	}
//	
//	//###################################################################################################################
//	//	ADMINISTRADOR
//	//###################################################################################################################
//	@GetMapping("/cadastrar-novo-Administrador")
//	public String cadastrar_novo_Administrador_get() {
//		return "administrador/master/cadastro-administrador.html";
//	}
//	@PostMapping("/cadastrar-novo-Administrador")
//	public String cadastrar_novo_Administrador_post(Administrador administrador) {
//		List<Administrador> listaAdministrador = Administradorservice.findAllAdministrador();
//		if(listaAdministrador.size()<10) { //Limite de 10 funcionarios;
//			for(int cont =0; cont < listaAdministrador.size(); cont++) {
//				if(listaAdministrador.get(cont) != null) {
//					if(listaAdministrador.get(cont).getUsernameAdministrador().equals(administrador.getUsernameAdministrador())) {
//						return "administrador/home-administrador.html";
//					}
//				}
//			}
//			administrador.setPasswordAdministrador(new BCryptPasswordEncoder().encode(administrador.getPassword()));
//			Administradorservice.save(administrador);
//			return "redirect:/listar-Administradors-cadastrado";
//		}else {
//			return "administrador/home-administrador.html";
//		}
//	}
//	
//	@GetMapping("/listar-Administradors-cadastrado")
//	public ModelAndView listar_Administradors_cadastrados_get(){
//		List<Administrador> listaAdministradorSemSenha = Administradorservice.findAllAdministrador();
//		for(int cont=0; cont < listaAdministradorSemSenha.size(); cont ++) {//Não pode ser <= , tem que ser <
//			listaAdministradorSemSenha.get(cont).setPasswordAdministrador(null);
//		}
//		ModelAndView mv = new ModelAndView("administrador/master/lista-administradores.html");
//		mv.addObject("administradores", listaAdministradorSemSenha);
//
//		return mv;
//	}
//	
//	@GetMapping("/servicos-administrador-expecifico/{idAdministrador}")
//	public ModelAndView servico_administrador_expecifico_get(@PathVariable("idAdministrador") long idAdministrador){
//
//		Administrador Administrador1 = Administradorservice.findByIdAdministrador(idAdministrador);
//		List<Servico> listaDeServicos = Administrador1.getServicos();
//		System.out.println(listaDeServicos.size());
//		ModelAndView mv = new ModelAndView("administrador/master/servico-administrador-expecifico.html");
//		mv.addObject("listaDeServicos", listaDeServicos);
//
//		return mv;
//
//	}
//	
//	
//	@GetMapping("/listar-Administradors-excluir-cadastrado")
//	public ModelAndView listar_Administradors_excluir_get(){
//		if(permissaomaster == 1) {
//			List<Administrador> listaAdministradorSemSenha = Administradorservice.findAllAdministrador();
//			for(int cont=0; cont < listaAdministradorSemSenha.size(); cont ++) {//Não pode ser <= , tem que ser <
//				listaAdministradorSemSenha.get(cont).setPasswordAdministrador(null);
//			}
//			ModelAndView mv = new ModelAndView("administrador/master/lista-administradores-excluir.html");
//			mv.addObject("administradores", listaAdministradorSemSenha);
//	
//			return mv;
//		}else {
//			ModelAndView mv = new ModelAndView("redirect:/administrador");
//			return mv;
//		}
//	}
//	@GetMapping("/excluir-administrador/{idAdministrador}")
//	public String excluir_administrador_get(@PathVariable("idAdministrador") long idAdministrador){
//		if(permissaomaster == 1) {
//			
//			Administrador administrador1 = Administradorservice.findByIdAdministrador(idAdministrador);
//			List<Servico> listadeServico = administrador1.getServicos();
//			
//			for(int cont =0; cont < listadeServico.size(); cont++) {
//				servicoservice.deletServicoByServico(listadeServico.get(cont));
//			}
//			Administradorservice.save(administrador1);
//			Administradorservice.removeByAdministrador(administrador1);
//			
//			return "redirect:/listar-Administradors-cadastrado";
//		}else {
//			return "redirect:/administrador";
//		}
//	}
//	
//	
// }
