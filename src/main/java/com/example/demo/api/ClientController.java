package com.example.demo.api;


import com.example.demo.api.dto.ClientDTO;
import com.example.demo.service.impl.ClientService;
import com.example.demo.service.model.Client;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> addClient(@RequestBody ClientDTO clientDTO) {
        clientService.addClient(new Client(clientDTO.getName(), clientDTO.isPresent(), clientDTO.isVIP()));
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClientById(@PathVariable UUID id) throws NotFoundException {
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping()
    public ResponseEntity<List<Client>> getClient() {
        return ResponseEntity.ok(clientService.getClientRepository().findAll());
    }

}
