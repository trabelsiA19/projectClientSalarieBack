package com.example.demo.dto;


import com.example.demo.models.Client;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalarieDTO {

    /**
     * The first name of the Salarie.
     */
    private String nom;
    /**
     * The last name of the Salarie.
     */
    private String prenom;
    /**
     * The email of the Salarie.
     */
    private String email;
    /**
     * The birthdate of the Salarie.
     */
    private LocalDate BirthDate;
    /**
     * The  Salarie belongs client.
     */
    private Long client;



}
