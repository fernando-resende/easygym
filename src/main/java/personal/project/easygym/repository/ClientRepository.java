package personal.project.easygym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import personal.project.easygym.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long>{
    //Common methods, like findAll, is given by JpaRepository
}
