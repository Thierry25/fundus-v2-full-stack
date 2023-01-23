package com.thierry.fundusv2.repositories;

import com.thierry.fundusv2.models.Donation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DonationRepository extends JpaRepository<Donation, Integer> {
    Optional<Donation> findByIdentifier(String identifier);
}
