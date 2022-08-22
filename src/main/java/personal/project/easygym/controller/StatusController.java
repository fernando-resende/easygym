package personal.project.easygym.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import personal.project.easygym.model.Address;
import personal.project.easygym.model.Client;
import personal.project.easygym.model.Exercise;
import personal.project.easygym.model.ExerciseList;
import personal.project.easygym.service.ClientService;
import personal.project.easygym.service.ExerciseListService;
import personal.project.easygym.service.ExerciseService;

@RestController
public class StatusController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ExerciseService exerciseService;

    @Autowired
    private ExerciseListService listService;

    @GetMapping("${api-prefix}/status")
    public ResponseEntity<String> status() {
        return ResponseEntity.ok("online");
    }

    @GetMapping("${api-prefix}/populate")
    public ResponseEntity<String> populate(){
        Client client1 = new Client();
        Client client2 = new Client();
        Address address = new Address();

        client1.setName("Jhon Doe");
        client1.setCpf("12345678900");
        client1.setBirthdate(LocalDate.parse("2000-01-01"));
        address.setCep("35490000");
        client1.setAddress(address);
        client1 = clientService.createOrUpdate(client1);

        client2.setName("Kirk Jhones");
        client2.setCpf("00987654321");
        client2.setBirthdate(LocalDate.parse("1970-06-06"));
        address.setCep("36345000");
        client2.setAddress(address);
        client2 = clientService.createOrUpdate(client2);

        Exercise ex1 = exerciseService.createOrUpdate(new Exercise(null, "Exercise 1", "description",null));
        Exercise ex2 = exerciseService.createOrUpdate(new Exercise(null, "Exercise 2", "description",null));
        Exercise ex3 = exerciseService.createOrUpdate(new Exercise(null, "Exercise 3", "description",null));
        Exercise ex4 = exerciseService.createOrUpdate(new Exercise(null, "Exercise 4", "description",null));
        Exercise ex5 = exerciseService.createOrUpdate(new Exercise(null, "Exercise 5", "description",null));

        List<Exercise> exercises1 = new ArrayList<Exercise>();
        List<Exercise> exercises2 = new ArrayList<Exercise>();

        exercises1.add(ex1);
        exercises1.add(ex3);
        exercises1.add(ex5);

        exercises2.add(ex2);
        exercises2.add(ex4);

        ExerciseList exList = new ExerciseList();
        /* 
        exList.setCreated(LocalDate.now());
        exList.setValid(true);
        exList.setClient(client1);
        exList.setExercises(exercises1);
        
        listService.createOrUpdate(exList);
         */
        exList.setCreated(LocalDate.now());
        exList.setValid(true);
        exList.setClient(client2);
        exList.setExercises(exercises2);
        
        listService.createOrUpdate(exList);

        return ResponseEntity.ok("Data added");
    }

}

