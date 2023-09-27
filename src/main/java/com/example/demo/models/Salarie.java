package com.example.demo.models;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Salarie {

    /**
     * The unique identifier of the Salarie.
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

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
    private String email ;
    /**
     * The birthdate of the Salarie.
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate BirthDate;

    /**
     * The  Salarie belongs client.
     */
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;


}
