package br.com.fernando.lopes.finance.dto;

import java.io.Serializable;

import br.com.fernando.lopes.finance.entities.Categoria;

/**
 * 
 * @author fernando
 * DTO Data transfer object 
 * objeto de transferecia de dados 
 *
 */

public class CategoriaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	private String nome;
	
	public CategoriaDTO() {
		
	}
	
	//contrutor que recebe o classe categoria
	public CategoriaDTO(Categoria obj) {
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
	
	

}
