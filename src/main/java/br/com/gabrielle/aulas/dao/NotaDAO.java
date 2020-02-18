package br.com.gabrielle.aulas.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gabrielle.aulas.entity.Nota;

public interface NotaDAO extends JpaRepository<Nota, Long> {

}
