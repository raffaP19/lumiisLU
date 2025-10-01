package br.ufpb.dcx.dsc.lumiislu.security;

import br.ufpb.dcx.dsc.lumiislu.models.Psicologo;
import br.ufpb.dcx.dsc.lumiislu.repository.PsicologoRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final PsicologoRepository psicologoRepository;

    public UserDetailsServiceImpl(PsicologoRepository psicologoRepository) {
        this.psicologoRepository = psicologoRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Psicologo psicologo = psicologoRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Não foi encontrado psicólogo com o email: " + email));

        return new User(psicologo.getEmail(), psicologo.getPassword(), Collections.emptyList());
    }

}
