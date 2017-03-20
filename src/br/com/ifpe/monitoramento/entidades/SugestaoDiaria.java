package br.com.ifpe.monitoramento.entidades;

import javax.validation.constraints.Pattern;

/**
 * 
 * @author Hugo Oliveira
 *
 */
public class SugestaoDiaria {
	private Cargo cargo;
	private UnidadeGestora ug;
	private Cidade cidade;
	private Integer destino;
	private Integer origem;
	private int idUsuario;
	private String campo;

	@Pattern(regexp = "[0-9.]*", message = "Valor invalido")
	private String valores;

	private Integer idSD;

	public String toString() {
		return "O usuario : " + this.idUsuario + " alterou o cargo da sugestao para : " + this.cargo.getId()
				+ " a unidade : " + this.ug.getCodigo() + " o valor para : " + this.valores + " Id da Sugestao :"
				+ this.idSD;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

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

	public String getValores() {
		return valores;
	}

	public void setValores(String valores) {
		this.valores = valores;
	}

}
