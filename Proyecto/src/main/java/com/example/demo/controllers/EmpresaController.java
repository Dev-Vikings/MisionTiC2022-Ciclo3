package com.example.demo.controllers;

import com.example.demo.entities.Empresa;
import com.example.demo.services.EmpresaService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class EmpresaController {
    EmpresaService service;

    EmpresaController() {
        service=new EmpresaService();
    }

    @PostMapping("/enterprises")
    public Empresa postEmpresas(@RequestBody Empresa empresa){
        return service.nuevaEmpresa(empresa);
    }

    @GetMapping("/enterprises")
    //consultar todas las empresas
    public ArrayList<Empresa> getAllEmpresas(){
        return service.getEmpresas();
    }


    @GetMapping("/enterprises/{id}")
    //consultar una empresa
    public Empresa getEmpresa(@PathVariable int id){
        return service.getEmpresa(id);
    }

    @PatchMapping("/enterprises/{id}")
    //editar empresa
    public Empresa patchEmpresa(@RequestBody Empresa empresa){
        return service.patchEmpresa(empresa);
    }

    @DeleteMapping("/enterprises/{id}")
    //Borrar empresa
    public Empresa deleteEmpresa(@PathVariable int id){
        return service.deleteEmpresa(id);
    }

}
