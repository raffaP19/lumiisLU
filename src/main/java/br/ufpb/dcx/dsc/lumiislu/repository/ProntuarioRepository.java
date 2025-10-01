package br.ufpb.dcx.dsc.lumiislu.repository;

import java.util.List;

import br.ufpb.dcx.dsc.lumiislu.models.Paciente;
import br.ufpb.dcx.dsc.lumiislu.models.Prontuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProntuarioRepository extends JpaRepository<Prontuario, Long> {
    List<Prontuario> findByPaciente(Paciente paciente);
}
