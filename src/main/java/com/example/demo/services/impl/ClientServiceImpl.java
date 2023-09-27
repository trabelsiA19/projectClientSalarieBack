package com.example.demo.services.impl;

import com.example.demo.models.Client;
import com.example.demo.repository.ClientRepository;
import com.example.demo.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    /**
     * The  get All Clients   method.
     *
     */
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    /**
     * The  get Client By Id   method.
     * {@Param id}
     */
    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    /**
     * The  save Client  method.
     * {@Param client}
     */
    public Client saveClient(Client client) {
        clientRepository.save(client);
        return client;
    }

    /**
     * The  delete Client  method.
     * {@Param id}
     */
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
