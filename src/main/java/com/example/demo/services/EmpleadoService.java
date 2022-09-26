package com.example.demo.services;

import com.example.demo.entities.Empleado;
import com.example.demo.repositories.EmpleadoRepository;
import com.example.demo.repositories.EmpresaRepository;
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
        System.out.println("fuera if");
        if(existEmpresa(empleado.getEmpresa().getId())){
            System.out.println("primer if");
            System.out.println(empleado.getId());
            if(getEmpleado(empleado.getId())==null) {
                System.out.println("segundo if");
                return repository.save(empleado);
            }
        }
        return null;
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
    private boolean existEmpresa(int id){
        return repository.getEmpresasById(id).size()>0;
    }
}
