package com.backend.DEVikings.service;

import com.backend.DEVikings.model.Empresa;
import com.backend.DEVikings.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {

    @Autowired
    EmpresaRepository empresaRepository;

    public void crearYActualizarEmpresa(Empresa empresa){
        empresaRepository.save(empresa);
    }

    public List<Empresa> verEmpresa(){
        return empresaRepository.findAll();
    }

    public Empresa verEmpresaPorId(Long id) {
        return empresaRepository.findById(id).get();
    }

    public void eliminarEmpresa(Long id){
        empresaRepository.deleteById(id);
    }
}
