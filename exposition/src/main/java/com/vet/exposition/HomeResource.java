package com.vet.exposition;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

    @RequestMapping("/")
    public String home(){
        return "Home page of Vet Clinic PAWS";
    }

}
