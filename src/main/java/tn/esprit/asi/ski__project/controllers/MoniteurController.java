package tn.esprit.asi.ski__project.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.asi.ski__project.entities.Moniteur;
import tn.esprit.asi.ski__project.services.*;

import java.util.List;
@RestController
@AllArgsConstructor
@RequestMapping("/moniteur")
public class MoniteurController {


    @Autowired
    private IMoniteurService iMoniteurService;
    @PostMapping
    void add(@RequestBody Moniteur m){
        iMoniteurService.add(m);
    }

    @PutMapping
    Moniteur update(@RequestBody Moniteur m){
        return iMoniteurService.update(m);
    }

    @GetMapping
    List<Moniteur> getAll(){
        return iMoniteurService.getAll();
    }

    @GetMapping("/{id}")
    Moniteur getById(@PathVariable  long id){
        return iMoniteurService.getById(id);
    }

    @DeleteMapping ("/{id}")
    void remove(@PathVariable long id)
    {iMoniteurService.remove(id);}
    @PostMapping("/{numMoniteur}/assign-course/{numCours}")
    public Moniteur addInstructorAndAssignToCourse(@PathVariable Long numMoniteur,
                                                   @PathVariable Long numCours) {
        return iMoniteurService.addInstructorAndAssignToCourse(numMoniteur, numCours);

    }
}
