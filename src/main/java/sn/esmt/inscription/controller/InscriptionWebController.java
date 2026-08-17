package sn.esmt.inscription.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import sn.esmt.inscription.model.Inscription;
import sn.esmt.inscription.service.InscriptionService;


@Controller
public class InscriptionWebController {

    private final InscriptionService inscriptionService;

    public InscriptionWebController(InscriptionService inscriptionService) {
        this.inscriptionService = inscriptionService;
    }

    @GetMapping("/inscriptions/nouveau")
    public String afficherFormulaire(Model model) {
        model.addAttribute("inscription", new Inscription());
        return "form";
    }
    @PostMapping("/inscriptions")
    public String enregistrer(@ModelAttribute("inscription") Inscription inscription) {
        inscriptionService.inscrire(inscription);
        return "redirect:/inscriptions";
    }

    @GetMapping("/inscriptions")
    public String listerInscriptions(Model model) {
        model.addAttribute("inscriptions", inscriptionService.listerToutes());
        return "liste";
    }

    @GetMapping("/inscriptions/supprimer/{id}")
    public String supprimer(@PathVariable Long id) {
        inscriptionService.supprimer(id);
        return "redirect:/inscriptions";
    }
}
