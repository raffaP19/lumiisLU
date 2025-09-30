package br.ufpb.dcx.dsc.lumiislu.dto;

import java.time.LocalDateTime;

public class ProntuarioResponseDTO {

    private Long id;
    private String descricao_consulta;
    private LocalDateTime dataConsulta;
    private Long pacienteId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao_consulta() {
        return descricao_consulta;
    }

    public void setDescricao_consulta(String descricao_consulta) {
        this.descricao_consulta = descricao_consulta;
    }

    public LocalDateTime getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDateTime dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }

}
