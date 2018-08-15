package br.com.fernando.lopes.finance.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import br.com.fernando.lopes.finance.entities.Banco;

public class BancoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message="Preenchimento Obrigatório")
	private String nome;
	
	public BancoDTO() {
		
	}
	
	public BancoDTO(Banco obj) {
		id =  obj.getId();
		nome = obj.getName();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	
	

}
