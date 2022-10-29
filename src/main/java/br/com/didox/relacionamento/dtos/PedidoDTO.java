package br.com.didox.relacionamento.dtos;

import br.com.didox.relacionamento.models.Produto;

public class PedidoDTO {
    private double valorTotal;
    private int clienteId;
    private Iterable<Produto> produtos;

    public Iterable<Produto> getProdutos() {
        return produtos;
    }
    public void setProdutos(Iterable<Produto> produtos) {
        this.produtos = produtos;
    }
    public double getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    public int getClienteId() {
        return clienteId;
    }
    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }
}
