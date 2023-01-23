package com.thierry.fundusv2.services;

import com.thierry.fundusv2.models.Donation;

public interface DonationService {
    Donation addDonation(Integer id, Donation donationData);
    Donation getDonation(String identifier);

}
