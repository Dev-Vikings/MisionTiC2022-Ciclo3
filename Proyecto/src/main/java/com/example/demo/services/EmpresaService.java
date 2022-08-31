package com.example.demo.services;

import com.example.demo.entities.Empresa;

import java.util.List;

public class EmpresaService {
    Empresa empresa;

    public Empresa nuevaempresa(String nombre, String direccion, Integer telefono, Integer NIT){
        empresa=new Empresa(nombre,direccion,telefono,NIT);
        return empresa;
    }

    public List<Empresa> getEmpresas(){
        return null;
    }

    public Empresa getEmpresa(String id){
        return null;
    }

    public Empresa PatchEmpresa(String nombre, String direccion, Integer telefono, Integer NIT){
        return null;
    }

    public boolean DeleteEmpresa(String id){
        return false;
    }
}

