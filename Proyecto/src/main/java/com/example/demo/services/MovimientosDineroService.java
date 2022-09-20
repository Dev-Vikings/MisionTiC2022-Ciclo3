package com.example.demo.services;

import com.example.demo.entities.MovimientoDinero;
import com.example.demo.repositories.MovimientosDineroRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class MovimientosDineroService {

    private MovimientosDineroRepository repository;

    public MovimientosDineroService(MovimientosDineroRepository repository) {
        this.repository = repository;
    }

    public MovimientosDineroRepository getRepository() {
        return repository;
    }

    public void setRepository(MovimientosDineroRepository repository) {
        this.repository = repository;
    }

    //get
    public MovimientoDinero getMovimientoDinero(int id){
        Optional<MovimientoDinero> optMovmientoDinero=repository.findById(id);
        if(optMovmientoDinero.isPresent()){
            return optMovmientoDinero.get();
        }
        return null;
    }
    //post
    public MovimientoDinero nuevoMovimientoDinero(MovimientoDinero movimientoDinero){
        return repository.save(movimientoDinero);
    }
    //patch
    public MovimientoDinero patchMovimientoDinero(MovimientoDinero movDineroOld,MovimientoDinero movDineroNew){
        movDineroOld.setConcepto(movDineroNew.getConcepto());
        movDineroOld.setMontoMovimiento(movDineroNew.getMontoMovimiento());
        movDineroOld.setEmpleado(movDineroNew.getEmpleado());
        return repository.save(movDineroOld);
    }

    //delete
    public void deleteMovimientoDinero(MovimientoDinero movimientoDinero){
        repository.delete(movimientoDinero);

    }



}
