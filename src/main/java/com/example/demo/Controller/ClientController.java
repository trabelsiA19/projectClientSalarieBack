package com.example.demo.Controller;

import com.example.demo.dto.ClientDTO;
import com.example.demo.models.Client;
import com.example.demo.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    /**
     * API endpoint to retrieve all clients.
     *
     * @return A list of {@link Client} objects representing all clients.
     */
    @GetMapping("/AllClients")
    public  ResponseEntity<?>  getAllClients() {
        return  new ResponseEntity<>(clientService.getAllClients(), HttpStatus.ACCEPTED);
    }

    /**
     * API endpoint to retrieve a client by its ID.
     *
     * @param id The ID of the client to retrieve.
     * @return The {@link Client} object with the specified ID, or null if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getClientById(@PathVariable Long id) {
        return new ResponseEntity<>(clientService.getClientById(id), HttpStatus.ACCEPTED);
    }

    /**
     * API endpoint to create a new client.
     *
     * @param clientDTO The {@link ClientDTO} object containing the information of the client to be created.
     */
    @PostMapping
    public ResponseEntity<?> saveClient(@RequestBody ClientDTO clientDTO) {
        Client client = new Client(clientDTO.getNom(), clientDTO.getSiret());

        return new ResponseEntity<>( clientService.saveClient(client), HttpStatus.CREATED);
    }

    /**
     * API endpoint to update an existing client.
     *
     * @param id The ID of the client to update.
     * @param updatedClient The updated {@link Client} object.
     * @return The updated {@link Client} object.
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> updateClient(@PathVariable Long id, @RequestBody Client updatedClient) {
        Client existingClient = clientService.getClientById(id);
        existingClient.setNom(updatedClient.getNom());
        existingClient.setSiret(updatedClient.getSiret());

        return new ResponseEntity<>( clientService.saveClient(existingClient), HttpStatus.ACCEPTED);
    }

    /**
     * API endpoint to delete a client by its ID.
     *
     * @param id The ID of the client to delete.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?>  deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return new ResponseEntity<>(  HttpStatus.ACCEPTED);

    }
}
