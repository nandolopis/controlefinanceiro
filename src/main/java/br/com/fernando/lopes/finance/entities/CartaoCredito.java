package br.com.fernando.lopes.finance.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CartaoCredito implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
    private Integer diaVencimanto;
	
	private Integer diaFechamento;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="cliente_id", referencedColumnName="id")
	private Cliente cliente;
	
	public CartaoCredito() {
		
	}

	public CartaoCredito(Integer id, String nome, Integer diaVencimanto, Integer diaFechamento, Cliente cliente) {
		super();
		this.id = id;
		this.nome = nome;
		this.diaVencimanto = diaVencimanto;
		this.diaFechamento = diaFechamento;
		this.cliente = cliente;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	

	
	

}
