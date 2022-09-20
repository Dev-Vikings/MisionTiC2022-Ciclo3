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
            return this.repository.findByNit(nit);
    }
    public List<Empresa> getEmpresaId(int id){
        return this.repository.findByUniqueId(id);
    }

    public Empresa nuevaEmpresa(Empresa empresa){

        if (getEmpresa(empresa.getNit()).isEmpty()) {
            return repository.save(empresa);
        }
        return null;
    }


    public Empresa patchEmpresa(Empresa empresaold, Empresa empresanew){
        empresaold.setNit(empresanew.getNit());
        empresaold.setNombre(empresanew.getNombre());
        empresaold.setDireccion(empresanew.getDireccion());
        empresaold.setTelefono(empresanew.getTelefono());
        return repository.save(empresaold);

    }

    public void deleteEmpresa(int nit){
        Empresa empresa=repository.findByNit(nit).get(0);
        repository.delete(empresa);

    }


}

