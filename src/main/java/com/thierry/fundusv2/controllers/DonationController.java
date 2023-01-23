package com.thierry.fundusv2.controllers;

import com.thierry.fundusv2.services.DonationService;
import com.thierry.fundusv2.utils.Filtering;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/donations")
public class DonationController {

    private final DonationService donationService;

    public DonationController(DonationService donationService){
        this.donationService = donationService;
    }

    @GetMapping("/{identifier}")
    public MappingJacksonValue getCurrentDonationDetails(@PathVariable String identifier){
        var donation = donationService.getDonation(identifier);
       return Filtering.filter(donation, "donationFilter", "amount", "comment");
    }
}
