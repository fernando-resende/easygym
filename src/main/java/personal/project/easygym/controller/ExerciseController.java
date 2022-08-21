package personal.project.easygym.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import personal.project.easygym.model.Exercise;
import personal.project.easygym.service.ExerciseService;

@Controller
@RequestMapping(path = "${api-prefix}/exercise")
public class ExerciseController {

    private ExerciseService service;

    public ExerciseController(ExerciseService service){
        this.service = service;
    }

    @PostMapping(path = "/save")
    public ResponseEntity<Exercise> save(@RequestBody Exercise exercise){
        return ResponseEntity.ok(service.createOrUpdate(exercise));
    }

    @GetMapping(path = "/list")
    public ResponseEntity<List<Exercise>> getAll(){
        return ResponseEntity.ok(service.findAll());
    }
}
