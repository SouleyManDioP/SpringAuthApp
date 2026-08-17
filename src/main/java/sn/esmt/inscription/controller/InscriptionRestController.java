package sn.esmt.inscription.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.esmt.inscription.model.Inscription;
import sn.esmt.inscription.service.InscriptionService;

import java.util.List;


@RestController
@RequestMapping("/api/inscriptions")
public class InscriptionRestController {

    private final InscriptionService inscriptionService;

    public InscriptionRestController(InscriptionService inscriptionService) {
        this.inscriptionService = inscriptionService;
    }

    @GetMapping
    public List<Inscription> listerToutes() {
        return inscriptionService.listerToutes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inscription> trouverParId(@PathVariable Long id) {
        return inscriptionService.trouverParId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Inscription> creer(@RequestBody Inscription inscription) {
        Inscription cree = inscriptionService.inscrire(inscription);
        return ResponseEntity.status(HttpStatus.CREATED).body(cree);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        if (inscriptionService.trouverParId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        inscriptionService.supprimer(id);
        return ResponseEntity.noContent().build();
    }
}
