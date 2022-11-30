package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@RequiredArgsConstructor
@Controller
public class HomeController {

    @GetMapping("/")
    public String homeGet(Model model, Principal principal) {
        String userPrincipalName;
        if (principal != null) {
            userPrincipalName = principal.getName();
        } else {
            userPrincipalName = "None";
        }
        model.addAttribute("userPrincipalName", userPrincipalName);
        return "home";
    }

    @PostMapping("/")
    public String homePost(Model model, Principal principal) {
        String userPrincipalName;
        if (principal != null) {
            userPrincipalName = principal.getName();
        } else {
            userPrincipalName = "None";
        }
        model.addAttribute("userPrincipalName", userPrincipalName);
        return "home";
    }
}
