package com.example.demo.services;

import com.example.demo.models.Client;

import java.util.List;

public interface ClientService {
    /**
     * The  get All Clients Method.
     */
    List<Client> getAllClients();
    /**
     * The  get  Client by id  Method.
     */
    Client getClientById(Long id);
    /**
     * The  save client method.
     */
    Client saveClient(Client client);
    /**
     * The  delete client method.
     */
    void deleteClient(Long id);
}
