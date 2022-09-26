package com.backend.DEVikings.service;

import com.backend.DEVikings.model.Empleado;
import com.backend.DEVikings.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpleadoService {

    @Autowired
    EmpleadoRepository empleadoRepository;

    public void crearYActualizarEmpleado(Empleado empleado){
        empleadoRepository.save(empleado);
    }

    public List<Empleado> verEmpleado(){
        return empleadoRepository.findAll();
    }


    public Empleado verEmpleadoPorId(Long id) {
        return empleadoRepository.findById(id).get();
    }

    public void eliminarEmpleado(Long id){
        empleadoRepository.deleteById(id);
    }
}
