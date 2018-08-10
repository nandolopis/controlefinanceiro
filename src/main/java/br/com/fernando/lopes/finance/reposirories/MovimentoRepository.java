package br.com.fernando.lopes.finance.reposirories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fernando.lopes.finance.entities.Movimento;

@Repository
public interface MovimentoRepository extends JpaRepository<Movimento, Integer>{

}
