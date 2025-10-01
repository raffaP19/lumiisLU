package br.ufpb.dcx.dsc.lumiislu.dto;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

public class PsicologoRegisterDTO {

    @NotBlank(message = "O nome não pode ser vazio")
    private String nome;

    @NotBlank(message = "O email não pode ser vazio")
    @Email(message = "Formato de email inválido")
    private String email;

    @NotBlank(message = "A senha não pode ser vazia")
    @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres")
    private String senha;

    @NotBlank(message = "O CPF não pode ser vazio")
    @CPF
    private String cpf;
    
    private String telefone;

    private String formacao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

}