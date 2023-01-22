package com.thierry.fundusv2.services;

import com.thierry.fundusv2.exceptions.RequestNotFound;
import com.thierry.fundusv2.exceptions.UserNotFound;
import com.thierry.fundusv2.models.HelpRequest;
import com.thierry.fundusv2.repositories.AccountRepository;
import com.thierry.fundusv2.repositories.HelpRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HelpRequestServiceImpl implements HelpRequestService {
    private final HelpRequestRepository helpRepo;
    private final AccountRepository accountRepo;

    public HelpRequestServiceImpl(HelpRequestRepository helpRepo, AccountRepository accountRepo) {
        this.helpRepo = helpRepo;
        this.accountRepo = accountRepo;
    }

    @Override
    public List<HelpRequest> getAllRequests() {
        var requests = helpRepo.findAll();
        if (requests.isEmpty()) throw new RequestNotFound("Request Not Found");
        return requests;
    }

    @Override
    public List<HelpRequest> getAllMyRequests(String username) {
        var currentUser = accountRepo.findByUsername(username).orElseThrow(() -> new UserNotFound("User not Found"));
        var requests = currentUser.getRequests();
        if (requests.isEmpty()) throw new RequestNotFound("No requests found for this user");
        return requests;
    }

    @Override
    public List<HelpRequest> getShortRequests() {
        var requests = getAllRequests();
        return requests
                .stream()
                .filter((request) -> request.getDescription().length() <= 20)
                .toList();
    }

    @Override
    public HelpRequest getRequest(int id) {
        return null;
    }

    @Override
    public HelpRequest createNewRequest(HelpRequest helpRequest) {
        return null;
    }

    @Override
    public HelpRequest updateRequest(String username, HelpRequest helpRequest) {
        return null;
    }

    @Override
    public void deleteRequest(int id, String username) {

    }
}
