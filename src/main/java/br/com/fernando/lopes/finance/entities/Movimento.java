package br.com.fernando.lopes.finance.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Movimento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private MovimentoPK id = new MovimentoPK();
	
	private String nome;
	private Double endrada;
	private Double saida;
	
	
	@ManyToMany
	@JoinTable(name = "MOVIMENTO_CATEGORIA",
				joinColumns = @JoinColumn(name = "MOVIMENTO_id"),
				inverseJoinColumns = @JoinColumn(name = "categoria_id")
			)
	private List<Categoria> categorias = new ArrayList<>();
	
	public Movimento() {
		
	}


	public Movimento(Conta conta, String nome, Double endrada, Double saida) {
		super();
		id.setConta(conta);
		this.nome = nome;
		this.endrada = endrada;
		this.saida = saida;
	}
	
	
	
	public double getSubTotal() {
		return endrada - saida;
	}

	public MovimentoPK getId() {
		return id;
	}

	public void setId(MovimentoPK id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getEndrada() {
		return endrada;
	}

	public void setEndrada(Double endrada) {
		this.endrada = endrada;
	}

	public Double getSaida() {
		return saida;
	}

	public void setSaida(Double saida) {
		this.saida = saida;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
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
		Movimento other = (Movimento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
