package stp.projet.Login.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class LoginController {
	
    @GetMapping("/")
    public String index() {
        return "index";
    }

}
