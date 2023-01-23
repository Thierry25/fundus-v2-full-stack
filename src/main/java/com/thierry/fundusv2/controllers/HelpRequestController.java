package com.thierry.fundusv2.controllers;

import com.thierry.fundusv2.models.HelpRequest;
import com.thierry.fundusv2.services.HelpRequestService;
import com.thierry.fundusv2.utils.Filtering;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/requests")
public class HelpRequestController {

    private final HelpRequestService requestService;
    private static final String REQUEST_FILTER = "requestFilter";

    public HelpRequestController(HelpRequestService requestService){
        this.requestService = requestService;
    }

    @GetMapping("/{username}/")
    public MappingJacksonValue getUserAllRequests(@PathVariable String username){
        var requests = requestService.getAllMyRequests(username);
        var responseEntity = new ResponseEntity<>(requests, HttpStatus.OK);
        return Filtering.filter(responseEntity, REQUEST_FILTER, "id","title", "description", "amount");
    }

    @GetMapping("/{id}")
    public MappingJacksonValue getRequest(@PathVariable Integer id){
        var request = requestService.getRequest(id);
        var entity = EntityModel.of(request);
        var link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllRequests());
        entity.add(link.withRel("all-requests"));
        return Filtering.filter(entity, REQUEST_FILTER, "title", "description", "amount", "location", "isActive");
    }

    @GetMapping(params = "length")
    public MappingJacksonValue getShortRequests(@RequestParam Integer length){
        var requests = requestService.getShortRequests(length);
        return Filtering.filter(requests, REQUEST_FILTER, "id","title", "description", "amount");
    }

    @GetMapping(params = "amount")
    public MappingJacksonValue getAffordableRequests(@RequestParam Integer amount){
        var requests = requestService.getAffordableRequests(amount);
        return Filtering.filter(requests, REQUEST_FILTER, "id","title", "description", "amount", "location");
    }

    @GetMapping(params = "startsWith")
    public MappingJacksonValue getFilteredRequests(@RequestParam String startsWith){
        var requests = requestService.getFilteredRequests(startsWith);
        return Filtering.filter(requests, REQUEST_FILTER, "id", "title", "description", "amount");
    }


    @GetMapping
    public MappingJacksonValue getAllRequests(){
        var requests = requestService.getAllRequests();
        return Filtering.filter(requests, REQUEST_FILTER, "id", "title", "description", "amount");
    }

}
