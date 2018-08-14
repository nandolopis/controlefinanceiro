package br.com.fernando.lopes.finance.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fernando.lopes.finance.entities.Banco;
import br.com.fernando.lopes.finance.services.BancoService;

@RestController
@RequestMapping(value="/bancos")
public class BancoResource {
	
	@Autowired
	private BancoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Banco> find(@PathVariable Integer id){
		
		Banco obj = service.find(id);		
		return ResponseEntity.ok().body(obj);
		
	}

}
