package com.example.demo.services;

import com.example.demo.repositories.EmpleadoRepository;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoService {
    private EmpleadoRepository repository;

    public EmpleadoService(EmpleadoRepository repository) {
        this.repository = repository;
    }

    public EmpleadoRepository getRepository() {
        return repository;
    }

    public void setRepository(EmpleadoRepository repository) {
        this.repository = repository;
    }
}
