package br.com.gabrielle.aulas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.gabrielle.aulas.entity.Disciplina;
import br.com.gabrielle.aulas.service.DisciplinaService;

@Controller
public class DisciplinaController {

	@Autowired
	private DisciplinaService disciplinaService;

	@PostMapping(value = "disciplina/salvar")
	public ResponseEntity<Void> disciplinaSave(@RequestBody Disciplina disciplina) {
		disciplinaService.addDiscipina(disciplina);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
