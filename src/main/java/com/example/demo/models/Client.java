package com.example.demo.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    /**
     * The unique identifier  for the Client.
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    /**
     * The first name of the Client.
     */
    private String nom;

    /**
     * The SIRET of the Client.
     */
    private String siret;

    /**
     * The Client Constructor with name and siret.
     */
    public Client(String nom, String siret) {
        this.nom = nom;
        this.siret = siret;
    }
}
