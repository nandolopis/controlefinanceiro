package br.com.fernando.lopes.finance.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import br.com.fernando.lopes.finance.entities.Cliente;

public class ClienteNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer codigo;
	
	@NotEmpty(message="Preenchimento Obrigatório")
	private String nome;
	
	@Email
	@NotEmpty(message="Preenchimento Obrigatório")
	private String email;
	
	@NotEmpty(message="Preenchimento Obrigatório")
	private String senha;
	private LocalDate dataAniversario;
	
	public ClienteNewDTO() {
		
	}

	public ClienteNewDTO(Cliente obj) {
		id = obj.getId();
		codigo = obj.getCodigo();
		nome = obj.getName();
		email = obj.getEmail();
		senha = obj.getSenha();
		dataAniversario = obj.getDataAniversario();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public LocalDate getDataAniversario() {
		return dataAniversario;
	}

	public void setDataAniversario(LocalDate dataAniversario) {
		this.dataAniversario = dataAniversario;
	}
	
	

}
