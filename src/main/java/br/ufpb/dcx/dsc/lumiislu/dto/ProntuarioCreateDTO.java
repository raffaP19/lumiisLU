package br.ufpb.dcx.dsc.lumiislu.dto;

import jakarta.validation.constraints.NotBlank;

public class ProntuarioCreateDTO {

    @NotBlank(message = "A descrição da consulta não pode ser vazia")
    private String descricao_consulta;

    public String getDescricao_consulta() {
        return descricao_consulta;
    }

    public void setDescricao_consulta(String descricao_consulta) {
        this.descricao_consulta = descricao_consulta;
    }

}
