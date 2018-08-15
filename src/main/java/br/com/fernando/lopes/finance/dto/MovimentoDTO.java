package br.com.fernando.lopes.finance.dto;

import java.io.Serializable;

import br.com.fernando.lopes.finance.entities.Movimento;

public class MovimentoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	
	private Integer conta_id;
	
	public MovimentoDTO() {
		
	}
	
	public MovimentoDTO(Movimento obj) {
		id = obj.getId();
		nome = obj.getNome();
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

	public Integer getConta_id() {
		return conta_id;
	}

	public void setConta_id(Integer conta_id) {
		this.conta_id = conta_id;
	}
	
	
	
	
	

}
