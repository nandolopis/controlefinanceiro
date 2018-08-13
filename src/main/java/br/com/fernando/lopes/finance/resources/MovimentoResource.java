package br.com.fernando.lopes.finance.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fernando.lopes.finance.entities.Movimento;
import br.com.fernando.lopes.finance.services.MovimentoService;

@RestController(value = "/movimentos")
public class MovimentoResource {
	
	private MovimentoService service;
	
	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(Integer id){
		Movimento obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
}
