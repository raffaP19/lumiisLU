package br.ufpb.dcx.dsc.lumiislu.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public class LoginRequestDTO {

    @NotBlank(message = "O email não pode ser vazio")
    @Email
    private String email;

    @NotBlank(message = "A senha não pode ser vazia")
    private String senha;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
