package br.com.fernando.lopes.finance.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.fernando.lopes.finance.dto.CategoriaDTO;
import br.com.fernando.lopes.finance.entities.Categoria;
import br.com.fernando.lopes.finance.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
		
		@Autowired
		private CategoriaService service;
		
		/*
		 * ResponseEntity armazena varias informações 
		 * de uma resposta Http 
		 */
		@RequestMapping(value="/{id}", method=RequestMethod.GET)
		public ResponseEntity<Categoria> find(@PathVariable Integer id) {
			
			Categoria obj = service.find(id);

			/*
			 * retorna um obj ResponceEntity se estiver ok ".ok()" mosta o corpo ".body()" do obj
			 */
			return ResponseEntity.ok().body(obj); 
		}
		
		/*
		 * @RequestBody constroi o obj apartir dos dados json 
		 */
		@RequestMapping(method=RequestMethod.POST)
		public ResponseEntity<Void> insert(@RequestBody Categoria obj){ 
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
		public ResponseEntity<Void> update(@RequestBody Categoria obj, @PathVariable Integer id){
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
		public ResponseEntity<List<CategoriaDTO>> findAll() {
			
			List<Categoria> list = service.findAll();
			
			/*
			 * convertendo a lista do tipo Categoria para o tipo CategoriaDTO
			 * usando o metodo do java 8 Stream que mapea a lista retornando a lista 
			 * através da função anônima gerando a collect
			 */
			List<CategoriaDTO> listDto = list.stream().map(obj -> new CategoriaDTO(obj))
																.collect(Collectors.toList());
			
			return ResponseEntity.ok().body(listDto); 
		}
	
	
}
