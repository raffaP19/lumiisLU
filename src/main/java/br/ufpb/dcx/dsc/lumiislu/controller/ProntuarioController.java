package br.ufpb.dcx.dsc.lumiislu.controller;

import br.ufpb.dcx.dsc.lumiislu.dto.ProntuarioCreateDTO;
import br.ufpb.dcx.dsc.lumiislu.dto.ProntuarioResponseDTO;
import br.ufpb.dcx.dsc.lumiislu.models.Prontuario;
import br.ufpb.dcx.dsc.lumiislu.services.ProntuarioService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProntuarioController {

    private final ProntuarioService prontuarioService;
    private final ModelMapper modelMapper;

    public ProntuarioController(ProntuarioService prontuarioService, ModelMapper modelMapper) {
        this.prontuarioService = prontuarioService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/pacientes/{pacienteId}/prontuarios")
    public ResponseEntity<ProntuarioResponseDTO> criarProntuario(@PathVariable Long pacienteId, @Valid @RequestBody ProntuarioCreateDTO prontuarioDTO) {
        Prontuario novoProntuario = prontuarioService.criarProntuario(prontuarioDTO.getDescricao_consulta(), pacienteId);
        if (novoProntuario != null) {
            return new ResponseEntity<>(modelMapper.map(novoProntuario, ProntuarioResponseDTO.class), HttpStatus.CREATED);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/pacientes/{pacienteId}/prontuarios")
    public List<ProntuarioResponseDTO> listarProntuarios(@PathVariable Long pacienteId) {
        return prontuarioService.listarProntuarios(pacienteId).stream()
                .map(prontuario -> modelMapper.map(prontuario, ProntuarioResponseDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/prontuarios/{id}")
    public ResponseEntity<ProntuarioResponseDTO> buscarProntuarioPorId(@PathVariable Long id) {
        Prontuario prontuario = prontuarioService.buscarProntuarioPorId(id);
        if (prontuario != null) {
            return ResponseEntity.ok(modelMapper.map(prontuario, ProntuarioResponseDTO.class));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/prontuarios/{id}")
    public ResponseEntity<ProntuarioResponseDTO> atualizarProntuario(@PathVariable Long id, @Valid @RequestBody ProntuarioCreateDTO prontuarioDTO) {
        Prontuario prontuarioAtualizado = prontuarioService.atualizarProntuario(id, prontuarioDTO.getDescricao_consulta());
        if (prontuarioAtualizado != null) {
            return ResponseEntity.ok(modelMapper.map(prontuarioAtualizado, ProntuarioResponseDTO.class));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/prontuarios/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarProntuario(@PathVariable Long id) {
        prontuarioService.deletarProntuario(id);
    }

}
