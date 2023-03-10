package tn.esprit.asi.ski__project.services;

import tn.esprit.asi.ski__project.entities.Cours;
import tn.esprit.asi.ski__project.entities.Moniteur;

import java.util.List;

public interface ICoursService {
    void add(Cours c);

    Cours update(Cours c);

    List<Cours> getAll();

    Cours getById(long id);

    void remove(long id);
}
