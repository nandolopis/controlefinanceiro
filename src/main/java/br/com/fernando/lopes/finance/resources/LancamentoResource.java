package br.com.fernando.lopes.finance.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.fernando.lopes.finance.dto.LancamentoDTO;
import br.com.fernando.lopes.finance.entities.Lancamento;
import br.com.fernando.lopes.finance.services.LancamentoService;

@RestController
@RequestMapping(value="/lancamentos")
public class LancamentoResource {
	
	@Autowired
	private LancamentoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Lancamento> find(@PathVariable Integer id){
		Lancamento obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody LancamentoDTO objDto){ 
		
		//converter objDto para Response Entity
		Lancamento obj = service.fromDTO(objDto);
		
		
		obj = service.insert(obj);
		
		System.out.println(obj);
		//retornar a uri do novo obj
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
											.path("/{id}")
											.buildAndExpand(obj.getId())
											.toUri();
		
		return ResponseEntity.created(uri).build();
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody LancamentoDTO objDto, @PathVariable Integer id){
		Lancamento obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		System.out.println(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping( method=RequestMethod.GET)
	public ResponseEntity<List<LancamentoDTO>> findAll() {
		
		List<Lancamento> list = service.findAll();
		
		/*
		 * convertendo a lista do tipo Lancamento para o tipo LancamentoDTO
		 * usando o metodo do java 8 Stream que mapea a lista retornando a lista 
		 * através da função anônima gerando a collect
		 */
		List<LancamentoDTO> listDto = list.stream().map(obj -> new LancamentoDTO(obj))
															.collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDto); 
	}
	
	/*
	 * paginaçao 
	 */
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<LancamentoDTO>> findpage(
				@RequestParam(value="page", defaultValue="0") Integer page, 
				@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
				@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
				@RequestParam(value="direction", defaultValue="ASC") String direction ) {
		
		Page<Lancamento> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<LancamentoDTO> listDto = list.map(obj -> new LancamentoDTO(obj));

		return ResponseEntity.ok().body(listDto); 
	}

}
