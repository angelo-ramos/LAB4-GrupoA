package com.example.lab4grupoa.Repository;

import com.example.lab4grupoa.Entity.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio,Integer> {
}
