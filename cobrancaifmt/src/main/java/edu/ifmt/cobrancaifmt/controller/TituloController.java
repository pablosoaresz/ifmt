package edu.ifmt.cobrancaifmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import edu.ifmt.cobrancaifmt.model.Titulo;
import edu.ifmt.cobrancaifmt.repository.Titulos;

@Controller
@RequestMapping("/titulos")
class TituloController {

	@RequestMapping("/novo")
	public String novo() {
		return "CadastroTitulo";
	}

	@Autowired
	private Titulos titulos;

	@RequestMapping(method = RequestMethod.POST)
	public String salvar(Titulo titulo) {
		titulos.save(titulo);
		return "CadastroTitulo";

	}

}
