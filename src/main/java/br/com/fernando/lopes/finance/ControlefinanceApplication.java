package br.com.fernando.lopes.finance;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * implements commandLineRummer 
 * é uma interface para executar comandos e estanciações no ato de
 * execução da aplicão 
 */
@SpringBootApplication
public class ControlefinanceApplication implements CommandLineRunner {
	
	
	
	
	//função main 
	public static void main(String[] args) {
		SpringApplication.run(ControlefinanceApplication.class, args);
	}
	
	
	//função run para a interface CommandLineRunner
	@Override
	public void run(String... args) throws Exception {

	}
}
