package br.com.ifpe.monitoramento.entidades;

public class SugestaoDiaria {
	private Cargo cargo;
	private UnidadeGestora ug;
	private Cidade cidade;
	private Integer destino;
	private Integer origem;
	private Double valores;
	private Integer idSD;

	public Integer getIdSD() {
		return idSD;
	}

	public void setIdSD(Integer idSD) {
		this.idSD = idSD;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public UnidadeGestora getUg() {
		return ug;
	}

	public void setUg(UnidadeGestora ug) {
		this.ug = ug;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Integer getDestino() {
		return destino;
	}

	public void setDestino(Integer destino) {
		this.destino = destino;
	}

	public Integer getOrigem() {
		return origem;
	}

	public void setOrigem(Integer origem) {
		this.origem = origem;
	}

	public Double getValores() {
		return valores;
	}

	public String getNdestino() {
		return Ndestino;
	}

	public void setNdestino(String ndestino) {
		Ndestino = ndestino;
	}

	public void setValores(Double valores) {
		this.valores = valores;
	}

}
