package br.com.ifpe.monitoramento.entidades;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @author Hugo Oliveira
 *
 */
public class Usuario {

	private Integer idUser;
	private int UsuarioLogado;
	private String campo;

	@Pattern(regexp = "[0-9]{11}", message = "Cpf invalido")
	private String cpf;

	@Pattern(regexp = "^([A-Z,a-zã,á,à,â,ê,í,ú,õ,é,ü, ])*", message = " Nome invalido")
	private String nome;

	@NotNull
	@Pattern(regexp = "^[\\w\\-]+(\\.[\\w\\-]+)*@([A-Za-z0-9-]+\\.)+[A-Za-z]{2,4}$", message = "E-mail invalido.")
	private String email;

	@Pattern(regexp = "[a-zA-Z ,]*", message = " Endereco tem apenas letras sem acento caracteres !")
	private String endereco;

	@Past(message = "Voce nem nasceu ainda  ! ")
	@NotNull(message = "Data invalida")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataNascimento;

	@Pattern(regexp = "[a-zA-Z_0-9]*", message = "A Senha deve ter letras e numeros")
	private String senha;

	private Date dataCadastro;

	@NotNull(message = "Selecione um cargo.")
	private Cargo cargo;

	@NotNull(message = "Selecione uma UG.")
	private UnidadeGestora uGestora;

	private Situacao situacao;
	private Nivel nivel;

	public String toString() {
		return "O usuario : " + this.UsuarioLogado + " alterou o nome do usuario : " + this.nome + "o endereco para : "
				+ this.endereco + " o email para : " + this.email + " a data nascimento para : " + this.dataNascimento
				+ " o cargo para : " + this.cargo.getId() + " a unidade para : " + this.uGestora.getCodigo()
				+ " a situacao para : " + this.situacao.name() + " o Nivel para : " + this.nivel
				+ " Codigo do Usuario : " + this.idUser;
	}

	public int getUsuarioLogado() {
		return UsuarioLogado;
	}

	public void setUsuarioLogado(int usuarioLogado) {
		UsuarioLogado = usuarioLogado;
	}

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public UnidadeGestora getuGestora() {
		return uGestora;
	}

	public void setuGestora(UnidadeGestora uGestora) {
		this.uGestora = uGestora;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

}
