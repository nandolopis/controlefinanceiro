package br.com.fernando.lopes.finance.dto;

import java.io.Serializable;

import br.com.fernando.lopes.finance.entities.LancamentoCartao;
import br.com.fernando.lopes.finance.entities.tipos.LancamentoTipo;
import br.com.fernando.lopes.finance.entities.tipos.StatusMovimento;

public class LancamentoCartaoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private Double valor;
	
	private StatusMovimento status;
	private LancamentoTipo tipo;
	private Integer categoria_id;
	private Integer cartao_id;
	
	public LancamentoCartaoDTO() {
		
	}

	public LancamentoCartaoDTO(LancamentoCartao obj) {
		id = obj.getId();
		nome = obj.getNome();
		valor = obj.getValor();
		status = obj.getStatus();
		tipo = obj.getTipo();
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

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public StatusMovimento getStatus() {
		return status;
	}

	public void setStatus(StatusMovimento status) {
		this.status = status;
	}

	public LancamentoTipo getTipo() {
		return tipo;
	}

	public void setTipo(LancamentoTipo tipo) {
		this.tipo = tipo;
	}

	public Integer getCategoria_id() {
		return categoria_id;
	}

	public void setCategoria_id(Integer categoria_id) {
		this.categoria_id = categoria_id;
	}

	public Integer getCartao_id() {
		return cartao_id;
	}

	public void setCartao_id(Integer cartao_id) {
		this.cartao_id = cartao_id;
	}
	

}
