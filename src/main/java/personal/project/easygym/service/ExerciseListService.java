package personal.project.easygym.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.Data;
import personal.project.easygym.model.ExerciseList;
import personal.project.easygym.repository.ExerciseListRepository;

@Data
@Service
public class ExerciseListService implements IService<ExerciseList>{
    
    private final ExerciseListRepository repository;

    public ExerciseListService(ExerciseListRepository repository){
        this.repository = repository;
    }

    @Override
    public Optional<ExerciseList> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<ExerciseList> findAll() {
        return repository.findAll();
    }

    @Override
    public ExerciseList createOrUpdate(ExerciseList exerciseList) {
        return repository.save(exerciseList);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
