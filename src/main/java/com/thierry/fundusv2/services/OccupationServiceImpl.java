package com.thierry.fundusv2.services;

import com.thierry.fundusv2.models.Occupation;
import com.thierry.fundusv2.repositories.OccupationRepository;
import org.springframework.stereotype.Service;

@Service
public class OccupationServiceImpl implements OccupationService {

    private final OccupationRepository occupationRepository;

    public OccupationServiceImpl(OccupationRepository occupationRepository){
        this.occupationRepository = occupationRepository;
    }

    @Override
    public Occupation getOccupationName(String name) {
        return occupationRepository.findByName(name).orElseThrow(() -> new RuntimeException("Occupation Not Found"));
    }
}
