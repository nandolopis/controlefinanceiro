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
	
	@Email(message="Email inválido")
	@NotEmpty(message="Preenchimento Obrigatório")
	private String email;
	
	@NotEmpty(message="Preenchimento Obrigatório")
	private String senha;
	private LocalDate dataAniversario;
	
	private Integer conta_id;
	private String nome_conta;
	private Integer Banco_id;
	private String nome_banco;
	
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

	public Integer getConta_id() {
		return conta_id;
	}

	public void setConta_id(Integer conta_id) {
		this.conta_id = conta_id;
	}

	public String getNome_conta() {
		return nome_conta;
	}

	public void setNome_conta(String nome_conta) {
		this.nome_conta = nome_conta;
	}

	public Integer getBanco_id() {
		return Banco_id;
	}

	public void setBanco_id(Integer banco_id) {
		Banco_id = banco_id;
	}

	public String getNome_banco() {
		return nome_banco;
	}

	public void setNome_banco(String nome_banco) {
		this.nome_banco = nome_banco;
	}
	
	

}
