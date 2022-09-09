package com.example.demo.services;

import com.example.demo.entities.Empleado;
import com.example.demo.repositories.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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


    public List<Empleado> getEmpleados(){
        return repository.findAll();
    }

    public Empleado getEmpleado(int id){
        Optional<Empleado> optEmpleado=repository.findById(id);
        if(optEmpleado.isPresent()){
            return optEmpleado.get();
        }
        return null;
    }

    public Empleado nuevoEmpleado(Empleado empleado){
        return repository.save(empleado);
    }

    public Empleado patchEmpleado(Empleado empleadoNew, Empleado empleadoOld){
        empleadoOld.setCorreo(empleadoNew.getCorreo());
        empleadoOld.setEmpresa(empleadoNew.getEmpresa());
        empleadoOld.setNombre(empleadoNew.getNombre());
        empleadoOld.setRol(empleadoNew.getRol());
        return repository.save(empleadoOld);
    }

    public void deleteEmpleado(Empleado empleado){
        repository.delete(empleado);
    }
}
