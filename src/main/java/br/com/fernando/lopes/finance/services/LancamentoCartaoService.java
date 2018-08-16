package br.com.fernando.lopes.finance.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.fernando.lopes.finance.dto.LancamentoCartaoDTO;
import br.com.fernando.lopes.finance.entities.LancamentoCartao;
import br.com.fernando.lopes.finance.reposirories.CartaoCreditoRepository;
import br.com.fernando.lopes.finance.reposirories.CategoriaRepository;
import br.com.fernando.lopes.finance.reposirories.LancamentoCartaoRepository;

@Service
public class LancamentoCartaoService {
	
	@Autowired
	private LancamentoCartaoRepository repo;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private CartaoCreditoRepository cartaoCreditoRepository;
	
	public LancamentoCartao  find(Integer id) {
		Optional<LancamentoCartao> obj =  repo.findById(id);
		return obj.orElse(null);
	}
	
	public LancamentoCartao insert(LancamentoCartao obj) {
		//obj.setId(null);
		return repo.save(obj);
	}
	
	public LancamentoCartao update(LancamentoCartao obj) {
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
	
	public List<LancamentoCartao> findAll(){
		return repo.findAll();
	}
	
	public Page<LancamentoCartao> findPage(Integer page, Integer linesPerPage, String orderBy, String direction ){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public LancamentoCartao fromDTO(LancamentoCartaoDTO objDto) {

		return new LancamentoCartao(objDto.getId(), 
									objDto.getNome(), 
									objDto.getValor(), 
									(categoriaRepository.findById(objDto.getCategoria_id())).get(), 
									(cartaoCreditoRepository.findById(objDto.getCartao_id())).get(), 
									objDto.getStatus(), 
									objDto.getTipo());
	}
	

}
