package br.com.fernando.lopes.finance.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class AuthorizationResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public String testeRest() {
		return "rest funcionando ";
	}

}
