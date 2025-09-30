package br.ufpb.dcx.dsc.lumiislu.repository;

import java.util.Optional;

import br.ufpb.dcx.dsc.lumiislu.models.Psicologo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PsicologoRepository extends JpaRepository<Psicologo, Long> {
    Optional<Psicologo> findByEmail(String email);

}
