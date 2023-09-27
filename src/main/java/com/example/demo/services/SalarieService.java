package com.example.demo.services;

import com.example.demo.models.Salarie;

import java.util.List;

public interface SalarieService {
    /**
     * The get All salaries method.
     */
    List<Salarie> getAllSalaries();

    /**
     * The get salarie by id method.
     */
    Salarie getSalarieById(Long id);

    /**
     * The save salaries method.
     */
    Salarie saveSalarie(Salarie salarie);

    /**
     * The delete salaries method.
     */
    void deleteSalarie(Long id);
}
