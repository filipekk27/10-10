package br.com.ifpe.monitoramento.entidades;

import java.util.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 
 * @author Hugo Oliveira
 *
 */
public class Cargo {
	@NotBlank(message = "O campo nao pode ser vazio")
	@Size(min = 3, max = 60, message = "o nome deve ter de : {min} a  {max}")
	@Pattern(regexp = "[a-zA-Z ]*", message = "Nome tem apenas letras sem acento ou caracteres !")
	private String nome;
	private Integer id;
	private Date data_cadastro;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData_cadastro() {
		return data_cadastro;
	}

	public void setData_cadastro(Date data_cadastro) {
		this.data_cadastro = data_cadastro;
	}

}
