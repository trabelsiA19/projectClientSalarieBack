package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {
    /**
     * The first name of the Client.
     */
    private String nom;
    /**
     * The SIRET of the Client.
     */
    private String siret;
}
