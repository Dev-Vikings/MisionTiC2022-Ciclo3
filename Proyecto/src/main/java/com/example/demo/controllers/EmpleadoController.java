package com.example.demo.controllers;

import com.example.demo.entities.Empleado;
import com.example.demo.services.EmpleadoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {
    EmpleadoService service;

    public EmpleadoController(EmpleadoService service) {
        this.service = service;
    }

    /***
     * Crea un nuevo empleado meidante un POST request.
     * @param empleado - JSON con la informacion del empleado
     * {   "id": int,
     *     "nombre": String,
     *     "correo": String,
     *     "empresa": {
     *         "id": int,
     *     },
     *     "rol": String
     * }
     ** Solo es necesario suministrar el id de la empresa para la relacion.
     * @return El empleado creado
     */
    @PostMapping
    public Empleado newEmpleado(@RequestBody Empleado empleado){
        return service.nuevoEmpleado(empleado);
    }

    /***
     * Permite conocer todos los empleados registrados
     * @return JSON con todos los empleados de la organizacion
     */
    @GetMapping
    public List<Empleado> getAllEmpleados(){
        return service.getEmpleados();
    }

    /***
     * Permite obtener empleado con id especifico
     * @param id - id del empleado a consultar
     * @return JSON del empleado consultado
     */
    @GetMapping("/{id}")
    public Empleado getEmpleado(@PathVariable int id){
        return service.getEmpleado(id);
    }

    /***
     * Permite editar un Empleado
     * @param id - ID del empleado a editar
     * @param empleado - JSON con los datos a actualizar del empleado con el id suministrado
     *                 {
     *         "nombre": String,
     *         "correo": String,
     *         "empresa": {
     *             "id": int
     *         },
     *         "rol": String
     *     }
     * @return JSON con el registro actualizaod del empleado
     */
    @PatchMapping("/{id}")
    public Empleado patchEmpleado(@PathVariable int id,@RequestBody Empleado empleado){
        Empleado empleadoOld=service.getEmpleado(id);
//        if(empleado.getEmpresa().getId())
        if(empleadoOld!=null){
            return service.patchEmpleado(empleado, empleadoOld);
        }
        return null;
    }

    /***
     * Permite eliminar un empleado de un ID especifico
     * @param id - Id del empleado a eliminar
     * @return - JSON del empleado eliminado
     */
    @DeleteMapping("/{id}")
    public Empleado deleteEmpleado(@PathVariable int id){
        Empleado empleado=getEmpleado(id);
        if(empleado!=null){
            service.deleteEmpleado(empleado);
            return empleado;
        }
        return null;
    }

}

