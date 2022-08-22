package personal.project.easygym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import personal.project.easygym.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {
    //Common methods, like findAll, are given by JpaRepository
}