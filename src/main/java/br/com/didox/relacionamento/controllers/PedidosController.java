package br.com.didox.relacionamento.controllers;

import java.util.ArrayList;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.didox.relacionamento.daos.IClientesRepository;
import br.com.didox.relacionamento.daos.IPedidosRepository;
import br.com.didox.relacionamento.dtos.IPedidoClienteDTO;
import br.com.didox.relacionamento.dtos.PedidoDTO;
import br.com.didox.relacionamento.models.Cliente;
import br.com.didox.relacionamento.models.Pedido;

@CrossOrigin("*")
@RestController
public class PedidosController {

    @Autowired
    private IPedidosRepository repo;

    @Autowired
    private IClientesRepository repoClientes;

    @Autowired
    private EntityManager entityManager;

    @GetMapping("/pedidos")
    public Iterable<Pedido> index(){
        var pedidoComCliente = repo.todosComCliente();
        var pedidos = new ArrayList<Pedido>();
        for (IPedidoClienteDTO pedidoDTO : pedidoComCliente) {
            var pedido = new Pedido();
            pedido.setId(pedidoDTO.getId());
            pedido.setValorTotal(pedidoDTO.getValor_total());

            var cliente = new Cliente();
            cliente.setId(pedidoDTO.getCliente_id());
            cliente.setNome(pedidoDTO.getNome());
            cliente.setTelefone(pedidoDTO.getTelefone());

            pedido.setCliente(cliente);

            pedidos.add(pedido);
        }

        return pedidos;
    }

    @PostMapping("/pedidos")
    public ResponseEntity<Pedido> create(@RequestBody PedidoDTO pedidoDTO){
        if(!repoClientes.existsById(pedidoDTO.getClienteId()))
            return ResponseEntity.status(404).build();
        
        var cliente = repoClientes.findById(pedidoDTO.getClienteId()).get();
        var clienteRef = entityManager.getReference(Cliente.class, cliente.getId());

        var pedido = new Pedido();
        pedido.setValorTotal(pedidoDTO.getValorTotal());
        pedido.setCliente(clienteRef);

        repo.save(pedido);
        return ResponseEntity.status(201).body(pedido);
    }

    @PutMapping("/pedidos/{id}")
    public ResponseEntity<Pedido> update(@PathVariable int id, @RequestBody Pedido pedido){
        if(!repo.existsById(id)) return ResponseEntity.status(404).build();

        var pedidoDb = repo.findById(id).get();
        pedidoDb.setValorTotal(pedido.getValorTotal());
        repo.save(pedidoDb);

        return ResponseEntity.status(200).body(pedidoDb);
    }

    @DeleteMapping("/pedidos/{id}")
    public ResponseEntity<Pedido> delete(@PathVariable int id){
        if(!repo.existsById(id)) return ResponseEntity.status(404).build();

        repo.deleteById(id);
        return ResponseEntity.status(204).build();
    }
}
