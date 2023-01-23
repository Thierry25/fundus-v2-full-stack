package com.thierry.fundusv2.services;

import com.thierry.fundusv2.exceptions.RequestNotFound;
import com.thierry.fundusv2.exceptions.UserNotFound;
import com.thierry.fundusv2.models.HelpRequest;
import com.thierry.fundusv2.repositories.AccountRepository;
import com.thierry.fundusv2.repositories.HelpRequestRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class HelpRequestServiceImpl implements HelpRequestService {
    private final HelpRequestRepository requestRepo;
    private final AccountRepository accountRepo;

    public HelpRequestServiceImpl(HelpRequestRepository requestRepo, AccountRepository accountRepo) {
        this.requestRepo = requestRepo;
        this.accountRepo = accountRepo;
    }

    @Override
    public List<HelpRequest> getAllRequests() {
        var requests = requestRepo.findAll();
        if (requests.isEmpty()) throw new RequestNotFound("Request Not Found");
        return requests;
    }

    @Override
    public List<HelpRequest> getAllMyRequests(String username) {
        var currentUser = accountRepo.findByUsername(username)
                .orElseThrow(() -> new UserNotFound("User not Found"));
        var requests = currentUser.getRequests();
        if (requests.isEmpty()) throw new RequestNotFound("No requests found for this user");
        return requests;
    }

    @Override
    public List<HelpRequest> getShortRequests(int length) {
        var requests = getAllRequests();
        return requests
                .stream()
                .filter((request) -> request.getDescription().length() <= length)
                .toList();
    }


    @Override
    public List<HelpRequest> getAffordableRequests(int amount) {
        return getAllRequests()
                .stream()
                .filter((req) -> req.getAmount() <= amount)
                .toList();
    }

    @Override
    public List<HelpRequest> getFilteredRequests(String startsWith) {
        return getAllRequests()
                .stream()
                .filter((req) -> StringUtils.startsWithIgnoreCase(req.getDescription(),(startsWith)))
                .toList();
    }

    @Override
    public HelpRequest getRequest(int id) {
        return requestRepo.findById(id).orElseThrow(()-> new RequestNotFound("Request Not Found"));
    }

    @Override
    public HelpRequest createNewRequest(String username, HelpRequest helpRequest) {
        var currentUser = accountRepo.findByUsername(username).orElseThrow(() -> new UserNotFound("User not Found"));
        helpRequest.setRequestor(currentUser);
        return requestRepo.save(helpRequest);
    }

    @Override
    public HelpRequest updateRequest(Integer id, String username, HelpRequest helpRequest) {
        var currentUser = accountRepo.findByUsername(username).orElseThrow(() -> new UserNotFound("User not Found"));
        helpRequest.setRequestor(currentUser);
        helpRequest.setId(id);
        return requestRepo.save(helpRequest);
    }

    @Override
    public void deleteRequest(int id) {
        var req = requestRepo.findById(id).orElseThrow(() -> new RequestNotFound("Request Not Found"));
        requestRepo.delete(req);
    }
}
