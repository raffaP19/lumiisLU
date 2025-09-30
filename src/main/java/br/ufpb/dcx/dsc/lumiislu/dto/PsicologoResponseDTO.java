package br.ufpb.dcx.dsc.lumiislu.dto;

import br.ufpb.dcx.dsc.lumiislu.models.Psicologo;

public class PsicologoResponseDTO {

    private Long id;
    private String nome;
    private String email;

    public PsicologoResponseDTO(Psicologo psicologo) {
        this.id = psicologo.getPsicologo_ID();
        this.nome = psicologo.getUsername();
        this.email = psicologo.getEmail();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

}
