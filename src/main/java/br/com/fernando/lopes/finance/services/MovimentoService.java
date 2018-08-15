package br.com.fernando.lopes.finance.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.fernando.lopes.finance.dto.MovimentoDTO;
import br.com.fernando.lopes.finance.entities.Conta;
import br.com.fernando.lopes.finance.entities.Movimento;
import br.com.fernando.lopes.finance.reposirories.ContaRepository;
import br.com.fernando.lopes.finance.reposirories.MovimentoRepository;

@Service
public class MovimentoService {
	
	@Autowired
	private MovimentoRepository repo;
	
	@Autowired
	private ContaRepository contaRepository;
	
	public Movimento find(Integer id) {
		Optional<Movimento> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public Movimento insert(Movimento obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Movimento update(Movimento obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		try {
			find(id);
			repo.deleteById(id);
			
		} catch (DataIntegrityViolationException e) {
			
			throw new DataIntegrityViolationException("Não é possível Excluir uma Movimento que possui lançamento");
			
		}
	}
	
	public List<Movimento> findAll(){
		return repo.findAll();
	}
	
	public Page<Movimento> findPage(Integer page, Integer linesPerPage, String orderBy, String direction ){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	/*
	 * Converte um objDto para obj comum 
	 */
	
	public Movimento fromDTO(MovimentoDTO objDto) {
		
		Conta conta = (contaRepository.findById(objDto.getConta_id())).get();
		
		return new Movimento(null, objDto.getNome(), conta);
	}
	
}
