package com.devsuperior.demo.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	//CONFIGURAÇÃO GLOBAL
	
	
	@Bean
	public PasswordEncoder getPasswordEncoder() { //Metodo de criptografica de senha, por exemplo a senha de usuario, ao inserir no banco será criptografada. foi utilizado a interfeca para não expor a implementação, essa é instanciada no retorno logo abaixo, exemplo de uma implementação dessa interface --> "BCryptPasswordEncoder" que aplica o algoritimo do decript
		return new BCryptPasswordEncoder();
	} 
	
	@Bean
	@Profile("test")
	@Order(1)
	SecurityFilterChain h2SecurityFilterChain(HttpSecurity http) throws Exception {

		http.securityMatcher(PathRequest.toH2Console()).csrf(csrf -> csrf.disable())
				.headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()));
		return http.build();
	}
	
	@Bean //indicação para componente de sistema
	@Order(2) // order 2 para que rode depois da aplicação do filtro do h2
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable()); //csrf(Ataque csrf) --> DESABILITADO PROTEÇÃO/SEGURAÇÃO DE GRAVAÇÃO DE DADOS NA SEÇÃO, API REST NÃO GRAVA DADO EM SEÇÃO
		http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll()); //[.permitAll()] --> ESSE É UM CONTROLE GLOBAL E ESTÁ TUDO LIBERADO PORQUE O CONTROLE/SEGURANÇA SERÁ POR ROTA. CONFIGURAÇÃO DA PERMISSÃO PARA OS ENDPOINS/REQUISIÇÃO. PEMITE ALL. [.permitAll()] PODE SER ALTERADO PARA PERTIRI ACESSAR SOMENTE QUE UM PERFIL ESPECIFICO, ALEM DE OUTRAS OPÇÕES DE CONTROLE DE ACESSO APENAS MUDANDO ESSE METODO
		return http.build();
	}

}
