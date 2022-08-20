package personal.project.easygym.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.Data;
import personal.project.easygym.model.Client;
import personal.project.easygym.repository.ClientRepository;

@Data
@Service
public class ClientService implements IService<Client>{
    
    private final ClientRepository repository;

    public ClientService(ClientRepository repository){
        this.repository = repository;
    }

    @Override
    public Optional<Client> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Client> findAll() {
        return repository.findAll();
    }

    @Override
    public Client createOrUpdate(Client client) {
        return repository.save(client);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
