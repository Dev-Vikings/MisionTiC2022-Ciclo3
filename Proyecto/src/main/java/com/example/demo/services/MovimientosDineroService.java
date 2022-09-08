package com.example.demo.services;

import com.example.demo.repositories.EmpleadoRepository;
import org.springframework.stereotype.Service;

@Service
public class MovimientosDineroService {

    private EmpleadoRepository repository;

    public MovimientosDineroService(EmpleadoRepository repository) {
        this.repository = repository;
    }

    public EmpleadoRepository getRepository() {
        return repository;
    }

    public void setRepository(EmpleadoRepository repository) {
        this.repository = repository;
    }
}
