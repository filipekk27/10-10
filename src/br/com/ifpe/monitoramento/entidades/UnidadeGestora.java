package br.com.ifpe.monitoramento.entidades;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.NumberFormat;

/**
 * 
 * @author Hugo Oliveira
 *
 */
public class UnidadeGestora {
	@NotBlank(message = "O nome nao pode ser vazio.")
	@Size(min = 8, max = 100, message = "O nome deve ter de : {min} a {max} Letras")
	@Pattern(regexp = "[a-zA-Z ]*", message = "Nome tem apenas letras sem acento ou caracteres !")
	private String nome;

	@NotNull(message = "O codigo nao pode ser vazio")
	@Min(value = 1, message = "O codigo min e 1")
	@Max(value = 999999999, message = "O codigo max e 999 Milhoes")
	@NumberFormat(pattern ="#########")
	private Integer codigo;

	private Date data;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
