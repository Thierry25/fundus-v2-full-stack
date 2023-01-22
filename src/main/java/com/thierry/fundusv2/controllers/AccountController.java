package com.thierry.fundusv2.controllers;

import com.thierry.fundusv2.models.Account;
import com.thierry.fundusv2.services.AccountService;
import com.thierry.fundusv2.utils.Filtering;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private static final String ACCOUNT_FILTER = "accountFilter";
    private final AccountService accountService;

    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @GetMapping
    public MappingJacksonValue getAllAccounts(){
        var accounts = accountService.getAllAccounts();
        return Filtering.filter(accounts, ACCOUNT_FILTER, "firstName", "username");
    }

    @PostMapping
    public MappingJacksonValue createNewAccount(@Valid @RequestBody Account account){
        var newAccount = accountService.createAccount(account);
        var location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{username}")
                .buildAndExpand(newAccount.getUsername())
                .toUri();
        var response = ResponseEntity.created(location).body(newAccount);
        return Filtering.filter(response, "firstName", "lastName", "username", "email");
    }

    @GetMapping("/{username}")
    public MappingJacksonValue getCurrentAccount(@PathVariable String username){
        var account = accountService.findByUsername(username);
        var entity = EntityModel.of(account);
        var link = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllAccounts());
        entity.add(link.withRel("all-accounts"));
        return Filtering.filter(entity, ACCOUNT_FILTER, "firstName", "lastName", "username", "email");
    }




}
