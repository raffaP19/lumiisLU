package br.ufpb.dcx.dsc.lumiislu.config;

import br.ufpb.dcx.dsc.lumiislu.dto.PacienteCreateDTO;
import br.ufpb.dcx.dsc.lumiislu.dto.ProntuarioResponseDTO;
import br.ufpb.dcx.dsc.lumiislu.models.Paciente;
import br.ufpb.dcx.dsc.lumiislu.models.Prontuario;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.createTypeMap(PacienteCreateDTO.class, Paciente.class)
                .addMapping(PacienteCreateDTO::getNome, Paciente::setUsername);

        TypeMap<Prontuario, ProntuarioResponseDTO> prontuarioMap = modelMapper.createTypeMap(Prontuario.class, ProntuarioResponseDTO.class);

        prontuarioMap.addMapping(Prontuario::getProntuario_id, ProntuarioResponseDTO::setId);

        prontuarioMap.addMapping(src -> src.getPaciente().getPaciente_id(), ProntuarioResponseDTO::setPacienteId);
        return modelMapper;
    }

}
