package br.ufpb.dcx.dsc.lumiislu.services;

import br.ufpb.dcx.dsc.lumiislu.models.Paciente;
import br.ufpb.dcx.dsc.lumiislu.models.Prontuario;
import br.ufpb.dcx.dsc.lumiislu.repository.PacienteRepository;
import br.ufpb.dcx.dsc.lumiislu.repository.ProntuarioRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProntuarioService {

    private final ProntuarioRepository prontuarioRepository;
    private final PacienteRepository pacienteRepository;

    public ProntuarioService(ProntuarioRepository prontuarioRepository, PacienteRepository pacienteRepository) {
        this.prontuarioRepository = prontuarioRepository;
        this.pacienteRepository = pacienteRepository;
    }

    public Prontuario criarProntuario(String descricao, Long pacienteId) {
        Optional<Paciente> pacienteOpt = pacienteRepository.findById(pacienteId);
        if (pacienteOpt.isPresent()) {
            Paciente paciente = pacienteOpt.get();
            Prontuario novoProntuario = new Prontuario(descricao, paciente, paciente.getPsicologo());
            return prontuarioRepository.save(novoProntuario);
        }
        return null;
    }

    public List<Prontuario> listarProntuarios(Long pacienteId) {
        Paciente paciente = pacienteRepository.getReferenceById(pacienteId);
        return prontuarioRepository.findByPaciente(paciente);
    }

    public Prontuario buscarProntuarioPorId(Long id) {
        return prontuarioRepository.findById(id).orElse(null);
    }

    public Prontuario atualizarProntuario(Long id, String novaDescricao) {
        Optional<Prontuario> prontuarioOpt = prontuarioRepository.findById(id);
        if (prontuarioOpt.isPresent()) {
            Prontuario prontuario = prontuarioOpt.get();
            prontuario.setDescricao_consulta(novaDescricao);
            return prontuarioRepository.save(prontuario);
        }
        return null;
    }

    public void deletarProntuario(Long id) {
        if (prontuarioRepository.existsById(id)) {
            prontuarioRepository.deleteById(id);
        }
    }

}
