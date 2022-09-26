package com.example.demo.controllers;

import com.example.demo.entities.Empresa;
import com.example.demo.services.EmpresaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enterprises")
public class EmpresaController {
    EmpresaService service;

    EmpresaController(EmpresaService service) {
        this.service = service;
    }

    /***
     * Permite crear una nueva empresa
     * 
     * @param empresa - JSON de la empresa a crear
     * @return JSON de la empresa creada
     */
    @PostMapping // Crear una empresa
    public Empresa newEmpresas(@RequestBody Empresa empresa) {
        return service.nuevaEmpresa(empresa);
    }

    /***
     * Permite obtener todos los registros de todas las empresas
     * 
     * @return JSON con todas las empresas
     */
    @GetMapping // Consultar todas las empresas
    public List<Empresa> getAllEmpresas() {
        return service.getEmpresas();
    }

    /***
     * Permite obtener el registro de una empresa con el NIT usando GET
     * 
     * @param id - NIT de la empresa a consultar
     * @return JSON del registro con el NIT suministrado
     */
    @GetMapping("/{id}") // consultar una por el NIT
    public List<Empresa> getEmpresa(@PathVariable int id) {
        return service.getEmpresa(id);
    }

    /***
     * Realiza la actualizacion del registro de una empresa usando PATCH
     * 
     * @param empresanew - JSON con los datos a modificar
     * @param id         - NIT de la empresa a modificar
     * @return JSON del registro actualizado
     */
    @PatchMapping("/{id}")
    public Empresa patchEmpresa(@RequestBody Empresa empresanew, @PathVariable int id) {
        Empresa empresaOld = service.getEmpresa(id).get(0);
        if (empresaOld != null) {
            if (empresanew.getNit() == null) {
                empresanew.setNit(empresaOld.getNit());
            }
            if ((empresanew.getNit() != empresaOld.getNit())) {
                if (!service.getEmpresa(empresanew.getNit()).isEmpty()) {
                    return null;
                }
            }
            return service.patchEmpresa(empresaOld, empresanew);
        }
        return null;
    }

    /***
     * Permite eleiminar una empresa con el NIT especificado usando DELETE
     * 
     * @param id - NIT de la empresa a eliminar
     * @return JSON de la empresa eliminada
     */
    @DeleteMapping("/{id}")
    public Empresa deleteEmpresa(@PathVariable int id) {
        Empresa empresa = service.getEmpresa(id).get(0);
        if (empresa != null) {
            service.deleteEmpresa(id);
            return empresa;
        }
        return null;
    }

    /***
     * Permite conocer una empresa con ID especifico usando GET
     * 
     * @param id - id de la empresa a consultar
     * @return JSON de la empresa con el id suministrado
     */
    @GetMapping("/id/{id}")
    public List<Empresa> getEmpresaById(@PathVariable int id) {
        return service.getEmpresaId(id);
    }

}
