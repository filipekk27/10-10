package br.com.ifpe.monitoramento.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.ifpe.monitoramento.dao.CidadeDao;
import br.com.ifpe.monitoramento.dao.SolicitarDiariaDao;
import br.com.ifpe.monitoramento.dao.SugestaoDiariaDao;
import br.com.ifpe.monitoramento.entidades.Cidade;
import br.com.ifpe.monitoramento.entidades.SolicitarDiaria;
import br.com.ifpe.monitoramento.entidades.SugestaoDiaria;

@Controller
public class SolicitarDiariaController {

	@RequestMapping("/formSolicitarDiaria")
	public String formSolicitarDiaria(Model model) {
		CidadeDao dao = new CidadeDao();
		model.addAttribute("ListarEstados", dao.listar());

		return "SolicitarDiaria/FormCadastroSolicitarDiaria";
	}

	@RequestMapping("/listarCidade") // cidade origem ajax
	public @ResponseBody String exibirCidade(@RequestParam Integer cod_cidade, HttpServletResponse response) {

		CidadeDao dao = new CidadeDao();
		List<Cidade> listar = dao.listar2(cod_cidade);

		StringBuilder st = new StringBuilder();
		st.append("<label>");
		st.append("Cidade origem");
		st.append("</label>");
		st.append("<br>");
		st.append("<select name='CidOrigem' id='CidOrigem' required='true'>");
		st.append("<option value=''>Selecione a cidade</option>");
		for (Cidade cidade : listar) {
			st.append("<option value=" + cidade.getCod_cidade() + ">" + cidade.getNome() + "</option>");

		}
		st.append("</select>");
		response.setStatus(200);
		return st.toString();
	}

	@RequestMapping("/listarCidade2") // Cidade destino ajax
	public @ResponseBody String exibirCidade2(@RequestParam Integer cod_cidade, HttpServletResponse response) {

		CidadeDao dao = new CidadeDao();
		List<Cidade> listar = dao.listar2(cod_cidade);

		StringBuilder st = new StringBuilder();
		st.append("<label>");
		st.append("Cidade destino");
		st.append("</label>");
		st.append("<br>");
		st.append("<select name='CidDestino' id='CidDestino' required='true'>");
		st.append("<option value=''>Selecione a cidade</option>");
		for (Cidade cidade : listar) {
			st.append("<option value=" + cidade.getCod_cidade() + ">" + cidade.getNome() + "</option>");

		}
		st.append("</select>");
		response.setStatus(200);
		return st.toString();
	}

	@RequestMapping("/exibirValor") // Valor ajax
	public @ResponseBody String exibirValor(@RequestParam Integer origem, Integer destino, HttpServletResponse response,
			String teste) {

		SugestaoDiariaDao dao = new SugestaoDiariaDao();
		List<SugestaoDiaria> listarValor = dao.listarValor(origem, destino);

		StringBuilder st = new StringBuilder();
		st.append("<label>");
		st.append("Valor");
		st.append("</label>");
		st.append("<br>");

		for (SugestaoDiaria valor : listarValor) {
			teste = valor.getValores();
			if (teste != null && !teste.equals("")) {
				st.append("<input type='text' name='ValorDiaria' readonly id='ValorDiaria' readonly='true' value="
						+ valor.getValores() + ">");
			} else {
				st.append(
						"<input type='text' readonly readonly='true' value='Nenhuma sugestao para o local informado'>");
			}
		}

		response.setStatus(200);
		return st.toString();
	}

	@RequestMapping("cadastarSolicitacao")
	public String cadastarSolicitacao(SolicitarDiaria s, Model model) {
		SolicitarDiariaDao dao = new SolicitarDiariaDao();
		dao.cadastrarSolicitarDiaria(s);
		model.addAttribute("msgSucesso", "Solicitação feita com sucesso! ! ");
		return "sucesso/sucesso";
	}

	@RequestMapping("/listarSolicitacao")
	public String listarSolicitacao(Model model) {
		SolicitarDiariaDao dao = new SolicitarDiariaDao();
		model.addAttribute("listarSolicitacao", dao.listarSolicitacao());
		model.addAttribute("acompanharSolicitacao", dao.listarSolicitacao());
		return "SolicitarDiaria/ListarSolicitacao";
	}

	@RequestMapping("/acompanharSolicitacao")
	public String acompanharSolicitacao(Model model) {
		SolicitarDiariaDao dao = new SolicitarDiariaDao();
		model.addAttribute("acompanharSolicitacao", dao.listarAcompanhamento());
		return "SolicitarDiaria/acompanharDiaria";
	}

}
