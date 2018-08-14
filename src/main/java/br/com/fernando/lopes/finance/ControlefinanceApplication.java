package br.com.fernando.lopes.finance;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.fernando.lopes.finance.entities.Banco;
import br.com.fernando.lopes.finance.entities.Categoria;
import br.com.fernando.lopes.finance.entities.Cliente;
import br.com.fernando.lopes.finance.entities.Conta;
import br.com.fernando.lopes.finance.entities.Lancamento;
import br.com.fernando.lopes.finance.entities.Movimento;
import br.com.fernando.lopes.finance.entities.tipos.ContaTipo;
import br.com.fernando.lopes.finance.entities.tipos.LancamentoTipo;
import br.com.fernando.lopes.finance.entities.tipos.StatusMovimento;
import br.com.fernando.lopes.finance.reposirories.BancoRepository;
import br.com.fernando.lopes.finance.reposirories.CategoriaRepository;
import br.com.fernando.lopes.finance.reposirories.ClienteRepository;
import br.com.fernando.lopes.finance.reposirories.ContaRepository;
import br.com.fernando.lopes.finance.reposirories.LancamentoRepository;
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
	
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@Autowired
	private BCryptPasswordEncoder bc;
	
	
	//função main 
	public static void main(String[] args) {
		SpringApplication.run(ControlefinanceApplication.class, args);
	}
	
	
	//função run para a interface CommandLineRunner
	@Override
	public void run(String... args) throws Exception {
	
		
		Categoria cat1 = new Categoria(null,"Alimentação");
		Categoria cat2 = new Categoria(null, "Despesas pessoais");
		Categoria cat3 = new Categoria(null, "Dividas");
		Categoria cat4 = new Categoria(null, "Educação");
		Categoria cat5 = new Categoria(null, "Imposto e taxas");
		Categoria cat6 = new Categoria(null, "Lazer");
		Categoria cat7 = new Categoria(null, "Habitação");
		Categoria cat8 = new Categoria(null, "Outros");
		Categoria cat9 = new Categoria(null, "Renda");
		Categoria cat10 = new Categoria(null, "Saúde");
		Categoria cat11 = new Categoria(null, "Transporte");
		
		
		categoriaRepository.saveAll(Arrays.asList(cat1,
												  cat2,
												  cat3,
												  cat4,
												  cat5,
												  cat6,
												  cat7,
												  cat8,
												  cat9,
												  cat10,
												  cat11)); 
		
		/*
		Calendar calendar = Calendar.getInstance();
		
		calendar.set(1988, Calendar.SEPTEMBER, 26);
		java.util.Date datadeaniversario = calendar.getTime();*/

		
		Cliente cli1 = new Cliente(null, 1, "Fernando Lopes", "nandolopes@gmail.com", bc.encode("1234"), LocalDate.of(1988, Month.SEPTEMBER, 26));
		
		Banco ba1 = new Banco(null, 001, "Caixa");
		
		Conta co1 = new Conta(null, "Corrente", ContaTipo.CONTACORRENT, ba1, cli1);
		
		cli1.getContas().addAll(Arrays.asList(co1));
		ba1.getContas().addAll(Arrays.asList(co1));
		
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		

		bancoRepository.saveAll(Arrays.asList(ba1));
		
		contaRepository.saveAll(Arrays.asList(co1));
		
		Movimento mov1 = new Movimento(null, "Janeiro", co1);
		
		movimentoRepository.saveAll(Arrays.asList(mov1));
		
		Lancamento lan1 = new Lancamento(mov1, "LUZ", 100.00D, cat2, StatusMovimento.PAGO,LancamentoTipo.SAIDA);
		Lancamento lan2 = new Lancamento(mov1, "salario", 900.00D, cat1, StatusMovimento.RECEBIDO,LancamentoTipo.ENTRADA);
		Lancamento lan3 = new Lancamento(mov1, "agua", 90.00D, cat2, StatusMovimento.ATRASO, LancamentoTipo.SAIDA);
		
		lancamentoRepository.saveAll(Arrays.asList(lan1, lan2, lan3));
		
		
		
		
		
	}
}
