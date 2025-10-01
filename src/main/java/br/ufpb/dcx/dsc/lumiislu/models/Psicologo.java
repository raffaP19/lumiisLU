package br.ufpb.dcx.dsc.lumiislu.models;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
public class Psicologo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long psicologo_id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String cpf;

    private String telefone;

    private String formacao;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "psicologo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Paciente> pacientes;

    public Psicologo(String username, String email, String cpf, String password, String telefone, String formacao) {
        this.username = username;
        this.email = email;
        this.cpf = cpf;
        this.password = password;
        this.telefone = telefone;
        this.formacao = formacao;
    }

    public Long getPsicologo_id() {
        return psicologo_id;
    }

    public void setPsicologo_id(Long psicologo_id) {
        this.psicologo_id = psicologo_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

}
