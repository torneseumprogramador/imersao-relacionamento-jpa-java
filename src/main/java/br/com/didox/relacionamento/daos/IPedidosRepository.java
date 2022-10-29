package br.com.didox.relacionamento.daos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.didox.relacionamento.dtos.IPedidoClienteDTO;
import br.com.didox.relacionamento.models.Pedido;

public interface IPedidosRepository extends CrudRepository<Pedido, Integer> {

    @Query(value="select pedidos.*, clientes.nome, clientes.telefone from pedidos inner join clientes on clientes.id = pedidos.cliente_id", nativeQuery = true)
    public Iterable<IPedidoClienteDTO> todosComCliente();
}
