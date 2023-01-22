package com.thierry.fundusv2.services;

import com.thierry.fundusv2.models.HelpRequest;

import java.util.List;

public interface HelpRequestService {
    List<HelpRequest> getAllRequests();
    List<HelpRequest> getAllMyRequests(String username);
    List<HelpRequest> getShortRequests();
    HelpRequest getRequest(int id);
    HelpRequest createNewRequest(HelpRequest helpRequest);
    HelpRequest updateRequest(String username, HelpRequest helpRequest);
    void deleteRequest(int id, String username);
}
