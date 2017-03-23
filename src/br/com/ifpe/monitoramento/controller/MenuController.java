package br.com.ifpe.monitoramento.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ifpe.monitoramento.dao.HistoricoDao;
import br.com.ifpe.monitoramento.dao.UnidadeGestoraDao;

@Controller
public class MenuController {

	@RequestMapping("/FormLogin")
	public String formLogin() {
		return "login";
	}

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping("/listarHistorico")
	public String listarHistorico(String cpf, String nomeU, String data1, String data2, String objetoAlterado,
			Integer uGestora, String nome, String codigo, Model model) {
		HistoricoDao dao = new HistoricoDao();
		model.addAttribute("historico", dao.listarHistorico(cpf, nomeU, data1, data2, objetoAlterado, uGestora));
		UnidadeGestoraDao dao2 = new UnidadeGestoraDao();
		model.addAttribute("listarUGestora", dao2.listarUG(nome, codigo));
		return "historico/listarHistorico";
	}
}
