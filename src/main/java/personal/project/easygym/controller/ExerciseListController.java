package personal.project.easygym.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import personal.project.easygym.model.ExerciseList;
import personal.project.easygym.service.ExerciseListService;

@Controller
@RequestMapping(path = "${api-prefix}/exercise-list")
public class ExerciseListController {

    private ExerciseListService service;

    public ExerciseListController(ExerciseListService service){
        this.service = service;
    }

    @PostMapping(path = "/save")
    public ResponseEntity<ExerciseList> save(@RequestBody ExerciseList exerciseList){
        return ResponseEntity.ok(service.createOrUpdate(exerciseList));
    }

    @GetMapping(path = "/list")
    public ResponseEntity<List<ExerciseList>> getAll(){
        return ResponseEntity.ok(service.findAll());
    }
}
