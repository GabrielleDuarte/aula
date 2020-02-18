package br.com.gabrielle.aulas.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gabrielle.aulas.entity.Professor;

public interface ProfessorDAO extends JpaRepository<Professor, Long> {

}
