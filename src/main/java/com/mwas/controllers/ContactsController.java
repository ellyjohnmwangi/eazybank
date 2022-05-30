package com.mwas.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactsController {
    @GetMapping("/contacts")
    public String saveContactsInquiryDetails(){
        return "inquiry details saved to the DB";
    }
}
