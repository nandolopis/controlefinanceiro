package br.com.fernando.lopes.finance.reposirories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.fernando.lopes.finance.entities.Cliente;
import br.com.fernando.lopes.finance.entities.Movimento;

@Repository
public interface MovimentoRepository extends JpaRepository<Movimento, Integer>{
	
	//@Transactional(readOnly=true)
	//Page<Movimento> findByCliente(Cliente cliente, Pageable pageRequest);
	

}
