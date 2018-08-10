package br.com.fernando.lopes.finance.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
		public ResponseEntity<?> find(@PathVariable Integer id) {
			
			Categoria obj = service.find(id);
			return ResponseEntity.ok().body(obj); //retorna um obj ResponceEntity se estiver ok ".ok()" mosta o corpo ".body()" do obj
		}
	
	
}
