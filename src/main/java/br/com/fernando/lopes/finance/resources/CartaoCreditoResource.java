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

import br.com.fernando.lopes.finance.dto.CartaoCreditoDTO;
import br.com.fernando.lopes.finance.entities.CartaoCredito;
import br.com.fernando.lopes.finance.services.CartaoCreditoService;

@RestController
@RequestMapping(value="/CartaoCreditos")
public class CartaoCreditoResource {
	
		
		@Autowired
		private CartaoCreditoService service;
		
		/*
		 * ResponseEntity armazena varias informações 
		 * de uma resposta Http 
		 */
		@RequestMapping(value="/{id}", method=RequestMethod.GET)
		public ResponseEntity<CartaoCredito> find(@PathVariable Integer id) {
			
			CartaoCredito obj = service.find(id);

			/*
			 * retorna um obj ResponceEntity se estiver ok ".ok()" mosta o corpo ".body()" do obj
			 */
			return ResponseEntity.ok().body(obj); 
		}
		
		/*
		 * @RequestBody constroi o obj apartir dos dados json 
		 * @Valid valida o objDTO
		 */
		@RequestMapping(method=RequestMethod.POST)
		public ResponseEntity<Void> insert(@Valid @RequestBody CartaoCreditoDTO objDto){ 
			
			//converter objDto para Response Entity
			CartaoCredito obj = service.fromDTO(objDto);
			
			
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
		public ResponseEntity<Void> update(@Valid @RequestBody CartaoCreditoDTO objDto, @PathVariable Integer id){
			CartaoCredito obj = service.fromDTO(objDto);
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
		public ResponseEntity<List<CartaoCreditoDTO>> findAll() {
			
			List<CartaoCredito> list = service.findAll();
			
			/*
			 * convertendo a lista do tipo CartaoCredito para o tipo CartaoCreditoDTO
			 * usando o metodo do java 8 Stream que mapea a lista retornando a lista 
			 * através da função anônima gerando a collect
			 */
			List<CartaoCreditoDTO> listDto = list.stream().map(obj -> new CartaoCreditoDTO(obj))
																.collect(Collectors.toList());
			
			return ResponseEntity.ok().body(listDto); 
		}
		
		/*
		 * paginaçao 
		 */
		@RequestMapping(value="/page", method=RequestMethod.GET)
		public ResponseEntity<Page<CartaoCreditoDTO>> findpage(
					@RequestParam(value="page", defaultValue="0") Integer page, 
					@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
					@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
					@RequestParam(value="direction", defaultValue="ASC") String direction ) {
			
			Page<CartaoCredito> list = service.findPage(page, linesPerPage, orderBy, direction);
			Page<CartaoCreditoDTO> listDto = list.map(obj -> new CartaoCreditoDTO(obj));

			return ResponseEntity.ok().body(listDto); 
		}
	
	
}
