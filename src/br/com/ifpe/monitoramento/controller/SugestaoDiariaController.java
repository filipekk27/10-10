package br.com.ifpe.monitoramento.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ifpe.monitoramento.dao.CargoDao;
import br.com.ifpe.monitoramento.dao.CidadeDao;
import br.com.ifpe.monitoramento.dao.UnidadeGestoraDao;

@Controller
public class SugestaoDiariaController {

	
	@RequestMapping("/formCadastroSD")
	public String formCadastroSD(Model model , String nome , String id , String codigo){
		CargoDao dao = new CargoDao();
		model.addAttribute("listarCargoUsuario", dao.listarCargo(nome,id));
		UnidadeGestoraDao dao2 = new UnidadeGestoraDao();
		model.addAttribute("listarUGestora", dao2.listarUG(nome, codigo));
		CidadeDao dao3 = new CidadeDao();
		model.addAttribute("ListarEstados", dao3.listar());
		return "adm/FormCadastroSD";
	}
	
	@RequestMapping("/exibirCidade")
	public String exibirCidade(Model model , String nome , String id , String codigo , Integer cod_cidade){
		CargoDao dao = new CargoDao();
		model.addAttribute("listarCargoUsuario", dao.listarCargo(nome,id));
		UnidadeGestoraDao dao2 = new UnidadeGestoraDao();
		model.addAttribute("listarUGestora", dao2.listarUG(nome, codigo));
		CidadeDao dao3 = new CidadeDao();
		model.addAttribute("ListarEstados", dao3.listar());
		model.addAttribute("exibirCidade", dao3.listar2(cod_cidade));
		return "adm/FormCadastroSD";
	}
}
