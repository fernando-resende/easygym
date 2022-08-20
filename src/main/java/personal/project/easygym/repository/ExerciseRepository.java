package personal.project.easygym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import personal.project.easygym.model.Exercise;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise,Long>{
    //Common methods, like findAll, is given by JpaRepository
}
