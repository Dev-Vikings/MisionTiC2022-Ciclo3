package com.example.demo.controllers;

import com.example.demo.entities.Empleado;
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
        return service.nuevoEmpleado(empleado);
    }

    @GetMapping
    public List<Empleado> getAllEmpleados(@RequestBody Empleado empleado){
        return service.getEmpleados();
    }

    @GetMapping("/{id}")
    public Empleado getEmpleado(@PathVariable int id){
        return service.getEmpleado(id);
    }

    @PatchMapping("/{id}")
    public Empleado patchEmpleado(@PathVariable int id,@RequestBody Empleado empleado){
        Empleado empleadoOld=service.getEmpleado(id);
        if(empleadoOld!=null){
            return service.patchEmpleado(empleado, empleadoOld);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public Empleado deleteEmpleado(@PathVariable int id){
        Empleado empleado=getEmpleado(id);
        if(empleado!=null){
            service.deleteEmpleado(empleado);
            return empleado;
        }
        return null;    }

}
