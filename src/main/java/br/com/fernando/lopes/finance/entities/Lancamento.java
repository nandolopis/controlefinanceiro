package br.com.fernando.lopes.finance.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.fernando.lopes.finance.entities.tipos.LancamentoTipo;
import br.com.fernando.lopes.finance.entities.tipos.StatusMovimento;


@Entity
public class Lancamento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private Double valor ;
	
	private StatusMovimento status;
	private LancamentoTipo tipo;
	
	@ManyToOne
	@JoinColumn(name="Categoria_id")
	Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name="movimento_id")
	private Movimento movimento;
	
	public Lancamento() {
		
	}


	public Lancamento(Integer id,  String nome, Double valor, Categoria categoria ,Movimento movimento, StatusMovimento status, LancamentoTipo tipo ) {
		super();
		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.categoria = categoria;
		this.movimento = movimento;
		this.status = status;
		this.tipo =  tipo;
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


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lancamento other = (Lancamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
