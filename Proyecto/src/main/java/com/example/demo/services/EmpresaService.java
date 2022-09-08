package com.example.demo.services;

import com.example.demo.entities.Empresa;
import com.example.demo.repositories.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {
//    Empresa empresa;
    private EmpresaRepository repository;

    public EmpresaService(EmpresaRepository repository){
        this.repository=repository;
    }

    public List<Empresa> getEmpresas(){
        return this.repository.findAll();
    }
    public List<Empresa> getEmpresa(int nit){
            return this.repository.findById(nit);
//        return this.repository.find;
    }

    public Empresa nuevaEmpresa(Empresa empresa){
        return repository.save(empresa);
//        if(listEmpresa.addEmpresa(empresa)){
//            return empresa;
//        }
//        return null;
    }


    public Empresa patchEmpresa(Empresa empresaold, Empresa empresanew){
        System.out.println(empresaold.toString());
        System.out.println(empresanew.toString());

        empresaold.setNit(empresanew.getNit());
        empresaold.setNombre(empresanew.getNombre());
        empresaold.setDireccion(empresanew.getDireccion());
        empresaold.setTelefono(empresanew.getTelefono());
        return repository.save(empresaold);

//        return listEmpresa.updateEmpresa(empresa);
    }

    public void deleteEmpresa(int nit){
        Empresa empresa=repository.findById(nit).get(0);
        repository.delete(empresa);

    }


}

