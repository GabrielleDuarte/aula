package br.com.gabrielle.aulas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gabrielle.aulas.dao.AlunoDAO;
import br.com.gabrielle.aulas.entity.Aluno;
import br.com.gabrielle.aulas.exceptions.AulaException;

@Service
public class AlunoServiceImpl implements AlunoService {

	@Autowired
	private AlunoDAO alunoDAO;

	@Override
	public List<Aluno> findAll() {
		List<Aluno> alunos = alunoDAO.findByDeletedFalse()
				.orElseThrow(() -> new AulaException("Nenhum aluno encontrado."));
		return alunos;
	}

	@Override
	public Aluno findById(Long id) {
		Aluno aluno = alunoDAO.findByIdAndDeletedFalse(id).orElse(new Aluno());
		return aluno;
	}

	@Override
	public void addAluno(Aluno aluno) {
		aluno.setDeleted(false);
		alunoDAO.save(aluno);
	}

	@Override
	public void updateAluno(Long id, Aluno alunoNew) {
		Aluno aluno = alunoDAO.findByIdAndDeletedFalse(id)
				.orElseThrow(() -> new AulaException("Este Aluno não está cadastrado no sistema"));
		aluno.setNome(alunoNew.getNome());
		aluno.setCurso(alunoNew.getCurso());
		alunoDAO.save(aluno);

	}

	@Override
	public void deleteAluno(Long id) {
		Aluno aluno = alunoDAO.findByIdAndDeletedFalse(id)
				.orElseThrow(() -> new AulaException("Este Aluno não está cadastrado no sistema"));
		aluno.setDeleted(true);
		alunoDAO.save(aluno);
	}

	@Override
	public List<Aluno> findByName(String nome) {
		List<Aluno> alunos = alunoDAO.findByNomeLike(nome.toUpperCase())
				.orElseThrow(() -> new AulaException("Não existe aluno com esse nome"));
		return alunos;
	}

}