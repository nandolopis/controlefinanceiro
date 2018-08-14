package br.com.fernando.lopes.finance.entities;

import java.io.Serializable;
import java.util.Date;
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
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.fernando.lopes.finance.entities.tipos.ContaTipo;


@Entity
public class Conta implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private ContaTipo tipoconta;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataCriacao;
	
	@ManyToOne
	@JoinColumn(name="banco_id")
	@MapsId
	private Banco banco;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="cliente_id")
	//@MapsId
	private Cliente cliente;
	
	@JsonBackReference
	@OneToMany(mappedBy="conta", cascade = CascadeType.ALL)
	private Set<Movimento> movimentos = new HashSet<>();
	
	public Conta() {
		dataCriacao = new Date();
	}

	public Conta(Integer id, String name, ContaTipo tipoconta, Banco banco, Cliente cliente) {
		super();
		this.id = id;
		this.name = name;
		this.tipoconta = tipoconta;
		this.banco = banco;
		this.cliente = cliente;
		dataCriacao = new Date();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	public ContaTipo getTipoconta() {
		return tipoconta;
	}

	public void setTipoconta(ContaTipo tipoconta) {
		this.tipoconta = tipoconta;
	}
	

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	@JsonIgnore
	public Set<Movimento> getMovimentos() {
		return movimentos;
	}

	public void setMovimento(Set<Movimento> movimentos) {
		this.movimentos = movimentos;
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
		Conta other = (Conta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
