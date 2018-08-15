package br.com.fernando.lopes.finance.dto;

import java.io.Serializable;

import br.com.fernando.lopes.finance.entities.Conta;
import br.com.fernando.lopes.finance.entities.tipos.ContaTipo;

public class ContaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private ContaTipo tipoconta;
	private Integer banco_id;
	private Integer cliente_id;
	
	public ContaDTO() {
		
	}
	
	public ContaDTO(Conta obj) {
		id = obj.getId();
		nome = obj.getName();
		tipoconta = obj.getTipoconta();

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

	public ContaTipo getTipoconta() {
		return tipoconta;
	}

	public void setTipoconta(ContaTipo tipoconta) {
		this.tipoconta = tipoconta;
	}

	public Integer getBanco_id() {
		return banco_id;
	}

	public void setBanco_id(Integer banco_id) {
		this.banco_id = banco_id;
	}

	public Integer getCliente_id() {
		return cliente_id;
	}

	public void setCliente_id(Integer cliente_id) {
		this.cliente_id = cliente_id;
	}
	
	


}
