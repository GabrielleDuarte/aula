package br.com.gabrielle.aulas.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.gabrielle.aulas.entity.Aluno;

public interface AlunoDAO extends JpaRepository<Aluno, Long> {

	public Optional<Aluno> findByIdAndDeletedFalse(Long id);

	public Optional<List<Aluno>> findByDeletedFalse();

	@Query("SELECT a FROM Aluno a WHERE UPPER(a.nome) LIKE %?1%")
	public Optional<List<Aluno>> findByNomeLike(String nome);

}
