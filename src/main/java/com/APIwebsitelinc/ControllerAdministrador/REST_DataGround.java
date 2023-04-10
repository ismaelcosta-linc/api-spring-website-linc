// package com.APIwebsitelinc.ControllerAdministrador;

// import java.io.IOException;
// import java.io.InputStream;
// import java.net.HttpURLConnection;
// import java.net.URL;
// import java.util.ArrayList;
// import java.util.Base64;
// import java.util.List;
// import java.util.concurrent.ExecutionException;

// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;

// import com.APIwebsitelinc.Model.Administrador;
// import com.APIwebsitelinc.Model.Cliente;
// import com.APIwebsitelinc.Model.Produto;
// import com.APIwebsitelinc.Model.Servico;
// import com.APIwebsitelinc.Model.Venda;

// @RestController
// @CrossOrigin(origins = "*", allowedHeaders = "*")
// public class REST_DataGround {
	
// 	public static List<Administrador> administradores;
// 	public static List<Cliente> clientes;
// 	public static List<Produto> produtos;
// 	public static List<Venda> vendas;
// 	public static List<Servico> servicos;
	
// 	public static boolean init = false;
	
// 	public static void init() {
// 		if(init == false) {
// 			administradores = new ArrayList<Administrador>();
// 			clientes = new ArrayList<Cliente>();
// 			produtos = new ArrayList<Produto>();
// 			vendas = new ArrayList<Venda>();
// 			servicos = new ArrayList<Servico>();
			
// 			Administrador adm = new Administrador();
// 				adm.setIdAdministrador(1);
// 				adm.setNomeAdministrador("ismael");
// 				adm.setCelularAdministrador("981770681");
// 				adm.setEnderecoAdministrador("Martinho Lutero - 71. PB");
// 				adm.setUsernameAdministrador("isma");
// 				adm.setPasswordAdministrador("cnleamsi");
// 			administradores.add(adm);
			
// 			init = true;

// 			Runnable keepalive = new Runnable(){
// 				@Override
// 				public void run(){
// 					int count = 0;
// 					try {
// 						while(true){
// 							Thread.sleep((1000 * 60) * 10);
// 							System.out.println("CONTADOR DE MINUTOS: "+ count);
// 							count = count + 10;
// 						}
// 					} catch (InterruptedException e) {e.printStackTrace();}
// 				}
// 			};
// 			Thread keepalivethread = new Thread(keepalive);
// 			keepalivethread.start();
// 		}
// 	}


// 	// public Runnable keepAliveRunnable = new Runnable(){
// 	// 	@Override
// 	// 	public void run(){
// 	// 		try {
// 	// 			while(true){
// 	// 				System.out.println("ENTROU KEEP_ALIVE REQUEST!!!");
// 	// 				// Create a neat value object to hold the URL
// 	// 				URL url = new URL("https://api-local-website-linc.herokuapp.com/dg-ping-keepalive");
					
// 	// 				// Open a connection(?) on the URL(?) and cast the response(??)
// 	// 				HttpURLConnection connection = (HttpURLConnection) url.openConnection();

// 	// 				// Now it's "open", we can set the request method, headers etc.
// 	// 				connection.setRequestProperty("accept", "application/json");

// 	// 				// This line makes the request
// 	// 				InputStream responseStream = connection.getInputStream();
// 	// 				Thread.sleep((1000 * 60) * 25);
// 	// 			}

// 	// 		}catch (InterruptedException e) {e.printStackTrace();}
// 	// 		catch (IOException e){e.printStackTrace();}
// 	// 	}
// 	// };
// 	// Thread keepAliveThread = new Thread(keepAliveRunnable);

// 	// @GetMapping("dg-keepalive")
// 	// public void keepalive() throws IOException, InterruptedException, ExecutionException{
// 	// 	init();
// 	// 	keepAliveThread.start();
// 	// 	System.out.println("CHEGOU EE TERMINOU REQUEST");
// 	// }
// 	@GetMapping("/dg-ping-keepalive")
// 	public void keepaliveloop() throws IOException, InterruptedException, ExecutionException{
// 		System.out.println("PING KEEPALIVE");
// 	}
	
	
// 	@PostMapping("/upload-data-administradores")
// 	public static void upload_data_administradores(/*List<Administrador> administradoress*/Administrador adm) {
// 		init();
// 		//administradores = administradoress;
// 		administradores.add(adm);
// 	}
// 	@PostMapping("/upload-data-clientes")
// 	public static void upload_data_clientes(List<Cliente> clientess) {
// 		init();
// 		clientes = clientess;
// 	}
// 	@PostMapping("/upload-data-produtos")
// 	public static void upload_data_produtos(List<Produto> produtoss) {
// 		init();
// 		produtos = produtoss;
// 	}
// 	@PostMapping("/upload-data-vendas")
// 	public static void upload_data_vendas(List<Venda> vendass) {
// 		init();
// 		vendas = vendass;
// 	}
// 	@PostMapping("/upload-data-servicos")
// 	public static void upload_data_servicos(List<Servico> servicoss) {
// 		init();
// 		servicos = servicoss;
// 	}
	
// 	@GetMapping("/download-data-administradores")
// 	public static List<Administrador> download_data_administradores() {
// 		init();
// 		return administradores;
// 	}
// 	@GetMapping("/download-data-clientes")
// 	public static List<Cliente> download_data_clientes() {
// 		init();
// 		return clientes;
// 	}
// 	@GetMapping("/download-data-produtos")
// 	public static List<Produto> download_data_produtos() {
// 		init();
// 		return produtos;
// 	}
// 	@GetMapping("/download-data-vendas")
// 	public static List<Venda> download_data_vendas() {
// 		init();
// 		return vendas;
// 	}
// 	@GetMapping("/download-data-servicos")
// 	public static List<Servico> download_data_servicos() {
// 		init();
// 		return servicos;
// 	}
	
	
	
	
	
// 	@PostMapping("/dg-cadastra-administrador")
// 	public void dg_cadastra_administrador(@RequestBody Administrador administrador){
// 		init();
// 		administrador.setIdAdministrador(administradores.size()+1);
// 		administradores.add(administrador);
// 	}
// 	@GetMapping("/dg-lista-administradores")
// 	public List<Administrador> dg_lista_administrador(){
// 		init();
// 		return administradores;
// 	}
// 	@PostMapping("/dg-deleta-administrador")
// 	public void dg_deleta_administrador(@RequestBody long idAdministrador) {
// 		init();
// 		for(int cont =0; cont< administradores.size(); cont++) {
// 			if (administradores.get(cont).getIdAdministrador() == idAdministrador) {
// 				administradores.remove(cont);
// 			}
// 		}
// 	}
	
	
	
	
// 	@PostMapping("/dg-cadastra-cliente")
// 	public void dg_cadastra_cliente(@RequestBody Cliente cliente){
// 		init();
// 		cliente.setIdCliente(clientes.size()+1);
// 		clientes.add(cliente);
// 	}
// 	@GetMapping("/dg-lista-cliente")
// 	public List<Cliente> dg_lista_cliente(){
// 		init();
// 		return clientes;
// 	}
// 	@PostMapping("/dg-deleta-cliente")
// 	public void dg_deleta_cliente(@RequestBody long idCliente) {
// 		init();
// 		for(int cont =0; cont< clientes.size(); cont++) {
// 			if (clientes.get(cont).getIdCliente() == idCliente) {
// 				clientes.remove(cont);
// 			}
// 		}
// 	}
	
	
	
	
// 	@PostMapping("/dg-cadastra-produto")
// 	public void dg_cadastra_produto(@RequestBody Produto produto){
// 		init();
// 		System.out.println("NOME PRODUTO:"+produto.getNomeProduto());
// 		produto.setIdProduto(produtos.size()+1);
// 		produtos.add(produto);
// 	}
// 	@GetMapping("/dg-lista-produto")
// 	public List<Produto> dg_lista_produto(){
// 		init();
// 		return produtos;
// 	}
// 	@PostMapping("/dg-deleta-produto")
// 	public void dg_deleta_produto(@RequestBody long idProduto) {
// 		init();
// 		for(int cont =0; cont< produtos.size(); cont++) {
// 			if (produtos.get(cont).getIdProduto() == idProduto) {
// 				produtos.remove(cont);
// 			}
// 		}
// 	}
	
	
	
	
// 	@PostMapping("/dg-cadastra-venda")
// 	public void venda(@RequestBody Venda venda){
// 		init();
// 		List<Produto> listaProdutos = produtos;
// 		List<Cliente> listaClientes = clientes;
// 		for(int cont = 0; cont < listaProdutos.size(); cont++){
// 			if(listaProdutos.get(cont).getNomeProduto().equals(venda.getNomeEstrangeiroProduto())){
// 				venda.setIdEstrangeiroProduto(listaProdutos.get(cont).getIdProduto());
// 			}
// 		}
// 		for(int cont = 0; cont < listaClientes.size(); cont++){
// 			if(listaClientes.get(cont).getNomeCliente().equals(venda.getNomeEstrangeiroCliente())){
// 				venda.setIdEstrangeiroCliente(listaClientes.get(cont).getIdCliente());
// 			}
// 		}
// 		venda.setIdVenda(vendas.size()+1);
// 		vendas.add(venda);
// 	}
// 	@GetMapping("/dg-lista-venda")
// 	public List<Venda> dg_lista_venda(){
// 		init();
// 		return vendas;
// 	}
// 	@PostMapping("/dg-deleta-venda")
// 	public void dg_deleta_venda(@RequestBody long idVenda) {
// 		init();
// 		for(int cont =0; cont< vendas.size(); cont++) {
// 			if (vendas.get(cont).getIdVenda() == idVenda) {
// 				vendas.remove(cont);
// 			}
// 		}
// 	}
	
	
	
	
// 	@PostMapping("/dg-cadastra-servico")
// 	public void dg_cadastra_servico(@RequestBody Servico servico){
// 		init();
// 		List<Administrador> listaAdministradores = administradores;
// 		List<Cliente> listaClientes = clientes;
// 		for(int cont = 0; cont < listaAdministradores.size(); cont++){
// 			if(listaAdministradores.get(cont).getNomeAdministrador().equals(servico.getNomeEstrangeiroAdministrador())){
// 				servico.setIdEstrangeiroAdministrador(listaAdministradores.get(cont).getIdAdministrador());
// 			}
// 		}
// 		for(int cont = 0; cont < listaClientes.size(); cont++){
// 			if(listaClientes.get(cont).getNomeCliente().equals(servico.getNomeEstrangeiroCliente())){
// 				servico.setIdEstrangeiroCliente(listaClientes.get(cont).getIdCliente());
// 			}
// 		}
// 		servico.setIdServico(servicos.size()+1);
// 		servicos.add(servico);
// 	}
// 	@GetMapping("/dg-lista-servico")
// 	public List<Servico> dg_lista_servico(){
// 		init();
// 		return servicos;
// 	}
// 	@PostMapping("/dg-deleta-servico")
// 	public void dg_deleta_servico(@RequestBody long idServico) {
// 		init();
// 		for(int cont =0; cont< servicos.size(); cont++) {
// 			if (servicos.get(cont).getIdServico() == idServico) {
// 				servicos.remove(cont);
// 			}
// 		}
// 	}
	
	
	
	
// 	@PostMapping("/dg-login-administrador")
//     public Administrador loginAdministrador(@RequestBody Administrador administrador){
// 		init();
// 		System.out.println("USERNAME: "+administrador.getUsernameAdministrador());
// 		System.out.println("PASSWORD: "+administrador.getPasswordAdministrador());
// 		List<Administrador> listaAdministrador = administradores;
//         for(int cont = 0; cont < listaAdministrador.size(); cont++) {
// 			if(listaAdministrador.get(cont).getIdAdministrador() != 0) {
// 				if(listaAdministrador.get(cont).getUsernameAdministrador().equals(administrador.getUsernameAdministrador())&&
// 				listaAdministrador.get(cont).getPasswordAdministrador().equals(administrador.getPasswordAdministrador())) {
// 						return listaAdministrador.get(cont);
// 				}
// 			}
// 		}
// 		Administrador administrador1 = new Administrador();
// 		return administrador1;
//     }
	
// 	@GetMapping("/dg-listar-produto-for-angular")
//     List<Produto> listarProdutoForAngular(){
// 		init();
//         List<Produto> listaProdutos = produtos;
// 		for(int cont = 0; cont < listaProdutos.size(); cont++){
// 			if(listaProdutos.get(cont).getImagem() != null){
// 				listaProdutos.get(cont).setPathImagemProduto(convertByteToString64(listaProdutos.get(cont).getImagem()));
// 				listaProdutos.get(cont).setImagem(null);
// 			}
// 		}
// 		return listaProdutos;
//     }
// 	public String convertByteToString64(byte[] bytesImagem){
// 		if(bytesImagem != null){
// 			return "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(bytesImagem);
// 		}
// 		else{
// 			return null;
// 		}
// 	}
	
// 	@PostMapping("/dg-listar-servico-cliente")
// 	List<Servico> listarServicoCliente(@RequestBody long idCliente){
// 		init();
// 		List<Servico> listaServico = servicos;
// 		List<Servico> listaServicoFim = new ArrayList<Servico>();
	
// 		for(int cont = 0; cont < listaServico.size(); cont++){
// 			if(listaServico.get(cont).getIdEstrangeiroCliente() != 0){
// 				if(listaServico.get(cont).getIdEstrangeiroCliente() == idCliente){
// 					listaServicoFim.add(listaServico.get(cont));
// 				}
// 			}
// 		}
// 		return listaServicoFim;
// 	}
// 	@PostMapping("/dg-listar-servico-administrador")
// 	List<Servico> listarServicoAdministrador(@RequestBody long idAdministrador){
// 		init();
// 		List<Servico> listaServico = servicos;
// 		List<Servico> listaServicoFim = new ArrayList<Servico>();
	
// 		for(int cont = 0; cont < listaServico.size(); cont++){
// 			if(listaServico.get(cont).getIdEstrangeiroAdministrador() != 0){
// 				if(listaServico.get(cont).getIdEstrangeiroAdministrador() == idAdministrador){
// 					listaServicoFim.add(listaServico.get(cont));
// 				}
// 			}
// 		}
// 		return listaServicoFim;
// 	}


// 	@PostMapping("/dg-listar-venda-cliente")
// 	List<Venda> listarVendaCliente(@RequestBody long idCliente){
// 		init();
// 		List<Venda> listaVenda = vendas;
// 		List<Venda> listaVendaFim = new ArrayList<Venda>();
// 		for(int cont = 0; cont < listaVenda.size(); cont++){
// 			if(listaVenda.get(cont).getIdEstrangeiroCliente() != 0){
// 				if(listaVenda.get(cont).getIdEstrangeiroCliente() == idCliente){
// 					listaVendaFim.add(listaVenda.get(cont));
// 				}
// 			}
// 		}
// 		return listaVendaFim;
// 	}
// 	@PostMapping("/dg-listar-venda-produto")
// 	List<Venda> listarVendaproduto(@RequestBody long idProduto){
// 		init();
// 		List<Venda> listaVenda = vendas;
// 		List<Venda> listaVendaFim = new ArrayList<Venda>();
// 		for(int cont = 0; cont < listaVenda.size(); cont++){
// 			if(listaVenda.get(cont).getIdEstrangeiroProduto() != 0){
// 				if(listaVenda.get(cont).getIdEstrangeiroProduto() == idProduto){
// 					listaVendaFim.add(listaVenda.get(cont));
// 				}
// 			}
// 		}
// 		return listaVendaFim;
// 	}



// 	@PostMapping("/dg-exibir-cliente-especifico")
// 	Cliente exibirClienteEspecifico(@RequestBody long idCliente){
// 		init();
// 		List<Cliente> listaCliente = clientes;
// 		Cliente cliente = new Cliente();
// 		for(int cont = 0; cont < listaCliente.size(); cont++){
// 			if(listaCliente.get(cont).getIdCliente() != 0){
// 				if(listaCliente.get(cont).getIdCliente() == idCliente){
// 					cliente = listaCliente.get(cont);
// 				}
// 			}
// 		}
// 		return cliente;
// 	}
// 	@PostMapping("/dg-exibir-administrador-especifico")
// 	Administrador exibirAdministradorEspecifico(@RequestBody long idAdministrador){
// 		init();
// 		List<Administrador> listaAdministrador = administradores;
// 		Administrador administrador = new Administrador();
// 		for(int cont = 0; cont < listaAdministrador.size(); cont++){
// 			if(listaAdministrador.get(cont).getIdAdministrador() != 0){
// 				if(listaAdministrador.get(cont).getIdAdministrador() == idAdministrador){
// 					administrador = listaAdministrador.get(cont);
// 				}
// 			}
// 		}
// 		return administrador;
// 	}
// 	@PostMapping("/dg-exibir-produto-especifico")
// 	Produto exibirProdutoEspecifico(@RequestBody long idProduto){
// 		init();
// 		List<Produto> listaProduto = produtos;
// 		Produto produto = new Produto();
// 		for(int cont = 0; cont < listaProduto.size(); cont++){
// 			if(listaProduto.get(cont).getIdProduto() != 0){
// 				if(listaProduto.get(cont).getIdProduto() == idProduto){
// 					produto = listaProduto.get(cont);
// 				}
// 			}
// 		}
// 		return produto;
// 	}
// }
