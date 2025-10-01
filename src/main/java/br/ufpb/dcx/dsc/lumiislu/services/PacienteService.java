package br.ufpb.dcx.dsc.lumiislu.services;

import br.ufpb.dcx.dsc.lumiislu.dto.PacienteCreateDTO;
import br.ufpb.dcx.dsc.lumiislu.models.Paciente;
import br.ufpb.dcx.dsc.lumiislu.models.Psicologo;
import br.ufpb.dcx.dsc.lumiislu.repository.PacienteRepository;
import br.ufpb.dcx.dsc.lumiislu.repository.PsicologoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;
    private final PsicologoRepository psicologoRepository;

    public PacienteService(PacienteRepository pacienteRepository, PsicologoRepository psicologoRepository) {
        this.pacienteRepository = pacienteRepository;
        this.psicologoRepository = psicologoRepository;
    }

    public Paciente cadastrarPaciente(PacienteCreateDTO pacienteDTO, Psicologo psicologo) {
        Paciente novoPaciente = new Paciente(
                pacienteDTO.getNome(), pacienteDTO.getCpf(), pacienteDTO.getEmail(),
                pacienteDTO.getDescricao(), pacienteDTO.getRua(), pacienteDTO.getComplemento(),
                pacienteDTO.getCidade(), pacienteDTO.getEstado(), psicologo
        );
        return pacienteRepository.save(novoPaciente);
    }

    public List<Paciente> listarTodosPacientes() {
        return pacienteRepository.findAll();
    }

    public Paciente buscarPacientePorId(Long id) {
        return pacienteRepository.findById(id).orElse(null);
    }

    public Paciente atualizarPaciente(Long id, Paciente dadosPaciente) {
        Optional<Paciente> pacienteOpt = pacienteRepository.findById(id);
        if (pacienteOpt.isPresent()) {
            Paciente pacienteParaAtualizar = pacienteOpt.get();

            pacienteParaAtualizar.setUsername(dadosPaciente.getUsername());
            pacienteParaAtualizar.setCpf(dadosPaciente.getCpf());
            pacienteParaAtualizar.setEmail(dadosPaciente.getEmail());
            pacienteParaAtualizar.setDescricao(dadosPaciente.getDescricao());
            pacienteParaAtualizar.setStatus(dadosPaciente.getStatus());

            pacienteParaAtualizar.setRua(dadosPaciente.getRua());
            pacienteParaAtualizar.setComplemento(dadosPaciente.getComplemento());
            pacienteParaAtualizar.setCidade(dadosPaciente.getCidade());
            pacienteParaAtualizar.setEstado(dadosPaciente.getEstado());

            return pacienteRepository.save(pacienteParaAtualizar);
        }
        return null;
    }

    public Paciente alterarStatus (Long id, String novoStatus){
        Paciente paciente = this.buscarPacientePorId(id);
        if (paciente != null) {
            paciente.setStatus(novoStatus);
            return pacienteRepository.save(paciente);
        }
        return null;
    }

    public void deletarPaciente (Long id){
        if (pacienteRepository.existsById(id)) {
            pacienteRepository.deleteById(id);
        }
    }

}