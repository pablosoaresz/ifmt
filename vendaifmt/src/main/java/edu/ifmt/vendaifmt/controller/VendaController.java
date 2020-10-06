package edu.ifmt.vendaifmt.controller;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.ifmt.vendaifmt.model.StatusVenda;
import edu.ifmt.vendaifmt.model.Venda;
import edu.ifmt.vendaifmt.repository.Vendas;

@Controller
@RequestMapping("/vendas")
class VendaController {

	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("CadastroVenda");
		mv.addObject(new Venda());
		return mv;
	}

	@ModelAttribute("todosStatusVenda")
	public List<StatusVenda> todosStatusVenda() {
		return Arrays.asList(StatusVenda.values());
	}

	@Autowired
	private Vendas vendas;

	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Venda venda, Errors errors, RedirectAttributes attributes) {
		if (errors.hasErrors()) {
			return "CadastroVenda";

		}
		vendas.save(venda);
		attributes.addFlashAttribute("mensagem", "Foi salvo com sucesso!");
		return "redirect:/vendas/novo";

	}

	@RequestMapping
	public ModelAndView pesquisar() {
		List<Venda> todosVendas = vendas.findAll();
		ModelAndView mv = new ModelAndView("PesquisaVendas");
		mv.addObject("vendas", todosVendas);
		return mv;
	}

	@RequestMapping("{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") Venda venda) {
		ModelAndView mv = new ModelAndView("CadastroVenda");
		mv.addObject(venda);
		return mv;
	}

	@RequestMapping(value = "{codigo}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long codigo, RedirectAttributes attributes) {
		vendas.deleteById(codigo);
		attributes.addFlashAttribute("mensagem", "Excluido com sucesso!");
		return "redirect:/vendas";

	}

}
