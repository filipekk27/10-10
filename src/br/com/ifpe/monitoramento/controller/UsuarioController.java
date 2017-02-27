package br.com.ifpe.monitoramento.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ifpe.monitoramento.dao.CargoDao;
import br.com.ifpe.monitoramento.dao.KeyDuplicateException;
import br.com.ifpe.monitoramento.dao.UnidadeGestoraDao;
import br.com.ifpe.monitoramento.dao.UsuarioDao;
import br.com.ifpe.monitoramento.entidades.Usuario;

@Controller
public class UsuarioController {
     
	@RequestMapping("/formCadastro")
	public String formCadastro(Model model , String nome , String id , String codigo){
		CargoDao dao = new CargoDao();
		model.addAttribute("listarCargoUsuario", dao.listarCargo(nome,id));
		UnidadeGestoraDao dao2 = new UnidadeGestoraDao();
		model.addAttribute("listarUGestora", dao2.listarUG(nome, codigo));
		return "usuario/FormCadastroUsuario";
	}
	
	@RequestMapping("/cadastrarUsuario")
	public String cadastrarUsuario(@Valid Usuario user ,BindingResult rs , Model model){
		if(rs.hasFieldErrors()){
			return "forward:formCadastro";
		}
		UsuarioDao dao = new UsuarioDao();
		try {
			dao.CadastrarCargo(user);
			model.addAttribute("msgsucessoUser", "Usuario cadastado com sucesso!! ! ");
			return "sucesso/sucesso";
		} catch (KeyDuplicateException e) {
			model.addAttribute("msgErrorPkUser", "Cpf ou Email ja existe ! ! !");
			return "usuario/FormCadastroUsuario";
		}
	
	}
	
	@RequestMapping("/listarUsuario")
	public String exibirIncluirCargo(Usuario user , Model model){
		UsuarioDao dao = new UsuarioDao();
		model.addAttribute("ListarUsuario", dao.listarUsuario());
		return "usuario/ListarUsuario";
	}
}
