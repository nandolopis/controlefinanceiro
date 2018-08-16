package br.com.fernando.lopes.finance.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.fernando.lopes.finance.dto.LancamentoDTO;
import br.com.fernando.lopes.finance.entities.Lancamento;
import br.com.fernando.lopes.finance.reposirories.CategoriaRepository;
import br.com.fernando.lopes.finance.reposirories.LancamentoRepository;
import br.com.fernando.lopes.finance.reposirories.MovimentoRepository;

@Service
public class LancamentoService {
	
	@Autowired
	private LancamentoRepository repo;
	@Autowired
	private MovimentoRepository movimentoRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	
	public Lancamento find(Integer id) {
		Optional<Lancamento> obj =  repo.findById(id);
		return obj.orElse(null);
	}
	public Lancamento insert(Lancamento obj) {
		//obj.setId(null);
		return repo.save(obj);
	}
	
	public Lancamento update(Lancamento obj) {
		//find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		try {
			find(id);
			repo.deleteById(id);
			
		} catch (DataIntegrityViolationException e) {
			
			throw new DataIntegrityViolationException("Não é possível Excluir uma Lancamento que possui lançamento");
			
		}
	}
	
	public List<Lancamento> findAll(){
		return repo.findAll();
	}
	
	public Page<Lancamento> findPage(Integer page, Integer linesPerPage, String orderBy, String direction ){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	/*
	 * Converte um objDto para obj comum 
	 */
	
	public Lancamento fromDTO(LancamentoDTO objDto) {

		return new Lancamento(null, objDto.getNome(), 
									objDto.getValor(), 
									(categoriaRepository.findById(objDto.getCategoria_id())).get(), 
									(movimentoRepository.findById(objDto.getMovimento_id())).get(), 
									objDto.getStatus(),
									objDto.getTipo());
	}

}
