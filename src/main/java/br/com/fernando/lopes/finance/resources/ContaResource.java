package br.com.fernando.lopes.finance.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fernando.lopes.finance.entities.Conta;
import br.com.fernando.lopes.finance.services.ContaService;

@RestController
@RequestMapping(value="/contas")
public class ContaResource {
	
	@Autowired
	private ContaService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){
		Conta obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

}
