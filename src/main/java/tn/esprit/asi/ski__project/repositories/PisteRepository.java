package tn.esprit.asi.ski__project.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.asi.ski__project.entities.Piste;
import tn.esprit.asi.ski__project.entities.Skieur;

public interface PisteRepository extends CrudRepository<Piste,Long> {

}
