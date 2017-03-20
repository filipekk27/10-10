package br.com.ifpe.monitoramento.entidades;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

public class SolicitarDiaria {

	// @Pattern(regexp = "[a-zA-Z]*", message = "Apenas letras")
	private String Justificativa;

	private int CidOrigem;
	private int CidDestino;

	@Past(message = "Voce nem nasceu ainda  ! ")
	@NotNull(message = "Data invalida")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date DataIda;

	@Past(message = "Voce nem nasceu ainda  ! ")
	@NotNull(message = "Data invalida")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date DataVolta;

	private TipoDiaria tipoDiaria;

	// @NotBlank
	@Pattern(regexp = "[0-9.]*", message = "valor invalido")
	private String ValorDiaria;

	private int codSD;
	private Usuario IdUsuario; // Lista dados do usuario solicitante
	private int usuarioId; // cadastrando usuario solicitante
	private Deferimento def;
	private Usuario idGestor;

	@Pattern(regexp = "[a-zA-Z]*", message = "Apenas letras")
	private String justificativaGestor;

	private UnidadeGestora unidadeGestora;

	private String campo;

	public String toString() {
		return "SOLICITAR DIARIA  ID : "+this.codSD+" JustificativaGestor alterada para : " + this.justificativaGestor
				+ " Defererimento alterado para: " + this.def.name();
	}

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

	public String getValorDiaria() {
		return ValorDiaria;
	}

	public void setValorDiaria(String valorDiaria) {
		ValorDiaria = valorDiaria;
	}

	public int getCodSD() {
		return codSD;
	}

	public void setCodSD(int codSD) {
		this.codSD = codSD;
	}

	public Usuario getIdUsuario() {
		return IdUsuario;
	}

	public void setIdUsuario(Usuario idUsuario) {
		IdUsuario = idUsuario;
	}

	public Deferimento getDef() {
		return def;
	}

	public void setDef(Deferimento def) {
		this.def = def;
	}

	public Usuario getIdGestor() {
		return idGestor;
	}

	public void setIdGestor(Usuario idGestor) {
		this.idGestor = idGestor;
	}

	public String getJustificativaGestor() {
		return justificativaGestor;
	}

	public void setJustificativaGestor(String justificativaGestor) {
		this.justificativaGestor = justificativaGestor;
	}

	public UnidadeGestora getUnidadeGestora() {
		return unidadeGestora;
	}

	public void setUnidadeGestora(UnidadeGestora unidadeGestora) {
		this.unidadeGestora = unidadeGestora;
	}

	public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

}
