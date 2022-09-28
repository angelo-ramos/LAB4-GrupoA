package com.example.lab4grupoa.Repository;

import com.example.lab4grupoa.Entity.RazaEspecie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RazaEspecieRepository extends JpaRepository<RazaEspecie, Integer> {
}