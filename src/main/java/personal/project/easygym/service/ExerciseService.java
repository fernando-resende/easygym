package personal.project.easygym.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.Data;
import personal.project.easygym.model.Exercise;
import personal.project.easygym.repository.ExerciseRepository;

@Data
@Service
public class ExerciseService implements IService<Exercise>{
    
    private final ExerciseRepository repository;

    public ExerciseService(ExerciseRepository repository){
        this.repository = repository;
    }

    @Override
    public Optional<Exercise> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Exercise> findAll() {
        return repository.findAll();
    }

    @Override
    public Exercise createOrUpdate(Exercise exercise) {
        return repository.save(exercise);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
