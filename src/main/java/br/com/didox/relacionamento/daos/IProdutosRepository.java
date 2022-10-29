package br.com.didox.relacionamento.daos;
import org.springframework.data.repository.CrudRepository;

import br.com.didox.relacionamento.models.Produto;

public interface IProdutosRepository extends CrudRepository<Produto, Integer> {
    
}
