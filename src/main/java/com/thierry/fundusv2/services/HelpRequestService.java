package com.thierry.fundusv2.services;

import com.thierry.fundusv2.models.HelpRequest;

import java.util.List;

public interface HelpRequestService {
    // TODO: ASK FA if it's better to either select the filtered fields directly from the DB or retrieve all and filter
    List<HelpRequest> getAllRequests();
    List<HelpRequest> getAllMyRequests(String username);
    List<HelpRequest> getShortRequests(int length);
    List<HelpRequest> getAffordableRequests(int amount);
    List<HelpRequest> getFilteredRequests(String startsWith);
    HelpRequest getRequest(int id);
    HelpRequest createNewRequest(String username, HelpRequest helpRequest);
    HelpRequest updateRequest(Integer id, String username, HelpRequest helpRequest);
    void deleteRequest(int id);
}
