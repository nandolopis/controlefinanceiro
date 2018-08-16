package br.com.fernando.lopes.finance.dto;

import java.io.Serializable;

import br.com.fernando.lopes.finance.entities.Lancamento;
import br.com.fernando.lopes.finance.entities.tipos.LancamentoTipo;
import br.com.fernando.lopes.finance.entities.tipos.StatusMovimento;

public class LancamentoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private Double valor;
	
	private StatusMovimento status;
	private LancamentoTipo tipo;
	private Integer categoria_id;
	
	private Integer movimento_id;
	
	public LancamentoDTO() {
		
	}
	
	public LancamentoDTO(Lancamento obj) {
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
	

	
	public Integer getCategoria_id() {
		return categoria_id;
	}

	public void setCategoria_id(Integer categoria_id) {
		this.categoria_id = categoria_id;
	}

	public LancamentoTipo getTipo() {
		return tipo;
	}

	public void setTipo(LancamentoTipo tipo) {
		this.tipo = tipo;
	}

	public Integer getMovimento_id() {
		return movimento_id;
	}

	public void setMovimento_id(Integer movimento_id) {
		this.movimento_id = movimento_id;
	}
	
	

}
