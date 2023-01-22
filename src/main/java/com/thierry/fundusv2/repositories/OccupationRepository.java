package com.thierry.fundusv2.repositories;

import com.thierry.fundusv2.models.Occupation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OccupationRepository extends JpaRepository<Occupation, Integer> {
    Optional<Occupation> findByName(String name);
}
