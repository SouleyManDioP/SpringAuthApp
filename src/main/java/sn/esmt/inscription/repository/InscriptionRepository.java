package sn.esmt.inscription.repository;

import sn.esmt.inscription.model.Inscription;

import java.util.List;
import java.util.Optional;

public interface InscriptionRepository {

    Inscription save(Inscription inscription);

    List<Inscription> findAll();

    Optional<Inscription> findById(Long id);

    void deleteById(Long id);
}
