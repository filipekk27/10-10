package br.com.ifpe.monitoramento.entidades;

/**
 * 
 * @author Hugo Oliveira
 *
 */
public class Cidade {

	private Integer codigo;
	private Integer cod_cidade;
	private String nome;
	private String UF;

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

	public String getUF() {
		return UF;
	}

	public void setUF(String uF) {
		UF = uF;
	}

	public Integer getCod_cidade() {
		return cod_cidade;
	}

	public void setCod_cidade(Integer cod_cidade) {
		this.cod_cidade = cod_cidade;
	}

}
