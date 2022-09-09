package com.example.demo.controllers;

import com.example.demo.entities.Empresa;
import com.example.demo.entities.MovimientoDinero;
import com.example.demo.services.MovimientosDineroService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enterprises/{id}/movements")
public class MovimientoDineroController {
    MovimientosDineroService service;

    public MovimientoDineroController(MovimientosDineroService service) {
        this.service = service;
    }

    @GetMapping
    public MovimientoDinero getMovimientoDinero(@PathVariable int id){
        return service.getMovimientoDinero(id);
    }
    @PostMapping
    public MovimientoDinero newMovimientoDinero(@PathVariable int id,@RequestBody MovimientoDinero movimientoDinero){
        return service.nuevoMovimientoDinero(movimientoDinero);
    }
    @PatchMapping
    public MovimientoDinero patchMovimientoDinero(@PathVariable int id,@RequestBody MovimientoDinero movimientoDinero){
        MovimientoDinero movDineroOld=service.getMovimientoDinero(id);
        if(movDineroOld!=null){
            return service.patchMovimientoDinero(movDineroOld,movimientoDinero);
        }
        return null;
    }
    @DeleteMapping
    public MovimientoDinero deleteMovimientoDinero(@PathVariable int id){
        MovimientoDinero movimientoDinero=getMovimientoDinero(id);
        if(movimientoDinero!=null){
            service.deleteMovimientoDinero(movimientoDinero);
            return movimientoDinero;
        }
        return null;
    }
}
