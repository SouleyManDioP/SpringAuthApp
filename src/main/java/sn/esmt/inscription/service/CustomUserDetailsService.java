package sn.esmt.inscription.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sn.esmt.inscription.model.Utilisateur;
import sn.esmt.inscription.repository.UtilisateurRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UtilisateurRepository utilisateurRepository;

    public CustomUserDetailsService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateur u = utilisateurRepository.findByUsername(username);
        if (u == null) {
            throw new UsernameNotFoundException("Utilisateur introuvable : " + username);
        }

        return User.builder()
                .username(u.getUsername())
                .password(u.getPassword())
                .roles(u.getRole())
                .disabled(!u.isEnabled())
                .build();
    }
}