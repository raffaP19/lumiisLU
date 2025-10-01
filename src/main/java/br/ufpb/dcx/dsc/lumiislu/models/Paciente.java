package br.ufpb.dcx.dsc.lumiislu.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paciente_id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(unique = true)
    private String cpf;

    @Column(unique = true)
    private String email;

    @Lob
    private String descricao;

    private String status;
    
    private String rua;

    private String complemento;

    private String cidade; 

    private String estado;

    @ManyToOne
    @JoinColumn(name = "psicologo_id")
    private Psicologo psicologo;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Prontuario> prontuarios;

    public Paciente() {}

    public Paciente(String username, String cpf, String email, String descricao, String rua, String complemento, String cidade, String estado, Psicologo psicologo) {
        this.username = username;
        this.cpf = cpf;
        this.email = email;
        this.descricao = descricao;
        this.rua = rua;
        this.complemento = complemento;
        this.cidade = cidade;
        this.estado = estado;
        this.psicologo = psicologo;
        this.status = "ATIVO";
    }

    public Long getPaciente_id() {
        return paciente_id;
    }

    public void setPaciente_id(Long paciente_id) {
        this.paciente_id = paciente_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Psicologo getPsicologo() {
        return psicologo;
    }

    public void setPsicologo(Psicologo psicologo) {
        this.psicologo = psicologo;
    }

    public List<Prontuario> getProntuarios() {
        return prontuarios;
    }

    public void setProntuarios(List<Prontuario> prontuarios) {
        this.prontuarios = prontuarios;
    }

}
