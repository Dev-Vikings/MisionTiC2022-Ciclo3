package com.backend.DEVikings.service;

import com.backend.DEVikings.model.Transaccion;
import com.backend.DEVikings.repository.TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransaccionService {

    @Autowired
    TransaccionRepository transaccionRepository;

    public void crearYActualizarTransaccion(Transaccion transaccion){
        transaccionRepository.save(transaccion);
    }

    public List<Transaccion> verTransaccion(){
        return transaccionRepository.findAll();
    }

    public Transaccion verTransaccionPorId(Long id){
        return transaccionRepository.findById(id).get();
    }

    public void eliminarTransaccion(Long id){
        transaccionRepository.deleteById(id);
    }
}