package br.ufpb.dcx.dsc.lumiislu.repository;

import java.util.List;

import br.ufpb.dcx.dsc.lumiislu.models.Paciente;
import br.ufpb.dcx.dsc.lumiislu.models.Psicologo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    List<Paciente> findByPsicologo(Psicologo psicologo);
    
}
