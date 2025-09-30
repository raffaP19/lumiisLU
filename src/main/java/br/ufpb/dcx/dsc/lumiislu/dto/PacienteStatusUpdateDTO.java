package br.ufpb.dcx.dsc.lumiislu.dto;

import jakarta.validation.constraints.NotBlank;

public class PacienteStatusUpdateDTO {

    @NotBlank(message = "O status não pode ser vazio")
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
