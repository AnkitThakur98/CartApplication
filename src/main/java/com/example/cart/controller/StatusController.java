package com.example.cart.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

    private static final Logger log = LogManager.getLogger(StatusController.class);

    @GetMapping(value = "/")
    public boolean isServerUp(){
        log.info("Entering StatusController isServerUp() method");
        log.info("Exiting StatusController isServerUp() method");
        return true;
    }

}
