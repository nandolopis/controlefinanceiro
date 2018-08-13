package br.com.fernando.lopes.finance.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.fernando.lopes.finance.entities.tipos.LancamentoTipo;
import br.com.fernando.lopes.finance.entities.tipos.StatusMovimento;

@Entity
public class Movimento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="conta_id")
	@MapsId
	private Conta conta;
	
	
	@OneToMany(mappedBy="id.movimento", cascade = CascadeType.ALL)
	private Set<Lancamento> lancamentos = new HashSet<>();
	
	
	public Movimento() {
		
	}
	

	public Movimento(Integer id, String nome, Conta conta) {
		super();
		this.id = id;
		this.nome = nome;
		this.conta = conta;
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

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
	
	public Set<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(Set<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}

	public Double getSaldo() {
		Double saldo = 0.0D;
		
		for (Lancamento l : lancamentos) {
			if ((l.getTipo() == LancamentoTipo.ENTRADA) && (l.getStatus() == StatusMovimento.RECEBIDO)) {
			saldo += l.getValor();
			} else if ((l.getTipo() == LancamentoTipo.SAIDA) && (l.getStatus() == StatusMovimento.PAGO)){
				saldo -= l.getValor();
			} else {
				saldo += 0.0D;
			}
		}

		return saldo;
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
