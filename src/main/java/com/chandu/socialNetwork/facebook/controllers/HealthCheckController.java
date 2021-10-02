package com.chandu.socialNetwork.facebook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HealthCheckController {
    @GetMapping("/healthCheck")
    public String HealthCheck() {
        return "Facebook Service is up and running.";
    }
}
