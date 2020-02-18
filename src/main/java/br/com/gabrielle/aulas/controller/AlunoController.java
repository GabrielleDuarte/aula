package br.com.gabrielle.aulas.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.gabrielle.aulas.entity.Aluno;
import br.com.gabrielle.aulas.service.AlunoService;

@Controller
public class AlunoController {

	private final String ALUNO_INDEX = "/alunos";

	@Autowired
	private AlunoService alunoService;

	@GetMapping(value = "/aluno/{id}")
	public String alunoShow(Model model, @PathVariable Long id) {
		model.addAttribute("aluno", alunoService.findById(id));
		return "aluno";
	}

	@GetMapping(value = ALUNO_INDEX)
	public String index(Model model) {
		model.addAttribute("alunos", alunoService.findAll());
		model.addAttribute("aluno", new Aluno());

		return "index";
	}

	@PostMapping(value = ALUNO_INDEX)
	public String busca(Model model, @ModelAttribute Aluno aluno) {
		model.addAttribute("alunos", alunoService.findByName(aluno.getNome()));
		model.addAttribute("aluno", new Aluno());
		return "index";

	}

	@PostMapping(value = "aluno/salvar")
	public String alunoSave(@ModelAttribute Aluno aluno) {
		alunoService.addAluno(aluno);
		return "redirect:" + ALUNO_INDEX;
	}

	@GetMapping(value = "aluno/cadastrar")
	public String cadastro(Model model) {
		model.addAttribute("aluno", new Aluno());
		return "cadastrar";

	}

	@GetMapping(value = "aluno/editar/{id}")
	public String editar(Model model, @PathVariable Long id) {
		model.addAttribute("aluno", alunoService.findById(id));
		return "editar";
	}

	@PostMapping(value = "aluno/atualizar/{id}")
	public String atulizar(@ModelAttribute("aluno") Aluno aluno, @PathVariable Long id) {
		alunoService.updateAluno(id, aluno);
		return "redirect:" + ALUNO_INDEX;
	}
	
	@PostMapping(value = "aluno/excluir/{id}")
	public String excluir(@PathVariable Long id) {
		alunoService.deleteAluno(id);
		return "redirect:" + ALUNO_INDEX;
	}

}
