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

import br.com.fernando.lopes.finance.dto.BancoDTO;
import br.com.fernando.lopes.finance.entities.Banco;
import br.com.fernando.lopes.finance.entities.Categoria;
import br.com.fernando.lopes.finance.services.BancoService;
import br.com.fernando.lopes.finance.services.exceptions.ObjectNotFoundException;

@RestController
@RequestMapping(value="/bancos")
public class BancoResource {
	
	@Autowired
	private BancoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Banco> find(@PathVariable Integer id){
		
		Banco obj = service.find(id);	
		
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id
					+ ", Tipo: " + Categoria.class.getName());
		}
		return ResponseEntity.ok().body(obj);
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody BancoDTO objDto){ 
		
		//converter objDto para Response Entity
		Banco obj = service.fromDTO(objDto);
		
		
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
	public ResponseEntity<Void> update(@Valid @RequestBody BancoDTO objDto, @PathVariable Integer id){
		Banco obj = service.fromDTO(objDto);
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
	public ResponseEntity<List<BancoDTO>> findAll() {
		
		List<Banco> list = service.findAll();
		
		/*
		 * convertendo a lista do tipo Banco para o tipo BancoDTO
		 * usando o metodo do java 8 Stream que mapea a lista retornando a lista 
		 * através da função anônima gerando a collect
		 */
		List<BancoDTO> listDto = list.stream().map(obj -> new BancoDTO(obj))
															.collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDto); 
	}
	
	/*
	 * paginaçao 
	 */
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<BancoDTO>> findpage(
				@RequestParam(value="page", defaultValue="0") Integer page, 
				@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
				@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
				@RequestParam(value="direction", defaultValue="ASC") String direction ) {
		
		Page<Banco> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<BancoDTO> listDto = list.map(obj -> new BancoDTO(obj));

		return ResponseEntity.ok().body(listDto); 
	}

}
