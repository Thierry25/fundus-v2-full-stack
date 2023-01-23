package com.thierry.fundusv2.services;

import com.thierry.fundusv2.exceptions.DonationNotFound;
import com.thierry.fundusv2.exceptions.RequestNotFound;
import com.thierry.fundusv2.models.Donation;
import com.thierry.fundusv2.models.HelpRequest;
import com.thierry.fundusv2.repositories.DonationRepository;
import com.thierry.fundusv2.repositories.HelpRequestRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class DonationServiceImpl implements DonationService{

    private final DonationRepository donationRepository;
    private final HelpRequestRepository requestRepository;

    public DonationServiceImpl(DonationRepository donationRepository, HelpRequestRepository requestRepository){
        this.donationRepository = donationRepository;
        this.requestRepository = requestRepository;
    }

    @Override
    public Donation addDonation(Integer id, Donation donation) {
        // ToDo: VIA THE TOKEN --> Find the donor %?%
        var request = requestRepository.findById(id).orElseThrow(() -> new RequestNotFound("Request Not Found"));
        donation.setRequests(Collections.singletonList(request));
        return donationRepository.save(donation);
    }

    @Override
    public Donation getDonation(String identifier) {
        return donationRepository.findByIdentifier(identifier).orElseThrow(()-> new DonationNotFound("Donation Not Found"));
    }
}
