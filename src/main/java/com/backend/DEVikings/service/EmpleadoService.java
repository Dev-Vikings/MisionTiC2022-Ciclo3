package com.backend.DEVikings.service;

import com.backend.DEVikings.enums.Enum_Roles;
import com.backend.DEVikings.model.Empleado;
import com.backend.DEVikings.repository.EmpleadoRepository;
import com.backend.DEVikings.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class EmpleadoService {

    @Autowired
    EmpleadoRepository empleadoRepository;
    EmpresaService empresaService;

    public EmpleadoService(EmpleadoRepository empleadoRepository, EmpresaService empresaService) {
        this.empleadoRepository = empleadoRepository;
        this.empresaService = empresaService;
    }

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


    public Empleado saveEmpleadoLogin(Map<String, Object> dataUser){
        String email=(String) dataUser.get("email");
        Empleado empleado=empleadoRepository.findByCorreo(email);
        if(empleado==null){
            String name=(String) dataUser.get("nickname");
            String image=(String) dataUser.get("picture");
            String authid=(String) dataUser.get("sub");
            Empleado newEmpleado=new Empleado();
            newEmpleado.setCorreo(email);
            newEmpleado.setNombre(name);
            newEmpleado.setRol(Enum_Roles.Vikingo);
            newEmpleado.setEmpresa(empresaService.verEmpresaPorId(1L));
            newEmpleado.setAuth0id(authid);
            newEmpleado.setImage(image);
            empleadoRepository.save(newEmpleado);
        }
        return empleado;
    }

    public Empleado getEmpleadobyEmail(String email){
        return empleadoRepository.findByCorreo(email);
    }

}
