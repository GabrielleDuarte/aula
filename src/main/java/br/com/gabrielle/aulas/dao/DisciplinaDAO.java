package br.com.gabrielle.aulas.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gabrielle.aulas.entity.Disciplina;

public interface DisciplinaDAO extends JpaRepository<Disciplina, Long> {

}
