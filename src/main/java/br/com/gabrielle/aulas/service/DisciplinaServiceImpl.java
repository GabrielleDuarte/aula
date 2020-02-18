package br.com.gabrielle.aulas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gabrielle.aulas.dao.DisciplinaDAO;
import br.com.gabrielle.aulas.entity.Disciplina;

@Service
public class DisciplinaServiceImpl implements DisciplinaService {

	@Autowired
	private DisciplinaDAO disciplinaDao;

	@Override
	public void addDiscipina(Disciplina disciplina) {
		disciplinaDao.save(disciplina);
	}

}
