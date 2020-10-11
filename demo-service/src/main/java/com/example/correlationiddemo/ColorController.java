package com.example.correlationiddemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ColorController {

    @GetMapping("/blue")
    public String blue() {
        return "Blue is the warmest color.";
    }

    @GetMapping("/red")
    public String red() {
        return "Red is my favorite color.";
    }

    @GetMapping("/purple")
    public String purple() {
        return "Purple is the color of royalty.";
    }

    @GetMapping("/green")
    public String green() {
        return "Green is the color of money.";
    }

}
