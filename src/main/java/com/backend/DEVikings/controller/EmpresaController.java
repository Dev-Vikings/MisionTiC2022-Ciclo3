package com.backend.DEVikings.controller;

import com.backend.DEVikings.model.Empresa;
import com.backend.DEVikings.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmpresaController {
    @Autowired
    EmpresaService empresaService;

    @GetMapping("/empresas")
    private String verEmpresa(Model model){
        model.addAttribute("empresas", empresaService.verEmpresa());
        return "empresas";
    }

    @GetMapping("/agregar-empresa")
    private String verFormularioRegistroEmpresa(Empresa empresa){
        return "agregar-empresa";
    }

    @PostMapping("/empresas")
    private String crearEmpresa(Empresa empresa){
        empresaService.crearYActualizarEmpresa(empresa);
        return "redirect:/empresas";
    }

    @GetMapping("/empresas/borrar/{id}")
    private String eliminarEmpresa(@PathVariable("id") Long id){
        empresaService.eliminarEmpresa(id);
        return "redirect:/empresas";
    }

    @GetMapping("empresas/editar/{id}")
    private String verEmpresaPorId(@PathVariable("id") Long id, Model model){
        Empresa empresa = empresaService.verEmpresaPorId(id);
        model.addAttribute("empresa", empresa);
        return "actualizar-empresa";
    }

    @PostMapping("/empresas/actualizar/{id}")
    private String editarEmpresa(@PathVariable("id") Long id, Empresa empresa){
        empresaService.crearYActualizarEmpresa(empresa);
        return "redirect:/empresas";
    }
}