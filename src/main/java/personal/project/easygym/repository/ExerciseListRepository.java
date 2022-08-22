package personal.project.easygym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import personal.project.easygym.model.ExerciseList;

@Repository
public interface ExerciseListRepository extends JpaRepository<ExerciseList,Long>{
    //Common methods, like findAll, are given by JpaRepository
}
