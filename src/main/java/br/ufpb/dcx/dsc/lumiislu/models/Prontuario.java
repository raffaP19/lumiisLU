package br.ufpb.dcx.dsc.lumiislu.models;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
public class Prontuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prontuario_id;

    @Lob
    private String descricao_consulta;
    
    private LocalDateTime dataConsulta;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
    
    @ManyToOne
    @JoinColumn(name = "psicologo_id")
    private Psicologo psicologo;

    public Prontuario(){}

    public Prontuario(String descricao_consulta, Paciente paciente, Psicologo psicologo) {
        this.descricao_consulta = descricao_consulta;
        this.paciente = paciente;
        this.psicologo = psicologo;
        this.dataConsulta = LocalDateTime.now();
    }

    public Long getProntuario_id() {
        return prontuario_id;
    }

    public void setProntuario_id(Long prontuario_id) {
        this.prontuario_id = prontuario_id;
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

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Psicologo getPsicologo() {
        return psicologo;
    }

    public void setPsicologo(Psicologo psicologo) {
        this.psicologo = psicologo;
    }

}
