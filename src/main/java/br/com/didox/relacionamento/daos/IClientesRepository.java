package br.com.didox.relacionamento.daos;
import org.springframework.data.repository.CrudRepository;

import br.com.didox.relacionamento.models.Cliente;

public interface IClientesRepository extends CrudRepository<Cliente, Integer> {
    
}
