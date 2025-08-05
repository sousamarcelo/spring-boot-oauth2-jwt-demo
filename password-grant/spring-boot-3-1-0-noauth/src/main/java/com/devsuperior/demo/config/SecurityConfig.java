package com.devsuperior.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	//CONFIGURAÇÃO GLOBAL
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable()); //csrf(Ataque csrf) --> DESABILITADO PROTEÇÃO/SEGURAÇÃO DE GRAVAÇÃO DE DADOS NA SEÇÃO, API REST NÃO GRAVA DADO EM SEÇÃO
		http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll()); //[.permitAll()] --> ESSE É UM CONTROLE GLOBAL E ESTÁ TUDO LIBERADO PORQUE O CONTROLE/SEGURANÇA SERÁ POR ROTA. CONFIGURAÇÃO DA PERMISSÃO PARA OS ENDPOINS/REQUISIÇÃO. PEMITE ALL. [.permitAll()] PODE SER ALTERADO PARA PERTIRI ACESSAR SOMENTE QUE UM PERFIL ESPECIFICO, ALEM DE OUTRAS OPÇÕES DE CONTROLE DE ACESSO APENAS MUDANDO ESSE METODO
		return http.build();
	}

}
