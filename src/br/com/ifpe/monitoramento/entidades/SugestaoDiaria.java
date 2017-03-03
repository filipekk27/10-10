package br.com.ifpe.monitoramento.entidades;

public class SugestaoDiaria {
	private Cargo cargo;
	private UnidadeGestora ug;
	private Cidade cidade;
	private String destino;
	private String origem;
	private String valores;

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

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getValores() {
		return valores;
	}

	public void setValores(String valores) {
		this.valores = valores;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

}
