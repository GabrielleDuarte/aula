package br.com.gabrielle.aulas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.gabrielle.aulas.dao.ProfessorDAO;
import br.com.gabrielle.aulas.entity.Professor;
import br.com.gabrielle.aulas.exceptions.AulaException;

@Service
public class ProfessorServiceImpl implements ProfessorService {

	@Autowired
	private ProfessorDAO professorDAO;

	@Override
	public List<Professor> findAll() {
		List<Professor> professores = professorDAO.findAll();
		return professores;
	}

	@Override
	public Professor findById(Long id) {
		Professor professor = professorDAO.findById(id).orElse(new Professor());
		return professor;
	}

	@Override
	public void addProfessor(Professor professor) {
		professorDAO.save(professor);
	}

	@Override
	public void deleteProfessor(Long id) {
		Professor professor = professorDAO.findById(id)
				.orElseThrow(() -> new AulaException("Professor não cadastrado"));
		professorDAO.delete(professor);
	}

	@Override
	public void updateProfessor(Long id, Professor professor) {
		Professor p = professorDAO.findById(id)
				.orElseThrow(() -> new AulaException("Professor não cadastrado"));
		p.setNome(professor.getNome());
		professorDAO.save(p);
	}

}
