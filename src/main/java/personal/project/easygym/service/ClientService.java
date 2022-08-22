package personal.project.easygym.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import personal.project.easygym.model.Address;
import personal.project.easygym.model.Client;
import personal.project.easygym.repository.AddressRepository;
import personal.project.easygym.repository.ClientRepository;
import personal.project.easygym.service.util.ViaCepService;

@Data
@Service
public class ClientService implements IService<Client> {

    private final ClientRepository repository;
    
	@Autowired
	private AddressRepository addressRepository;
	
    @Autowired
	private ViaCepService viaCepService;

    public ClientService(ClientRepository repository) {
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
        // Check is the address already exists using CEP
        String cep = client.getAddress().getCep();
        Address address = addressRepository.findById(cep).orElseGet(() -> {
            Address newAddress = viaCepService.searchCep(cep);
            addressRepository.save(newAddress);
            return newAddress;
        });
        client.setAddress(address);
        return repository.save(client);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
