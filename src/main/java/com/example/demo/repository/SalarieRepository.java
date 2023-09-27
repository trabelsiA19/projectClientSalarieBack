package com.example.demo.repository;

import com.example.demo.models.Salarie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalarieRepository extends JpaRepository<Salarie, Long> {
}
