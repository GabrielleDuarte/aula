package br.com.gabrielle.aulas.service;

import java.util.List;

import br.com.gabrielle.aulas.entity.Professor;

public interface ProfessorService {

	public List<Professor> findAll();

	public Professor findById(Long id);

	public void addProfessor(Professor professor);

	public void updateProfessor(Long id, Professor professor);

	public void deleteProfessor(Long id);

}
