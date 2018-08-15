package br.com.fernando.lopes.finance.dto;

import java.io.Serializable;

import br.com.fernando.lopes.finance.entities.Lancamento;
import br.com.fernando.lopes.finance.entities.tipos.LancamentoTipo;
import br.com.fernando.lopes.finance.entities.tipos.StatusMovimento;

public class LancamentoCartaoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private Double valor;
	
	private StatusMovimento status;
	private LancamentoTipo tipo;
	
	public LancamentoCartaoDTO() {
		
	}
	
	public LancamentoCartaoDTO(Lancamento obj) {
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

}
