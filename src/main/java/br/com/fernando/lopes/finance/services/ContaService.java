package br.com.fernando.lopes.finance.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.fernando.lopes.finance.dto.ContaDTO;
import br.com.fernando.lopes.finance.entities.Banco;
import br.com.fernando.lopes.finance.entities.Cliente;
import br.com.fernando.lopes.finance.entities.Conta;
import br.com.fernando.lopes.finance.reposirories.BancoRepository;
import br.com.fernando.lopes.finance.reposirories.ClienteRepository;
import br.com.fernando.lopes.finance.reposirories.ContaRepository;

@Service
public class ContaService {
	
	@Autowired
	private ContaRepository repo;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private BancoRepository bancoRepository;
	
	
	public Conta find(Integer id) {
		Optional<Conta> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public Conta insert(Conta obj) {
		//obj.setId(null);
		return repo.save(obj);
	}
	
	public Conta update(Conta obj) {
		//find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		try {
			find(id);
			repo.deleteById(id);
			
		} catch (DataIntegrityViolationException e) {
			
			throw new DataIntegrityViolationException("Não é possível Excluir uma Conta que possui lançamento");
			
		}
	}
	
	public List<Conta> findAll(){
		return repo.findAll();
	}
	
	public Page<Conta> findPage(Integer page, Integer linesPerPage, String orderBy, String direction ){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	/*
	 * Converte um objDto para obj comum 
	 */
	
	public Conta fromDTO(ContaDTO objDto) {
		Cliente cli = (clienteRepository.findById(objDto.getCliente_id())).get();
		Banco banc = (bancoRepository.findById(objDto.getBanco_id())).get();

		return new Conta(null, objDto.getNome(), objDto.getTipoconta(),banc, cli);
	}


}
