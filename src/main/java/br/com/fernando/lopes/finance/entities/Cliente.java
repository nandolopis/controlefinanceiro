package br.com.fernando.lopes.finance.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	//@JsonFormat(pattern = "dd/MM/YYYY HH:mm")
	private LocalDate dataCadastro;
	
	@Column(unique = true)
	private String email;
	
	@JsonIgnore
	private String senha;
	
	private LocalDate dataAniversario;
	
	@OneToMany(mappedBy = "cliente"/*, cascade = CascadeType.ALL*/)
	private Set<CartaoCredito> cartoesCreditos = new HashSet<>();
	
	@OneToMany(mappedBy = "cliente"/*, cascade = CascadeType.ALL*/)
	private Set<Conta> contas = new HashSet<>();
	
	public Cliente() {
		dataCadastro = LocalDate.now() ;
	}

	public Cliente(Integer id,String name, String email, String senha, LocalDate dataAniversario) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.senha = senha;
		this.dataAniversario = dataAniversario;
		dataCadastro = LocalDate.now() ;
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


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}


	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public LocalDate getDataAniversario() {
		return dataAniversario;
	}

	public void setDataAniversario(LocalDate dataAniversario) {
		this.dataAniversario = dataAniversario;
	}

	public Set<Conta> getContas() {
		return contas;
	}

	public void setContas(Set<Conta> contas) {
		this.contas = contas;
	}

	public Set<CartaoCredito> getCartoesCreditos() {
		return cartoesCreditos;
	}

	public void setCartoesCreditos(Set<CartaoCredito> cartoesCreditos) {
		this.cartoesCreditos = cartoesCreditos;
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
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	

}
