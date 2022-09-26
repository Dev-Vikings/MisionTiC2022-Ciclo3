package com.backend.DEVikings.controller;

import com.backend.DEVikings.model.Empleado;
import com.backend.DEVikings.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmpleadoController {

    @Autowired
    EmpleadoService empleadoService;

    @GetMapping("/empleados")
    private String verEmpleado(Model model){
        model.addAttribute("empleados", empleadoService.verEmpleado());
        return "empleados";
    }

    @GetMapping("/agregar-empleado")
    private String verFormularioRegistroEmpleado(Empleado empleado){
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
        model.addAttribute("empleado", empleado);
        return "actualizar-empleado";
    }

    @PostMapping("/empleados/actualizar/{id}")
    private String editarEmpleado(@PathVariable("id") Long id, Empleado empleado){
        empleadoService.crearYActualizarEmpleado(empleado);
        return "redirect:/empleados";
    }
}
