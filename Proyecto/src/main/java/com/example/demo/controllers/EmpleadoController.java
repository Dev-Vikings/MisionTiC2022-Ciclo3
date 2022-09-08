package com.example.demo.controllers;

import com.example.demo.entities.Empleado;
import com.example.demo.services.EmpleadoService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpleadoController {
    EmpleadoService service;

    public EmpleadoController(EmpleadoService service) {
        this.service = service;
    }
}
