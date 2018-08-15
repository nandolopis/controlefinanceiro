package br.com.fernando.lopes.finance.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.fernando.lopes.finance.dto.CartaoCreditoDTO;
import br.com.fernando.lopes.finance.entities.CartaoCredito;
import br.com.fernando.lopes.finance.entities.Cliente;
import br.com.fernando.lopes.finance.reposirories.CartaoCreditoRepository;
import br.com.fernando.lopes.finance.reposirories.ClienteRepository;
import br.com.fernando.lopes.finance.services.exceptions.ObjectNotFoundException;

@Service
public class CartaoCreditoService {
	
	@Autowired
	private CartaoCreditoRepository repo;
	
	private ClienteRepository clienteRepository;
	
	public CartaoCredito find(Integer id)  {
		
		//para evitar o problema do 'null pointer exception '
		Optional<CartaoCredito> obj =  repo.findById(id); 
		
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id
					+ ", Tipo: " + CartaoCredito.class.getName());
		}
	
		return obj.orElse(null);
	}
	
	public CartaoCredito insert(CartaoCredito obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public CartaoCredito update(CartaoCredito obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		try {
			find(id);
			repo.deleteById(id);
			
		} catch (DataIntegrityViolationException e) {
			
			throw new DataIntegrityViolationException("Não é possível Excluir uma CartaoCredito que possui lançamento");
			
		}
	}
	
	public List<CartaoCredito> findAll(){
		return repo.findAll();
	}
	
	public Page<CartaoCredito> findPage(Integer page, Integer linesPerPage, String orderBy, String direction ){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	/*
	 * Converte um objDto para obj comum 
	 */
	
	public CartaoCredito fromDTO(CartaoCreditoDTO objDto) {
		
		Cliente cliente = (clienteRepository.findById(objDto.getCliente_id())).get(); 
		
		return new CartaoCredito(objDto.getId(), objDto.getNome(), objDto.getDiaVencimanto(), objDto.getDiaFechamento(), cliente);
	}
	

}
