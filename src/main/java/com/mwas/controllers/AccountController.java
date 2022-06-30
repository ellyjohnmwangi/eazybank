package com.mwas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mwas.model.Accounts;
import com.mwas.model.Customer;
import com.mwas.repository.AccountsRepository;

@RestController
public class AccountController {

    @Autowired
    public AccountsRepository accountsRepository;

    @PostMapping("/myAccount")
    public Accounts getAccountDetails(@RequestBody Customer customer) {
        Accounts accounts = accountsRepository.findByCustomerId(customer.getId());
        if (accounts != null ) {
            return accounts;
        }else {
            return null;
        }
    }

}