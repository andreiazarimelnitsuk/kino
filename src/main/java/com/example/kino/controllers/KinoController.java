package com.example.kino.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KinoController {
    @GetMapping("/kino-main")
    public String kinoMain(Model model){
        return "kino-main";
    }
}
