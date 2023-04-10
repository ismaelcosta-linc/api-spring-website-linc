package com.APIwebsitelinc.ControllerAdministrador;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.APIwebsitelinc.Model.Administrador;
import com.APIwebsitelinc.Model.Cliente;
import com.APIwebsitelinc.Model.Produto;
import com.APIwebsitelinc.Model.Servico;
import com.APIwebsitelinc.Model.Venda;
import com.APIwebsitelinc.Service.AdministradorService;
import com.APIwebsitelinc.Service.ClienteService;
import com.APIwebsitelinc.Service.ProdutoService;
import com.APIwebsitelinc.Service.ServicoService;
import com.APIwebsitelinc.Service.VendaService;
import com.APIwebsitelinc.Storage.Disco;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class REST_Administrador {

    @Autowired
    public AdministradorService administradorService;
    @Autowired
	public ClienteService clienteService;
	@Autowired
	public ProdutoService produtoService;
	@Autowired
	public VendaService vendaService;
	@Autowired
	public ServicoService servicoService;
	@Autowired
	public Disco disco;
	public String algoGlobal;
	public Produto produtoGlobal;

    @PostMapping("/login-administrador")
    public Administrador loginAdministrador(@RequestBody Administrador administrador){

		List<Administrador> listaAdministrador = administradorService.findAllAdministrador();

        for(int cont = 0; cont < listaAdministrador.size(); cont++) {
			if(listaAdministrador.get(cont).getIdAdministrador() != 0) {
				if(listaAdministrador.get(cont).getUsernameAdministrador().equals(administrador.getUsernameAdministrador())&&
				listaAdministrador.get(cont).getPasswordAdministrador().equals(administrador.getPasswordAdministrador())) {
						
						return listaAdministrador.get(cont);
				}
			}
		}
		Administrador administrador1 = new Administrador();
		return administrador1;
    }


    
    @PostMapping("/cadastrar-administrador")
	void cadastrarAdministrador(@RequestBody Administrador administrador) {
		administradorService.save(administrador);
	}
    @GetMapping("/listar-administrador")
    List<Administrador> listarAdministrador(){
        return administradorService.findAllAdministrador();
    }
	@PostMapping("/deletar-administrador")
	void deletarAdministrador(@RequestBody long idAdministrador){
	//	administradorService.removeByAdministrador(administradorService.findByIdAdministrador(idAdministrador));
		administradorService.deleteByIdAdministrador(idAdministrador);
	}


	@PostMapping("/adm-cadastrar-cliente")
	void cadastrarCliente(@RequestBody Cliente cliente) {
		clienteService.save(cliente);
	}
    @GetMapping("/listar-cliente")
    List<Cliente> listarCliente(){
        return clienteService.findAllClientes();
    }
	@PostMapping("/deletar-cliente")
	void deletarCliente(@RequestBody long idCliente){
	//	clienteService.removeByCliente(clienteService.findByIdCliente(idCliente));
		clienteService.deleteByIdCliente(idCliente);
	}


    @PostMapping("/cadastrar-produto")
	void cadastrarProduto(@RequestBody Produto produto) {
		produtoService.save(produto);
	}
//	@PostMapping("/cadastrar-algo-1")
//	void cadastrarProduto1(@RequestBody MultipartFile file) throws IOException{
//		// try {
//		// 	//produto.setImagem(file.getBytes());
//		// 	this.algoGlobal = file.getBytes();
//		// } catch (IOException e) {
//		// 	e.printStackTrace();
//		// }
//	}
//	@PostMapping("/cadastrar-algo-2")
//	void cadastrarProduto2(@RequestBody Produto produto) throws IOException{
//		// try {
//			//produto.setImagem(file.getBytes());
//			this.produtoGlobal = produto;
//		// } catch (IOException e) {
//		// 	e.printStackTrace();
//		// }
//	}
//	@PostMapping("/recebe-algo")
//	void recebeAlgo(@RequestBody String nome){
//		this.algoGlobal = nome;
//	}
//	@GetMapping("/consulta-algo")
//	String consultaAlgo(){
//		return this.algoGlobal;
//	}
//	@GetMapping("/consulta-produto")
//	Produto consultaProduto(){
//		return this.produtoGlobal;
//	}
//	@PostMapping("/cadastrar-imagem-externa")
//	void cadastrarImagem(@RequestBody MultipartFile imagem) {
//		disco.salvarFoto(imagem);
//	}
    @GetMapping("/listar-produto")
    List<Produto> listarProduto(){
        return produtoService.findAllProdutos();
    }
	@GetMapping("/listar-produto-for-angular")
    List<Produto> listarProdutoForAngular(){
        List<Produto> listaProdutos = produtoService.findAllProdutos();

		for(int cont = 0; cont < listaProdutos.size(); cont++){
			if(listaProdutos.get(cont).getImagem() != null){
				listaProdutos.get(cont).setPathImagemProduto(convertByteToString64(listaProdutos.get(cont).getImagem()));
				listaProdutos.get(cont).setImagem(null);
			}
		}
		return listaProdutos;
    }
	@PostMapping("/deletar-produto")
	void deletarProduto(@RequestBody long idProduto){
		produtoService.deleteByIdProduto(idProduto);
	}

	public String convertByteToString64(byte[] bytesImagem){

		if(bytesImagem != null){
			return "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(bytesImagem);
		}
		else{
			return null;
		}
	}

	// @PostMapping("/imagem-produto")
	// public String exibir_imagem_produto_angular_get(@RequestBody long idProduto){

	// 	Produto produto = produtoService.findByIdProduto(idProduto);

	// 	if(produto.getImagem() != null){
	// 		return "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(produto.getImagem());
	// 	}
	// 	else{
	// 		return null;
	// 	}
	// }



	// @PostMapping("/imagem-produto")
	// //@ResponseBody
	// public byte[] exibir_imagem_produto_angular_get(@RequestBody long idProduto) {
		
	// 	Produto produto1 = produtoService.findByIdProduto(idProduto);
	// 	return produto1.getImagem();
	// }

	// @PostMapping("/ByteUrl")
	// public String getBase64Image(@RequestBody long idProduto){

	// 	Produto produto1 = produtoService.findByIdProduto(idProduto);
	// 	byte[] myImage = produto1.getImagem();

	// 	if(myImage != null){
	// 		return "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(myImage);
    //     }
    //     else{
    //         return null;
    //     }
	// }



    @PostMapping("/cadastrar-servico")
	void cadastrarServico(@RequestBody Servico servico) {

		List<Administrador> listaAdministradores = administradorService.findAllAdministrador();
		List<Cliente> listaClientes = clienteService.findAllClientes();

		for(int cont = 0; cont < listaAdministradores.size(); cont++){
			if(listaAdministradores.get(cont).getNomeAdministrador().equals(servico.getNomeEstrangeiroAdministrador())){
				System.out.println("O VALOR PROCURADO É: "+ listaAdministradores.get(cont).getIdAdministrador());
				servico.setIdEstrangeiroAdministrador(listaAdministradores.get(cont).getIdAdministrador());
			}
		}
		for(int cont = 0; cont < listaClientes.size(); cont++){
			if(listaClientes.get(cont).getNomeCliente().equals(servico.getNomeEstrangeiroCliente())){
				servico.setIdEstrangeiroCliente(listaClientes.get(cont).getIdCliente());
			}
		}
		servicoService.save(servico);

	}
    @GetMapping("/listar-servico")
    List<Servico> listarServico(){
        return servicoService.findAllServicos();
    }
	@PostMapping("/deletar-servico")
	void deletarServico(@RequestBody long idServico){
	//	servicoService.removeByServico(servicoService.findByIdServico(idServico));
		servicoService.deleteByIdServico(idServico);
	}



	@PostMapping("/cadastrar-venda")
	void cadastrarVenda(@RequestBody Venda venda) {

		List<Produto> listaProdutos = produtoService.findAllProdutos();
		List<Cliente> listaClientes = clienteService.findAllClientes();

		for(int cont = 0; cont < listaProdutos.size(); cont++){
			if(listaProdutos.get(cont).getNomeProduto().equals(venda.getNomeEstrangeiroProduto())){
				System.out.println("O VALOR PROCURADO É: "+ listaProdutos.get(cont).getIdProduto());
				venda.setIdEstrangeiroProduto(listaProdutos.get(cont).getIdProduto());
			}
		}
		for(int cont = 0; cont < listaClientes.size(); cont++){
			if(listaClientes.get(cont).getNomeCliente().equals(venda.getNomeEstrangeiroCliente())){
				venda.setIdEstrangeiroCliente(listaClientes.get(cont).getIdCliente());
			}
		}
		vendaService.save(venda);

	}
	@GetMapping("/listar-venda")
    List<Venda> listarVenda(){
        return vendaService.findAllVenda();
    }
	@PostMapping("/deletar-venda")
	void deletarVenda(@RequestBody long idVenda){
	//	servicoService.removeByServico(servicoService.findByIdServico(idServico));
		vendaService.deleteByIdVenda(idVenda);
	}



	@PostMapping("/listar-servico-cliente")
	List<Servico> listarServicoCliente(@RequestBody long idCliente){

		List<Servico> listaServico = servicoService.findAllServicos();
		List<Servico> listaServicoFim = new ArrayList<Servico>();
	
		for(int cont = 0; cont < listaServico.size(); cont++){
			if(listaServico.get(cont).getIdEstrangeiroCliente() != 0){
				if(listaServico.get(cont).getIdEstrangeiroCliente() == idCliente){
					listaServicoFim.add(listaServico.get(cont));
				}
			}
		}
		return listaServicoFim;
	}
	@PostMapping("/listar-servico-administrador")
	List<Servico> listarServicoAdministrador(@RequestBody long idAdministrador){

		List<Servico> listaServico = servicoService.findAllServicos();
		List<Servico> listaServicoFim = new ArrayList<Servico>();
	
		for(int cont = 0; cont < listaServico.size(); cont++){
			if(listaServico.get(cont).getIdEstrangeiroAdministrador() != 0){
				if(listaServico.get(cont).getIdEstrangeiroAdministrador() == idAdministrador){
					listaServicoFim.add(listaServico.get(cont));
				}
			}
		}
		return listaServicoFim;
	}



	@PostMapping("/listar-venda-cliente")
	List<Venda> listarVendaCliente(@RequestBody long idCliente){

		List<Venda> listaVenda = vendaService.findAllVenda();
		List<Venda> listaVendaFim = new ArrayList<Venda>();
	
		for(int cont = 0; cont < listaVenda.size(); cont++){
			if(listaVenda.get(cont).getIdEstrangeiroCliente() != 0){
				if(listaVenda.get(cont).getIdEstrangeiroCliente() == idCliente){
					listaVendaFim.add(listaVenda.get(cont));
				}
			}
		}
		return listaVendaFim;
	}
	@PostMapping("/listar-venda-produto")
	List<Venda> listarVendaproduto(@RequestBody long idProduto){

		List<Venda> listaVenda = vendaService.findAllVenda();
		List<Venda> listaVendaFim = new ArrayList<Venda>();
	
		for(int cont = 0; cont < listaVenda.size(); cont++){
			if(listaVenda.get(cont).getIdEstrangeiroProduto() != 0){
				if(listaVenda.get(cont).getIdEstrangeiroProduto() == idProduto){
					listaVendaFim.add(listaVenda.get(cont));
				}
			}
		}
		return listaVendaFim;
	}



	@PostMapping("/exibir-cliente-especifico")
	Cliente exibirClienteEspecifico(@RequestBody long idCliente){

		List<Cliente> listaCliente = clienteService.findAllClientes();
		Cliente cliente = new Cliente();

		for(int cont = 0; cont < listaCliente.size(); cont++){
			if(listaCliente.get(cont).getIdCliente() != 0){
				if(listaCliente.get(cont).getIdCliente() == idCliente){
					cliente = listaCliente.get(cont);
				}
			}
		}
		return cliente;
	}
	@PostMapping("/exibir-administrador-especifico")
	Administrador exibirAdministradorEspecifico(@RequestBody long idAdministrador){

		List<Administrador> listaAdministrador = administradorService.findAllAdministrador();
		Administrador administrador = new Administrador();

		for(int cont = 0; cont < listaAdministrador.size(); cont++){
			if(listaAdministrador.get(cont).getIdAdministrador() != 0){
				if(listaAdministrador.get(cont).getIdAdministrador() == idAdministrador){
					administrador = listaAdministrador.get(cont);
				}
			}
		}
		return administrador;
	}
	@PostMapping("/exibir-produto-especifico")
	Produto exibirProdutoEspecifico(@RequestBody long idProduto){

		List<Produto> listaProduto = produtoService.findAllProdutos();
		Produto produto = new Produto();

		for(int cont = 0; cont < listaProduto.size(); cont++){
			if(listaProduto.get(cont).getIdProduto() != 0){
				if(listaProduto.get(cont).getIdProduto() == idProduto){
					produto = listaProduto.get(cont);
				}
			}
		}
		return produto;
	}

	// @GetMapping("/imagem-produto-api")
	// @ResponseBody
	// public byte[] exibir_imagem_produto_rest_get(@RequestBody long idProduto) {
		
	// 	Produto produto1 = produtoService.findByIdProduto(idProduto);
	// 	return produto1.getImagem();
	// }



	// @PostMapping("/imagem-produto-api")
	// // @ResponseBody
	// public void exibir_imagem_produto_rest_get(@RequestBody long idProduto) throws IOException {
		
	// 	Produto produto1 = produtoService.findByIdProduto(idProduto);

	// 	ByteArrayInputStream inStreambj = new ByteArrayInputStream(produto1.getImagem());
	// 	BufferedImage newImage = ImageIO.read(inStreambj);

	// 	ImageIO.write(newImage, "jpg", new File("/tmp/website-linc/fileout.jpg"));

	// 	File outputfile = new File("/tmp/website-linc/outputImage9.jpg");
	// 	ImageIO.write(newImage, "jpg", outputfile);
	// }



	// @RequestMapping(value = "/imagem-produto" ,method = RequestMethod.GET)
	// public ResponseEntity<byte[]> imagemDoProduto2(@RequestBody long idProduto) throws IOException{

	// 	byte[] image = produtoService.findByIdProduto(idProduto).getImagem();
	// 	String fileName = "produto" + idProduto + ".jpg";

	// 	HttpHeaders responseHeaders = httpHeaderImageFile(fileName, image.length);
	// 	return new ResponseEntity<byte[]>(image, responseHeaders, HttpStatus.OK);
	// }

	// public static HttpHeaders httpHeaderImageFile(final String fileName, final int fileSize){
	// 	String encodedFileName = fileName.replace('"', ' ').replace(' ', '_');

	// 	HttpHeaders responseHeaders = new HttpHeaders();
	// 	responseHeaders.setContentType(MediaType.parseMediaType("image/jpeg"));
    //     responseHeaders.setContentLength(fileSize);
    //     responseHeaders.add("Content-Disposition", "filename=\"" + encodedFileName + '\"');
    //     return responseHeaders;
	// }



	// @RequestMapping(value = "/produtos/{id}/imagem", method = RequestMethod.GET)
    // public ResponseEntity<byte[]> imagemDoProduto(@PathVariable("id") Long id)
    //         throws IOException {
    //     byte[] image = produtoService.imagemDoProduto(id);
    //     String fileName = "produto" + id + ".jpg";
  
    //     HttpHeaders responseHeaders = httpHeaderImageFile(fileName, image.length);
    //     return new ResponseEntity<byte[]>(image,
    //                                       responseHeaders, HttpStatus.OK);
    // }
  
    // // setando os headers
    // public static HttpHeaders httpHeaderImageFile(final String fileName, final int fileSize) {
    //     String encodedFileName = fileName.replace('"', ' ').replace(' ', '_');
  
    //     HttpHeaders responseHeaders = new HttpHeaders();
    //     responseHeaders.setContentType(MediaType.parseMediaType("image/jpeg"));
    //     responseHeaders.setContentLength(fileSize);
    //     responseHeaders.add("Content-Disposition", "filename=\"" + encodedFileName + '\"');
    //     return responseHeaders;
    // }
}
