package com.devsuperior.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	
	/* Teste
	@Autowired
	private PasswordEncoder passwordEncoder; //como la na classe "SecurityConfig " foi utilizado a annotation "Bean"(componente) o proprio framword vai trazer a implementação(instancia) do BCryptPasswordEncoder[encripator])
	*/
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	/* Teste utilizando a criptografica para senhas de usuarios
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("ENCODE = " + passwordEncoder.encode("123456")); //testando criptografia de senha com BCryptPasswordEncoder injetado aqui para testes.
			//RETORNO NO CONSOLE: ENCODE = $2a$10$hgmM74oeD7n30MD0Sbo/VOEoBhbsMagczJIsk9XaxmFS7UHsrtxCG
		
		//isso é o que o framework faz por traz para validar se senha digitada pelo usuario é a mesma criptografada
		boolean result = passwordEncoder.matches("123456", "$2a$10$hgmM74oeD7n30MD0Sbo/VOEoBhbsMagczJIsk9XaxmFS7UHsrtxCG");
		System.out.println("RESULTADO IGUAL = " + result);
			//RETORNO NO CONSOLE: RESULTADO IGUAL = true
	}
	*/
	
	
	

}
