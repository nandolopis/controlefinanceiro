package br.com.fernando.lopes.finance;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.fernando.lopes.finance.entities.Banco;
import br.com.fernando.lopes.finance.entities.Categoria;
import br.com.fernando.lopes.finance.entities.Cliente;
import br.com.fernando.lopes.finance.entities.Conta;
import br.com.fernando.lopes.finance.entities.Movimento;
import br.com.fernando.lopes.finance.entities.tipos.ContaTipo;
import br.com.fernando.lopes.finance.reposirories.BancoRepository;
import br.com.fernando.lopes.finance.reposirories.CategoriaRepository;
import br.com.fernando.lopes.finance.reposirories.ClienteRepository;
import br.com.fernando.lopes.finance.reposirories.ContaRepository;
import br.com.fernando.lopes.finance.reposirories.MovimentoRepository;


/*
 * implements commandLineRummer 
 * é uma interface para executar comandos e estanciações no ato de
 * execução da aplicão 
 */
@SpringBootApplication
public class ControlefinanceApplication implements CommandLineRunner {
	
	//Dependencias 
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private BancoRepository bancoRepository;
	@Autowired
	private ContaRepository contaRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired 
	private MovimentoRepository movimentoRepository;
	
	
	//função main 
	public static void main(String[] args) {
		SpringApplication.run(ControlefinanceApplication.class, args);
	}
	
	
	//função run para a interface CommandLineRunner
	@Override
	public void run(String... args) throws Exception {
	
		
		Categoria cat1 = new Categoria(null,"Despesa Pessoal");
		Categoria cat2 = new Categoria(null, "Habitação");
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2)); 
		
		/*
		Calendar calendar = Calendar.getInstance();
		
		calendar.set(1988, Calendar.SEPTEMBER, 26);
		java.util.Date datadeaniversario = calendar.getTime();*/

		
		Cliente cli1 = new Cliente(null, 1, "Fernando Lopes", "nandolopes@gmail.com", "1234", LocalDate.of(1988, Month.SEPTEMBER, 26));
		
		Banco ba1 = new Banco(null, 001, "Caixa");
		
		Conta co1 = new Conta(null, "Corrente", ContaTipo.CONTACORRENT, ba1, cli1);
		
		cli1.getContas().addAll(Arrays.asList(co1));
		ba1.getContas().addAll(Arrays.asList(co1));
		
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		

		bancoRepository.saveAll(Arrays.asList(ba1));
		
		contaRepository.saveAll(Arrays.asList(co1));
		
		Movimento mov1 = new Movimento(null, "Janeiro", co1);
		
		movimentoRepository.saveAll(Arrays.asList(mov1));
		
		
		
		
		
	}
}
