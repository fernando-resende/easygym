package personal.project.easygym.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import personal.project.easygym.model.Client;
import personal.project.easygym.service.ClientService;

@Controller
@RequestMapping(path = "${api-prefix}/client")
public class ClientController {

    private ClientService service;

    public ClientController(ClientService service){
        this.service = service;
    }

    @PostMapping(path = "/save")
    public ResponseEntity<Client> save(@RequestBody Client client){
        return ResponseEntity.ok(service.createOrUpdate(client));
    }

    @GetMapping(path = "/list")
    public ResponseEntity<List<Client>> getAll(){
        return ResponseEntity.ok(service.findAll());
    }
}
