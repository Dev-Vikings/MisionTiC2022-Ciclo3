package com.example.demo.controllers;

import com.example.demo.entities.Empresa;
import com.example.demo.entities.MovimientoDinero;
import com.example.demo.services.MovimientosDineroService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movements/{id}")
public class MovimientoDineroController {
    MovimientosDineroService service;

    public MovimientoDineroController(MovimientosDineroService service) {
        this.service = service;
    }

    /***
     * Consula un movimiento de dinero especifico
     * 
     * @param id - Id del movimiento de dinero a consultar
     * @return el movimientoDinero consultado
     */
    @GetMapping
    public MovimientoDinero getMovimientoDinero(@PathVariable int id) {
        return service.getMovimientoDinero(id);
    }

    /***
     * Crea un nuevo movimiento de dinero
     * 
     * @param id               - Obtenido en la ruta /movements/{id} - Representa el
     *                         id del usuario relacionado con el movimiento de
     *                         dinero
     * @param movimientoDinero - JSON con la informacion
     *                         {"montoMovimiento":double,"concepto":String}
     * @return el registro del movimientoDinero del dinero
     */
    @PostMapping
    public MovimientoDinero newMovimientoDinero(@PathVariable int id, @RequestBody MovimientoDinero movimientoDinero) {
        return service.nuevoMovimientoDinero(movimientoDinero, id);
    }

    /***
     * Edita un movimientoDinero existente
     * 
     * @param id               - Id del movimiento de dinero a consultar
     * @param movimientoDinero JSON con la informacion a actualizar
     *                         {
     *                         "montoMovimiento": double,
     *                         "concepto": String,
     *                         "empleado": {
     *                         "id": int
     *                         },
     *                         "rol": String
     *                         }
     *                         }
     * @return el registro del movimientoDinero actualizado
     */
    @PatchMapping
    public MovimientoDinero patchMovimientoDinero(@PathVariable int id,
            @RequestBody MovimientoDinero movimientoDinero) {
        MovimientoDinero movDineroOld = service.getMovimientoDinero(id);
        if (movDineroOld != null) {
            return service.patchMovimientoDinero(movDineroOld, movimientoDinero);
        }
        return null;
    }

    /***
     * Elimina un movimientoDinero
     * 
     * @param id Id del movimiento de dinero a eliminar
     * @return el registro del movimientoDinero eliminado
     */
    @DeleteMapping
    public MovimientoDinero deleteMovimientoDinero(@PathVariable int id) {
        MovimientoDinero movimientoDinero = getMovimientoDinero(id);
        if (movimientoDinero != null) {
            service.deleteMovimientoDinero(movimientoDinero);
            return movimientoDinero;
        }
        return null;
    }
}
