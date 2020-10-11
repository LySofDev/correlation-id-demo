package com.example.correlationiddemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ColorController {

    private static Logger logger = LoggerFactory.getLogger(ColorController.class);

    @GetMapping("/blue")
    public String blue() {
        logger.info("Request received by blue.");
        return "Blue is the warmest color.";
    }

    @GetMapping("/red")
    public String red() {
        logger.info("Request received by red.");
        return "Red is my favorite color.";
    }

    @GetMapping("/purple")
    public String purple() {
        logger.info("Request received by purple.");
        return "Purple is the color of royalty.";
    }

    @GetMapping("/green")
    public String green() {
        logger.info("Request received by green.");
        return "Green is the color of money.";
    }

}
