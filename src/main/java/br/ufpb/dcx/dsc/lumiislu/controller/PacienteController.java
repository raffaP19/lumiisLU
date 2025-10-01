package br.ufpb.dcx.dsc.lumiislu.controller;

import br.ufpb.dcx.dsc.lumiislu.dto.PacienteCreateDTO;
import br.ufpb.dcx.dsc.lumiislu.dto.PacienteResponseDTO;
import br.ufpb.dcx.dsc.lumiislu.dto.PacienteStatusUpdateDTO;
import br.ufpb.dcx.dsc.lumiislu.models.Paciente;
import br.ufpb.dcx.dsc.lumiislu.models.Psicologo;
import br.ufpb.dcx.dsc.lumiislu.repository.PsicologoRepository;
import br.ufpb.dcx.dsc.lumiislu.services.PacienteService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;
    private final PsicologoRepository psicologoRepository;
    private final ModelMapper modelMapper;

    public PacienteController(PacienteService pacienteService, PsicologoRepository psicologoRepository, ModelMapper modelMapper) {
        this.pacienteService = pacienteService;
        this.psicologoRepository = psicologoRepository;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<PacienteResponseDTO> criarPaciente(@Valid @RequestBody PacienteCreateDTO pacienteDTO, Authentication authentication) {
        String emailPsicologo = authentication.getName();
        Psicologo psicologo = psicologoRepository.findByEmail(emailPsicologo).orElse(null);
        if (psicologo == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        Paciente novoPaciente = pacienteService.cadastrarPaciente(pacienteDTO, psicologo);
        return new ResponseEntity<>(modelMapper.map(novoPaciente, PacienteResponseDTO.class), HttpStatus.CREATED);
    }

    @GetMapping
    public List<PacienteResponseDTO> listarPacientes() {
        return pacienteService.listarTodosPacientes().stream()
                .map(paciente -> modelMapper.map(paciente, PacienteResponseDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponseDTO> buscarPacientePorId(@PathVariable Long id) {
        Paciente paciente = pacienteService.buscarPacientePorId(id);
        if (paciente != null) {
            return ResponseEntity.ok(modelMapper.map(paciente, PacienteResponseDTO.class));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteResponseDTO> atualizarPaciente(@PathVariable Long id, @Valid @RequestBody PacienteCreateDTO pacienteUpdateDTO) {
        Paciente dadosPaciente = modelMapper.map(pacienteUpdateDTO, Paciente.class);
        Paciente pacienteAtualizado = pacienteService.atualizarPaciente(id, dadosPaciente);
        if (pacienteAtualizado != null) {
            return ResponseEntity.ok(modelMapper.map(pacienteAtualizado, PacienteResponseDTO.class));
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<PacienteResponseDTO> alterarStatus(@PathVariable Long id, @Valid @RequestBody PacienteStatusUpdateDTO statusDTO) {
        Paciente pacienteAtualizado = pacienteService.alterarStatus(id, statusDTO.getStatus());
        if (pacienteAtualizado != null) {
            return ResponseEntity.ok(modelMapper.map(pacienteAtualizado, PacienteResponseDTO.class));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPaciente(@PathVariable Long id) {
        pacienteService.deletarPaciente(id);
    }

}
