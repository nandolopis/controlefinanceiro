package br.com.fernando.lopes.finance.dto;

import java.io.Serializable;

import br.com.fernando.lopes.finance.entities.CartaoCredito;

public class CartaoCreditoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String nome;
	
	private Integer diaVencimanto;
	
	private Integer diaFechamento;
	
	private Integer cliente_id;
	
	public CartaoCreditoDTO() {
		
	}
	
	public CartaoCreditoDTO(CartaoCredito obj) {
		id = obj.getId();
		nome = obj.getNome();
		diaVencimanto = obj.getDiaVencimanto();
		diaFechamento = obj.getDiaFechamento();
		
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

	public Integer getDiaVencimanto() {
		return diaVencimanto;
	}

	public void setDiaVencimanto(Integer diaVencimanto) {
		this.diaVencimanto = diaVencimanto;
	}

	public Integer getDiaFechamento() {
		return diaFechamento;
	}

	public void setDiaFechamento(Integer diaFechamento) {
		this.diaFechamento = diaFechamento;
	}

	public Integer getCliente_id() {
		return cliente_id;
	}

	public void setCliente_id(Integer cliente_id) {
		this.cliente_id = cliente_id;
	}

	
	
	

}
