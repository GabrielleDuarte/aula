package br.com.gabrielle.aulas.service;

import java.util.List;

import br.com.gabrielle.aulas.entity.Aluno;

public interface AlunoService {

	public List<Aluno> findAll();

	public Aluno findById(Long id);

	public void addAluno(Aluno aluno);

	public void updateAluno(Long id, Aluno aluno);

	public void deleteAluno(Long id);
	
	public List<Aluno> findByName(String nome);
		  

}
