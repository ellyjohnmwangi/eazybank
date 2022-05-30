package com.mwas.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {
    @GetMapping("/myCards")
    public String getCards(){
        return "here are card details from the DB";
    }
}
