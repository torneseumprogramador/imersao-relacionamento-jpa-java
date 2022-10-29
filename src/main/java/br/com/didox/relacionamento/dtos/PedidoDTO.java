package br.com.didox.relacionamento.dtos;

public class PedidoDTO {
    private double valorTotal;
    private int clienteId;

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
