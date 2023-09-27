package com.example.demo.Controller;

import com.example.demo.dto.SalarieDTO;
import com.example.demo.models.Client;
import com.example.demo.models.Salarie;
import com.example.demo.services.ClientService;
import com.example.demo.services.SalarieService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The {@code SalarieController} class is a Spring REST controller that handles API requests related to {@link Salarie} entities.
 *
 * <p>The controller provides endpoints for retrieving, creating, updating, and deleting salaries.</p>
 *
 * <p>By using the {@code @RestController} and {@code @RequestMapping} annotations, this class defines the base URL
 * '/salaries' for its endpoints. The {@code @CrossOrigin} annotation is used to enable cross-origin requests from any origin,
 * allowing clients from different domains to access the API.</p>
 *
 * <p>The controller uses the {@link SalarieService} to handle the business logic for salaries,
 * and {@link ClientService} to handle client related operations.
 * The service classes are autowired for dependency injection.</p>
 *
 * @see com.example.demo.dto.SalarieDTO
 * @see com.example.demo.models.Salarie
 * @see com.example.demo.services.SalarieService
 * @see com.example.demo.models.Client
 * @see com.example.demo.services.ClientService
 * @see org.springframework.web.bind.annotation.RestController
 * @see org.springframework.web.bind.annotation.RequestMapping
 * @see org.springframework.web.bind.annotation.CrossOrigin
 *
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/salaries")
public class SalarieController {

    @Autowired
    private SalarieService salarieService;

    @Autowired
    private ClientService clientService;

    /**
     * API endpoint to retrieve all salaries.
     *
     * @return A list of {@link Salarie} objects representing all salaries.
     */
    @GetMapping
    public ResponseEntity<List<Salarie>> getAllSalaries() {
        List<Salarie> salaries = salarieService.getAllSalaries();
        return ResponseEntity.ok(salaries);
    }

    /**
     * API endpoint to retrieve a salary by its ID.
     *
     * @param id The ID of the salary to retrieve.
     * @return The {@link Salarie} object with the specified ID, or null if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Salarie> getSalarieById(@PathVariable Long id) {
        Salarie salarie = salarieService.getSalarieById(id);
        return ResponseEntity.ok(salarie);
    }

    /**
     * API endpoint to create a new salary.
     *
     * @param salarieDTO The {@link SalarieDTO} object containing the information of the salary to be created.
     * @return HTTP status indicating the success of the request.
     */
    @PostMapping
    public ResponseEntity<Void> saveSalarie(@RequestBody SalarieDTO salarieDTO) {
        Client client = clientService.getClientById(salarieDTO.getClient());

        if (client == null) {
            throw new EntityNotFoundException("Client not found with id: " + salarieDTO.getClient());
        }

        Salarie salarie = new Salarie(
                null,
                salarieDTO.getNom(),
                salarieDTO.getPrenom(),
                salarieDTO.getEmail(),
                salarieDTO.getBirthDate(),
                client
        );

        salarieService.saveSalarie(salarie);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * API endpoint to update an existing salary.
     *
     * @param id The ID of the salary to update.
     * @param updatedSalarie The updated {@link SalarieDTO} object.
     * @return The updated {@link Salarie} object.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Salarie> updateSalarie(@PathVariable Long id, @RequestBody SalarieDTO updatedSalarie) {
        Salarie existingSalarie = salarieService.getSalarieById(id);
        existingSalarie.setNom(updatedSalarie.getNom());
        existingSalarie.setPrenom(updatedSalarie.getPrenom());
        existingSalarie.setEmail(updatedSalarie.getEmail());
        existingSalarie.setBirthDate(updatedSalarie.getBirthDate());

        Salarie savedSalarie = salarieService.saveSalarie(existingSalarie);

        return ResponseEntity.ok(savedSalarie);
    }

    /**
     * API endpoint to delete a salary by its ID.
     *
     * @param id The ID of the salary to delete.
     * @return HTTP status indicating the success of the request.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSalarie(@PathVariable Long id) {
        salarieService.deleteSalarie(id);
        return ResponseEntity.ok().build();
    }
}
