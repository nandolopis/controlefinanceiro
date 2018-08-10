package br.com.fernando.lopes.finance.reposirories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fernando.lopes.finance.entities.Categoria;
/*
 * JpaRepository acessa os dado com base do tipo Categoria e o tipo do atributo identificador que no caso e tipo do id 
 * da classe categoria 
 */
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
