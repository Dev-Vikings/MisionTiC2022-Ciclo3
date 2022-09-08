package com.example.demo.controllers;

import com.example.demo.services.MovimientosDineroService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovimientoDineroController {
    MovimientosDineroService service;

    public MovimientoDineroController(MovimientosDineroService service) {
        this.service = service;
    }
}
