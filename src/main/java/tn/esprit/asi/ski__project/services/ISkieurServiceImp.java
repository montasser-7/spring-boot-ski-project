package tn.esprit.asi.ski__project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import tn.esprit.asi.ski__project.entities.Abonnement;
import tn.esprit.asi.ski__project.entities.Piste;
import tn.esprit.asi.ski__project.entities.Skieur;

import tn.esprit.asi.ski__project.entities.TypeAbonnement;
import tn.esprit.asi.ski__project.repositories.AbonnementRepository;
import tn.esprit.asi.ski__project.repositories.PisteRepository;
import tn.esprit.asi.ski__project.repositories.SkieurRepository;

import java.util.ArrayList;
import java.util.List;
@Service
public class ISkieurServiceImp implements ISkieurService {
    @Autowired
    private SkieurRepository skieurRepository;
    @Autowired
    private PisteRepository pisteRepository;
    @Autowired
    private AbonnementRepository abonnementRepository;
    @Override
    public void add(Skieur s) {
        skieurRepository.save(s);

    }

    @Override
    public Skieur update(Skieur s) {
        return skieurRepository.save(s);
    }

    @Override
    public List<Skieur> getAll() {


        return (List<Skieur>) skieurRepository.findAll();
    }

    @Override
    public Skieur getById(long id) {
        return null;
    }

    @Override
    public void remove(long id) {
        skieurRepository.deleteById(id);

    }

    @Override
    public Skieur assignSkierToPiste(Long numSkieur, Long numPiste) {
        //récuperation des objets
        Skieur skieur = skieurRepository.findById(numSkieur).orElse(null);
        Assert.notNull(skieur, "skieur not found");
        Piste piste = pisteRepository.findById(numPiste).orElse(null);
        Assert.notNull(piste, "piste not found");
           /*List<Piste> pistes = skieur.getPisteList();
           pistes.add(piste);
           skieur.setPisteList(pistes);*/
        skieur.getPisteList().add(piste);

        return skieurRepository.save(skieur);

    }
    @Override
    public Skieur assignSkieurtoAbonnement(long numSkieur, long numAbon) {
        Skieur skieur = skieurRepository.findById(numSkieur).orElse(null);
        Abonnement abonnement = abonnementRepository.findById(numAbon).orElse(null);
        return  skieurRepository.save(skieur);
    }

    @Override
    public List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement) {
       /* List<Skieur> list = new ArrayList<>();
        for (Skieur s:getAll()){
            if(s.getAbonnement().getTybeAbonnement().equals(typeAbonnement)) {
                list.add(s);
            }
        }
        return list;
    }*/


        return skieurRepository.findByAbonnementTybeAbonnement(typeAbonnement);

    }
}
