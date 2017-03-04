package br.com.ifpe.monitoramento.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.ifpe.monitoramento.dao.CargoDao;
import br.com.ifpe.monitoramento.dao.CidadeDao;
import br.com.ifpe.monitoramento.dao.SugestaoDiariaDao;
import br.com.ifpe.monitoramento.dao.UnidadeGestoraDao;
import br.com.ifpe.monitoramento.entidades.Cidade;
import br.com.ifpe.monitoramento.entidades.SugestaoDiaria;

@Controller
public class SugestaoDiariaController {

	@RequestMapping("/formCadastroSD")
	public String formCadastroSD(Model model, String nome, String id, String codigo) {
		CargoDao dao = new CargoDao();
		model.addAttribute("listarCargoUsuario", dao.listarCargo(nome, id));
		UnidadeGestoraDao dao2 = new UnidadeGestoraDao();
		model.addAttribute("listarUGestora", dao2.listarUG(nome, codigo));
		CidadeDao dao3 = new CidadeDao();
		model.addAttribute("ListarEstados", dao3.listar());
		return "sugestao/FormCadastroSD";
	}

	@RequestMapping("/exibirCidade") // cidade origem ajax
	public @ResponseBody String exibirCidade(@RequestParam Integer cod_cidade, HttpServletResponse response) {

		CidadeDao dao = new CidadeDao();
		List<Cidade> listar = dao.listar2(cod_cidade);

		StringBuilder st = new StringBuilder();
		st.append("<label>");
		st.append("Cidade origem");
		st.append("</label>");
		st.append("<br>");
		st.append("<select name='origem' id='cidade' required='true'>");
		st.append("<option value=''>Selecione a cidade</option>");
		for (Cidade cidade : listar) {
			st.append("<option value=" + cidade.getCod_cidade() + ">" + cidade.getNome() + "</option>");

		}
		st.append("</select>");
		response.setStatus(200);
		return st.toString();
	}
	@RequestMapping("/exibirCidade2") // Cidade destino ajax
	public @ResponseBody String exibirCidade2(@RequestParam Integer cod_cidade, HttpServletResponse response) {

		CidadeDao dao = new CidadeDao();
		List<Cidade> listar = dao.listar2(cod_cidade);

		StringBuilder st = new StringBuilder();
		st.append("<label>");
		st.append("Cidade destino");
		st.append("</label>");
		st.append("<br>");
		st.append("<select name='destino' id='cidade' required='true'>");
		st.append("<option value=''>Selecione a cidade</option>");
		for (Cidade cidade : listar) {
			st.append("<option value=" + cidade.getCod_cidade() + ">" + cidade.getNome() + "</option>");

		}
		st.append("</select>");
		response.setStatus(200);
		return st.toString();
	}
	
	@RequestMapping("/cadastrarSugestao")
	public String cadastrarSugestão(@Valid SugestaoDiaria sd , BindingResult rs, Model model ){
		if(rs.hasFieldErrors("valores")){
			return "forward:formCadastroSD";
		}
		SugestaoDiariaDao dao = new SugestaoDiariaDao();
		dao.cadastrarSD(sd);
		model.addAttribute("msgSucesso", "Sucesso ! ! ");
		return "sucesso/sucesso";
	}
	
	@RequestMapping("/listarSugestao")
	public String listarSugestao(Model model){
		SugestaoDiariaDao dao = new SugestaoDiariaDao();
		model.addAttribute("listarSD", dao.listar());
		return "sugestao/ListarSD";
	}

}
