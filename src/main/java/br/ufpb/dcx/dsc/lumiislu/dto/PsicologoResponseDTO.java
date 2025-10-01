package br.ufpb.dcx.dsc.lumiislu.dto;

import br.ufpb.dcx.dsc.lumiislu.models.Psicologo;

public class PsicologoResponseDTO {

    private Long id;
    private String username;
    private String email;

    public PsicologoResponseDTO(Psicologo psicologo) {
        this.id = psicologo.getPsicologo_id();
        this.username = psicologo.getUsername();
        this.email = psicologo.getEmail();
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

}
