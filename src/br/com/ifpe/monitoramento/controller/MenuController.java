package br.com.ifpe.monitoramento.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ifpe.monitoramento.dao.HistoricoDao;

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
	public String listarHistorico(String idUsuarioAutor, String DataCadastro, Model model) {
		HistoricoDao dao = new HistoricoDao();
		model.addAttribute("historico", dao.listarHistorico(idUsuarioAutor, DataCadastro));
		return "historico/listarHistorico";
	}
}
