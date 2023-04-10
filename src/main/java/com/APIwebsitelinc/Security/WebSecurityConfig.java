//package com.APIwebsitelinc.Security;
//
//import javax.annotation.Resource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
//	
//	@Autowired
//    private ImplementsUserDetailsService implementsUserDetailsService;
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception{
////		http
////			.csrf().disable().authorizeRequests()/*<- Informa que EU quero fazer as definições de segurança do sistema*/
////			.antMatchers(HttpMethod.GET, "/","/cadastro","/login","/sobre","/reparacao-de-dispositivos","/suporte-servico-tecnico-informatica"
////					,"/criacao-desenvolvimento-sistemas","/loja","/iten-venda/{idProduto}","/finalizar-compra","/imagem/{idProduto}","/RESTadministradores","/users").permitAll()
////			.antMatchers(HttpMethod.POST, "/","/cadastro","/login","/sobre","/reparacao-de-dispositivos","/suporte-servico-tecnico-informatica"
////					,"/criacao-desenvolvimento-sistemas","/loja","/iten-venda/{idProduto}","/finalizar-compra","/imagem/{idProduto}","/users").permitAll()
////			/*.antMatchers("/cadastrar-novo-cliente").hasAnyRole("MASTER")
////			.antMatchers("cadastrar-novo-servico").hasAnyRole("ADMINISTRADOR")
////			.antMatchers("cadastrar-novo-produto").hasAnyRole("CLIENTE")<- Nessas tres eu defino permicoes de acesso*/
////			.anyRequest().authenticated()/*<- Informo que para qualquer requisição é precio estar Authenticado*/
////			.and().formLogin()/*<- Informo que quero que a autenticação seja feita através do formulário de login*/
////				.loginPage("/login-administrador")/*<- Informo que tenho minha propria página de login*/
////				.defaultSuccessUrl("/administrador", true)//<- redireciona para a página /administrador apos autenticação
////				.permitAll()/*<- Informo que permita o acessa a pagina de login*/
////			.and().logout()
////				.logoutSuccessUrl("/logout-administrador")
////				.permitAll();
//		
//		http
//		.csrf().disable().authorizeRequests()/*<- Informa que EU quero fazer as definições de segurança do sistema*/
//		.antMatchers(HttpMethod.GET, "/","/login","/loja", "/confere-login","/limpa-login","/cadastrar-cliente").permitAll()
//		.antMatchers(HttpMethod.POST, "/","/login","/cadastrar-cliente","/loja","/confere-login").permitAll()
//		/*.antMatchers("/cadastrar-novo-cliente").hasAnyRole("MASTER")
//		.antMatchers("cadastrar-novo-servico").hasAnyRole("ADMINISTRADOR")
//		.antMatchers("cadastrar-novo-produto").hasAnyRole("CLIENTE")<- Nessas tres eu defino permicoes de acesso*/
//		.anyRequest().authenticated()/*<- Informo que para qualquer requisição é precio estar Authenticado*/
//		.and().formLogin()/*<- Informo que quero que a autenticação seja feita através do formulário de login*/
//			.loginPage("/login-administrador")/*<- Informo que tenho minha propria página de login*/
//			.defaultSuccessUrl("/administrador", true)//<- redireciona para a página /administrador apos autenticação
//			.permitAll()/*<- Informo que permita o acessa a pagina de login*/
//		.and().logout()
//			.logoutSuccessUrl("/logout-administrador")
//			.permitAll();
//	}
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//		auth.userDetailsService(implementsUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
//	}
//	
//	@Override
//    @Bean
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//	
//	@Override
//	public void configure(WebSecurity web) throws Exception{
//		web.ignoring().antMatchers("/static/**", "/assets/**", "/css/**", "/js/**");
//	}
//}
