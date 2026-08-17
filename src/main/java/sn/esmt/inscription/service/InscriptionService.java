package sn.esmt.inscription.service;

import sn.esmt.inscription.model.Inscription;

import java.util.List;
import java.util.Optional;

public interface InscriptionService {

    Inscription inscrire(Inscription inscription);

    List<Inscription> listerToutes();

    Optional<Inscription> trouverParId(Long id);

    void supprimer(Long id);
}
