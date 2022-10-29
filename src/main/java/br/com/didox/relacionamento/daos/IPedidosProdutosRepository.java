package br.com.didox.relacionamento.daos;
import org.springframework.data.repository.CrudRepository;

import br.com.didox.relacionamento.models.PedidoProduto;

public interface IPedidosProdutosRepository extends CrudRepository<PedidoProduto, Integer> {
    
}
