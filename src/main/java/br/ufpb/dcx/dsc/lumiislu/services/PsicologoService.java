package br.ufpb.dcx.dsc.lumiislu.services;

import br.ufpb.dcx.dsc.lumiislu.dto.PsicologoRegisterDTO;
import br.ufpb.dcx.dsc.lumiislu.models.Psicologo;
import br.ufpb.dcx.dsc.lumiislu.repository.PsicologoRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class PsicologoService {

    private final PsicologoRepository psicologoRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public PsicologoService(PsicologoRepository psicologoRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.psicologoRepository = psicologoRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public Psicologo registrar(PsicologoRegisterDTO psicologoDTO) {
        Psicologo novoPsicologo = new Psicologo(
                psicologoDTO.getNome(),
                psicologoDTO.getEmail(),
                psicologoDTO.getCpf(),
                bCryptPasswordEncoder.encode(psicologoDTO.getSenha()),
                psicologoDTO.getTelefone(),
                psicologoDTO.getFormacao()
        );
        return psicologoRepository.save(novoPsicologo);
    }

    public Psicologo buscarPorId(Long id) {
        return psicologoRepository.getReferenceById(id);
    }

    public Psicologo atualizarDados(Long id, Psicologo dadosAtualizados) {
        Optional<Psicologo> psicologoOpt = psicologoRepository.findById(id);
        if (psicologoOpt.isPresent()) {
            Psicologo psicologoParaAtualizar = psicologoOpt.get();
            psicologoParaAtualizar.setUsername(dadosAtualizados.getUsername());
            psicologoParaAtualizar.setEmail(dadosAtualizados.getEmail());
            psicologoParaAtualizar.setTelefone(dadosAtualizados.getTelefone());
            psicologoParaAtualizar.setFormacao(dadosAtualizados.getFormacao());
            return psicologoRepository.save(psicologoParaAtualizar);
        }
        return null;
    }

}