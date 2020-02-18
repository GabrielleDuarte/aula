package br.com.gabrielle.aulas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gabrielle.aulas.dao.NotaDAO;
import br.com.gabrielle.aulas.entity.Nota;

@Service
public class NotaServiceImpl implements NotaService {

	@Autowired
	private NotaDAO notaDAO;

	@Override
	public void addNota(Nota nota) {
		notaDAO.save(nota);
	}

}
