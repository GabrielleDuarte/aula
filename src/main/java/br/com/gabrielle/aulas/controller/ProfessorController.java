package br.com.gabrielle.aulas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.gabrielle.aulas.entity.Aluno;
import br.com.gabrielle.aulas.entity.Professor;
import br.com.gabrielle.aulas.service.AlunoService;
import br.com.gabrielle.aulas.service.ProfessorService;

@Controller
public class ProfessorController {

	@Autowired
	private ProfessorService professorService;
	
	@GetMapping(value = "professores")
	public String index(Model model) {
		model.addAttribute("professores", professorService.findAll());
		model.addAttribute("professor", new Aluno());

		return "prof";
	}
	
	@GetMapping(value = "professor/cadastrar")
	public String cadastrar (Model model) {
		model.addAttribute("professor", new Professor());
		return "cadastrarProfessor";
	}
	
	@PostMapping(value = "professor/salvar")
	public String salvar(@ModelAttribute Professor professor){
		professorService.addProfessor(professor);
		return "redirect:" + "/professores";
	}
	
	@GetMapping(value = "/professor/{id}")
	public String professor(Model model, @PathVariable Long id) {
		model.addAttribute("professor", professorService.findById(id));
		return "professor";
	}
	
	@GetMapping(value = "professor/editar{id}")
	public String editar(Model model, @PathVariable Long id) {
		model.addAttribute("professor", professorService.findById(id));
		return "editarProfessor";
	}
	
	@PostMapping(value = "professor/atualizar/{id}")
	public String atualizar(@ModelAttribute("professor") Professor professor, @PathVariable Long id) {
		professorService.updateProfessor(id, professor);
		return "redirect:" + "/professores";
	}
	
	@PostMapping(value = "professor/excluir/{id}")
	public String excluir(@PathVariable Long id) {
		professorService.deleteProfessor(id); 
		return "redirect:" + "/professores";
	}


}
