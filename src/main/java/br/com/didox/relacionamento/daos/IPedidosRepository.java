package br.com.didox.relacionamento.daos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.didox.relacionamento.dtos.IPedidoClienteDTO;
import br.com.didox.relacionamento.models.Pedido;

public interface IPedidosRepository extends CrudRepository<Pedido, Integer> {

    @Query(value="select pedidos.*, clientes.nome, clientes.telefone, produtos.id as produto_id, produtos.nome as nome_produto, produtos.descricao as descricao_produto, produtos.valor as valor_produto  from pedidos inner join clientes on clientes.id = pedidos.cliente_id inner join pedidos_produtos on pedidos_produtos.pedido_id = pedidos.id inner join produtos on produtos.id= pedidos_produtos.produtos_id order by pedidos.id;", nativeQuery = true)
    public Iterable<IPedidoClienteDTO> todosComCliente();
}


