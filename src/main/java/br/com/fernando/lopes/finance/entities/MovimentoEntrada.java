package br.com.fernando.lopes.finance.entities;

import java.util.Date;


public class MovimentoEntrada extends Movimento{
	private static final long serialVersionUID = 1L;
	
	private Date dataLancamento;
	private Double Valor;
	
	public MovimentoEntrada(Integer id, String nome, Date dataLancamento, Double valor) {
		super( id, nome);
		this.dataLancamento = dataLancamento;
		Valor = valor;
	}



	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Double getValor() {
		return Valor;
	}

	public void setValor(Double valor) {
		Valor = valor;
	}
	
	
	

}
