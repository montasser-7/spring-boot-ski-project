package tn.esprit.asi.ski__project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.asi.ski__project.entities.Abonnement;
import tn.esprit.asi.ski__project.entities.Skieur;
import tn.esprit.asi.ski__project.repositories.AbonnementRepository;
import tn.esprit.asi.ski__project.repositories.SkieurRepository;

import java.util.List;
@Service
public class IAbonnementServiceImp implements IAbonnementService{
    @Autowired
    private AbonnementRepository abonnementRepository;

    @Override
    public void add(Abonnement a) {

        abonnementRepository.save(a);
    }

    @Override
    public Abonnement update(Abonnement a) {
        return abonnementRepository.save(a);
    }

    @Override
    public List<Abonnement> getAll() {
        return (List<Abonnement>) abonnementRepository.findAll();
    }

    @Override
    public Abonnement getById(long id) {
        return abonnementRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(long id) {

        abonnementRepository.deleteById(id);
    }

}
