package br.com.didox.relacionamento.dtos;

public interface IPedidoClienteDTO {
    int getId();
    double getValor_total();
    int getCliente_id();
    String getNome();
    String getTelefone();
}
