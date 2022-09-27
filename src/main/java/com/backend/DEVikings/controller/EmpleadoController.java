package com.backend.DEVikings.controller;

import com.backend.DEVikings.model.Empleado;
import com.backend.DEVikings.service.EmpleadoService;
import com.backend.DEVikings.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class EmpleadoController {

    @Autowired
    EmpleadoService empleadoService;
    EmpresaService empresaService;
    WebController webController;
    public EmpleadoController(EmpleadoService empleadoService, WebController webController, EmpresaService empresaService) {
        this.empleadoService = empleadoService;
        this.webController = webController;
        this.empresaService=empresaService;
    }
    @GetMapping("/empleados")
    private String verEmpleado(Model model,@AuthenticationPrincipal OidcUser principal){
        if (principal != null) {
            model.addAttribute("empleados", empleadoService.verEmpleado());
            String email= (String) principal.getClaims().get("email");
            Empleado empleado=empleadoService.getEmpleadobyEmail(email);
            model.addAttribute("empleado", empleado);
            return "empleados";
        }
        webController.index(model,principal);
        return "index";
    }

    @GetMapping("/agregar-empleado")
    private String verFormularioRegistroEmpleado(Empleado empleado, Model model){
        model.addAttribute("empresas",empresaService.verEmpresa());

        return "agregar-empleado";
    }

    @PostMapping("/empleados")
    private String crearYActualizarEmpleado(Empleado empleado){
        empleadoService.crearYActualizarEmpleado(empleado);
        return "redirect:/empleados";
    }

    @GetMapping("/empleados/borrar/{id}")
    private String eliminarEmpleado(@PathVariable("id") Long id){
        empleadoService.eliminarEmpleado(id);
        return "redirect:/empleados";
    }

    @GetMapping("/empleados/editar/{id}")
    private String verEmpleadoPorId(@PathVariable("id") Long id, Model model){
        Empleado empleado = empleadoService.verEmpleadoPorId(id);
        model.addAttribute("empresas",empresaService.verEmpresa());
        model.addAttribute("empleado", empleado);
        return "actualizar-empleado";
    }

    @PutMapping("/empleados/actualizar/{id}")
    private RedirectView editarEmpleado(@PathVariable("id") Long id, Empleado empleado){
        empleadoService.crearYActualizarEmpleado(empleado);
        return new RedirectView("/empleados");
    }
}
