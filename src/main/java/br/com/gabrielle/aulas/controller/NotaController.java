package br.com.gabrielle.aulas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.gabrielle.aulas.entity.Nota;
import br.com.gabrielle.aulas.service.NotaService;

@Controller
public class NotaController {

	@Autowired
	private NotaService notaService;

	@PostMapping(value = "nota/salvar")
	public ResponseEntity<Void> notaSave(@RequestBody Nota nota) {
		notaService.addNota(nota);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}
}
