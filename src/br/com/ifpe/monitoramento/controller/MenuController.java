package br.com.ifpe.monitoramento.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenuController {

	
	@RequestMapping("/FormLogin")
	public String formLogin(){
		return "login";
	}
	@RequestMapping("/index")
	public String index(){
		return "index";
	}
}
