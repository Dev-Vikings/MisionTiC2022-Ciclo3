package com.example.demo.controllers;

import com.example.demo.entities.Empleado;
import com.example.demo.services.EmpleadoService;
import com.example.demo.services.EmpresaService;
import com.example.demo.services.MovimientosDineroService;
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

    public FrontController(EmpleadoService empleadoService, EmpresaService empresaService, MovimientosDineroService movimientosDineroService){
        this.empleadoService = empleadoService;
        this.empresaService = empresaService;
        this.movimientosDineroService = movimientosDineroService;
    }

    //Metodos
    @GetMapping("/")
    public String index(Model model){
        return "index";
    }

    @GetMapping("/empleados")
    public String empleados(Model model){
        List<Empleado> empleados = empleadoService.getEmpleados();
        model.addAttribute("empleados", empleados);
        return "empleados";
    }
}
