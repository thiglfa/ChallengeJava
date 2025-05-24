package org.example.dto;

public class MotoResponseDTO {

    private Long id;
    private String placa;
    private String modelo;
    private int ano;
    private String cor;

    // Construtor
    public MotoResponseDTO(Long id, String placa, String modelo, int ano, String cor) {
        this.id = id;
        this.placa = placa;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public String getCor() {
        return cor;
    }
}
