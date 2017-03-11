package br.com.ifpe.monitoramento.entidades;

import java.util.Date;

public class SolicitarDiaria {

	private String Justificativa;
	private int CidOrigem;
	private int CidDestino;
	private Date DataIda;
	private Date DataVolta;
	private TipoDiaria tipoDiaria;
	private double ValorDiaria;
	private int codSD;

	public TipoDiaria getTipoDiaria() {
		return tipoDiaria;
	}

	public void setTipoDiaria(TipoDiaria tipoDiaria) {
		this.tipoDiaria = tipoDiaria;
	}

	public String getJustificativa() {
		return Justificativa;
	}

	public void setJustificativa(String justificativa) {
		Justificativa = justificativa;
	}

	public int getCidOrigem() {
		return CidOrigem;
	}

	public void setCidOrigem(int cidOrigem) {
		CidOrigem = cidOrigem;
	}

	public int getCidDestino() {
		return CidDestino;
	}

	public void setCidDestino(int cidDestino) {
		CidDestino = cidDestino;
	}

	public Date getDataIda() {
		return DataIda;
	}

	public void setDataIda(Date dataIda) {
		DataIda = dataIda;
	}

	public Date getDataVolta() {
		return DataVolta;
	}

	public void setDataVolta(Date dataVolta) {
		DataVolta = dataVolta;
	}

	public double getValorDiaria() {
		return ValorDiaria;
	}

	public void setValorDiaria(double valorDiaria) {
		ValorDiaria = valorDiaria;
	}

	public int getCodSD() {
		return codSD;
	}

	public void setCodSD(int codSD) {
		this.codSD = codSD;
	}

}