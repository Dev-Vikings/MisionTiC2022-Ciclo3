package com.backend.DEVikings.controller;

import com.backend.DEVikings.service.EmpresaService;
import com.backend.DEVikings.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    UserService userService;

    public WebController(UserService userService) {
        this.userService = userService;

    }


    @GetMapping("/")
    public String index(Model model, @AuthenticationPrincipal OidcUser principal) {
        if (principal != null) {
            this.userService.saveUser(principal.getClaims());
            model.addAttribute("nick", principal.getClaims().get("nickname"));

        }

        return "index";
    }


}