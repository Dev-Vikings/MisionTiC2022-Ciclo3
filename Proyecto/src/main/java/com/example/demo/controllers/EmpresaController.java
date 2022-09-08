package com.example.demo.controllers;

import com.example.demo.entities.Empresa;
import com.example.demo.services.EmpresaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enterprises")
public class EmpresaController {
    EmpresaService service;

    EmpresaController(EmpresaService service) {
        this.service=service;
    }

    @PostMapping //Crear una empresa
    public Empresa newEmpresas(@RequestBody Empresa empresa){
        return service.nuevaEmpresa(empresa);
    }

    @GetMapping //Consultar todas las empresas
    public List<Empresa> getAllEmpresas(){
        return service.getEmpresas();
    }

    @GetMapping("/{id}")  //consultar una por el NIT
    public List<Empresa> getEmpresa(@PathVariable int id){

        return service.getEmpresa(id);

    }

    @PatchMapping("/{id}")
    public Empresa patchEmpresa(@RequestBody Empresa empresanew, @PathVariable int id){
        Empresa empresaold=service.getEmpresa(id).get(0);

            return service.patchEmpresa(empresaold,empresanew);

    }

    @DeleteMapping("/{id}") //Elimina una empresa utilizando el NIT
    //Borrar empresa
    public Empresa deleteEmpresa(@PathVariable int id){
        Empresa empresa=service.getEmpresa(id).get(0);

        if(empresa!=null){
            service.deleteEmpresa(id);
                return empresa;
            }


        return null;

    }


}
