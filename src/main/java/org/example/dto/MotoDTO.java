package org.example.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;

@Getter
public class MotoDTO {

    private Long id;

    @NotBlank(message = "Placa é obrigatória")
    @Size(min = 7, max = 8, message = "Placa deve ter entre 7 e 8 caracteres")
    private String placa;

    @NotBlank(message = "Modelo é obrigatório")
    private String modelo;

    @Min(value = 1900, message = "Ano deve ser maior ou igual a 1900")
    @Max(value = 2100, message = "Ano deve ser menor ou igual a 2100")
    private int ano;

    @NotBlank(message = "Cor é obrigatória")
    private String cor;

    public void setId(Long id) {
        this.id = id;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}

