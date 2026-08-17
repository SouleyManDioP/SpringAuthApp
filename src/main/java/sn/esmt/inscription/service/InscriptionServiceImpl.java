package sn.esmt.inscription.service;

import org.springframework.stereotype.Service;
import sn.esmt.inscription.model.Inscription;
import sn.esmt.inscription.repository.InscriptionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InscriptionServiceImpl implements InscriptionService {

    private final InscriptionRepository inscriptionRepository;

    public InscriptionServiceImpl(InscriptionRepository inscriptionRepository) {
        this.inscriptionRepository = inscriptionRepository;
    }

    @Override
    public Inscription inscrire(Inscription inscription) {
        return inscriptionRepository.save(inscription);
    }

    @Override
    public List<Inscription> listerToutes() {
        return inscriptionRepository.findAll();
    }

    @Override
    public Optional<Inscription> trouverParId(Long id) {
        return inscriptionRepository.findById(id);
    }

    @Override
    public void supprimer(Long id) {
        inscriptionRepository.deleteById(id);
    }
}
