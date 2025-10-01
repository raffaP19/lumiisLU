package br.ufpb.dcx.dsc.lumiislu.controller;

import br.ufpb.dcx.dsc.lumiislu.dto.PsicologoRegisterDTO;
import br.ufpb.dcx.dsc.lumiislu.dto.PsicologoResponseDTO;
import br.ufpb.dcx.dsc.lumiislu.models.Psicologo;
import br.ufpb.dcx.dsc.lumiislu.repository.PsicologoRepository;
import br.ufpb.dcx.dsc.lumiislu.services.PsicologoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final PsicologoService psicologoService;
    private final PsicologoRepository psicologoRepository;

    public AuthController(PsicologoService psicologoService, PsicologoRepository psicologoRepository) {
        this.psicologoService = psicologoService;
        this.psicologoRepository = psicologoRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<PsicologoResponseDTO> register(@Valid @RequestBody PsicologoRegisterDTO psicologoDTO) {
        Psicologo novoPsicologo = psicologoService.registrar(psicologoDTO);
        return new ResponseEntity<>(new PsicologoResponseDTO(novoPsicologo), HttpStatus.CREATED);
    }

    @GetMapping("/me")
    public ResponseEntity<PsicologoResponseDTO> getPsicologoLogado(Authentication authentication) {
        String email = authentication.getName();
        Psicologo psicologo = psicologoRepository.findByEmail(email).orElse(null);

        if (psicologo != null) {
            return ResponseEntity.ok(new PsicologoResponseDTO(psicologo));
        }
        return ResponseEntity.notFound().build();
    }

}