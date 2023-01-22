package com.thierry.fundusv2.repositories;

import com.thierry.fundusv2.models.Donation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationRepository extends JpaRepository<Donation, Integer> {
}
