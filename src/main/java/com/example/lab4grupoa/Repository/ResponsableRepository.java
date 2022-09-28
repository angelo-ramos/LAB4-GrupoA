package com.example.lab4grupoa.Repository;

import com.example.lab4grupoa.Entity.Responsable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
@Repository
public interface ResponsableRepository extends JpaRepository<Responsable, Integer> {
}
