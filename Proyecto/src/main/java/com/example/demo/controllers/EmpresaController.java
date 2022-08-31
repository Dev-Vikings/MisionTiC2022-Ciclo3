package com.example.demo.controllers;

import com.example.demo.entities.Empresa;
import com.example.demo.services.EmpresaService;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmpresaController {
    EmpresaService service;

    @PostMapping("/enterprises")
    //crear empresa
    public Empresa setEmpresas(@PathVariable("nombre") String nombre, @PathVariable("direccion") String direccion,
                               @PathVariable("telefono") Integer telefono, @PathVariable("NIT") Integer NIT){
        service.nuevaempresa(nombre,direccion,telefono,NIT);
        return service.getEmpresa(NIT.toString());
    }

    @GetMapping("/enterprises")
    //consultar todas las empresas
    public String  getEmpresas(){
        return "GET";
    }


    @GetMapping("/enterprises/{id}")
    //consultar una empresa
    public String getEmpresa(@PathVariable("id") String id){
        return id.toString();
    }

    @PatchMapping("/enterprises/{id}")
    //editar empresa
    public String patchEmpresa(@PathVariable("id") String id){
        return id.toString();
    }

    @DeleteMapping("/enterprises/{id}")
    //Borrar empresa
    public String deleteEmpresa(@PathVariable("id") String id){
        return id.toString();
    }

}
