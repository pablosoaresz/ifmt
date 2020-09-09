package edu.ifmt.cobrancaifmt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.ifmt.cobrancaifmt.model.Titulo;

@Controller
@RequestMapping("/titulos")
class TituloController {

	@RequestMapping("/novo")
	public String novo() {
		return "CadastroTitulo";
	}

	@RequestMapping(method = RequestMethod.POST)
	public void salvar(Titulo titulo) {

	}

}
