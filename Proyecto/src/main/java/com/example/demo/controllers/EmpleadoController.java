package com.example.demo.controllers;

import com.example.demo.entities.Empleado;
import com.example.demo.entities.Empresa;
import com.example.demo.services.EmpleadoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {
    EmpleadoService service;

    public EmpleadoController(EmpleadoService service) {
        this.service = service;
    }

    @PostMapping
    public Empleado newEmpleado(@RequestBody Empleado empleado){
        return null;
    }

    @GetMapping
    public List<Empleado> getAllEmpleados(@RequestBody Empleado empleado){
        return null;
    }

    @GetMapping("/{id}")
    public Empleado getEmpleado(@PathVariable int id){
        return null;
    }

    @PatchMapping("/{id}")
    public Empleado patchEmpleado(@PathVariable int id){
        return null;
    }

    @DeleteMapping("/{id}")
    public Empleado deleteEmpleado(@PathVariable int id){
        return null;
    }

}
