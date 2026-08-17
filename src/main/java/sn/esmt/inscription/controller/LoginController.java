package sn.esmt.inscription.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sn.esmt.inscription.model.Utilisateur;
import sn.esmt.inscription.repository.UtilisateurRepository;

@Controller
public class LoginController {

    private final UtilisateurRepository utilisateurRepository;
    private final PasswordEncoder passwordEncoder;

    public LoginController(UtilisateurRepository utilisateurRepository, PasswordEncoder passwordEncoder) {
        this.utilisateurRepository = utilisateurRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/setup-user")
    @ResponseBody
    public String creerUtilisateur(@RequestParam String username,
                                   @RequestParam String password,
                                   @RequestParam(defaultValue = "USER") String role) {
        Utilisateur u = new Utilisateur();
        u.setUsername(username);
        u.setPassword(passwordEncoder.encode(password));
        u.setRole(role);
        u.setEnabled(true);
        utilisateurRepository.save(u);
        return "Utilisateur " + username + " créé avec succès.";
    }
}