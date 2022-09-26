package com.example.demo.controllers;

import com.example.demo.entities.Empleado;
import com.example.demo.entities.User;
import com.example.demo.services.EmpleadoService;
import com.example.demo.services.EmpresaService;
import com.example.demo.services.MovimientosDineroService;
import com.example.demo.services.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class FrontController {

    //Servicios
    EmpresaService empresaService;
    EmpleadoService empleadoService;
    MovimientosDineroService movimientosDineroService;
    UserService userService;


    public FrontController(EmpleadoService empleadoService, EmpresaService empresaService, MovimientosDineroService movimientosDineroService, UserService userService ){
        this.empleadoService = empleadoService;
        this.empresaService = empresaService;
        this.movimientosDineroService = movimientosDineroService;
        this.userService=userService;

    }

    //Metodos
    @GetMapping("/")
    public String index(Model model, @AuthenticationPrincipal OidcUser principal){
        if(principal!=null) {

            this.userService.getOrCreateUser(principal.getClaims());
            model.addAttribute("nick",principal.getClaims().get("nickname"));

        }

        return "index";
    }

    @GetMapping("/empleados")
    public String empleados(Model model,@AuthenticationPrincipal OidcUser principal){
        if(principal!=null) {

            List<Empleado> empleados = empleadoService.getEmpleados();
            model.addAttribute("empleados", empleados);
            return "empleados";
        }
            index(model,principal);
            return "index";

    }

    @GetMapping("/main")
    public String main(Model model, @AuthenticationPrincipal OidcUser principal){
        if(principal!=null) {

            return "main";
        }
        index(model,principal);
        return "index";
    }
}
