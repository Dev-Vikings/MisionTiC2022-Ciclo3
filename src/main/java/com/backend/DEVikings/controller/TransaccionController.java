package com.backend.DEVikings.controller;

import com.backend.DEVikings.model.Transaccion;
import com.backend.DEVikings.service.EmpresaService;
import com.backend.DEVikings.service.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TransaccionController {

    @Autowired
    TransaccionService transaccionService;
    WebController webController;

    public TransaccionController(TransaccionService transaccionService, WebController webController) {
        this.transaccionService = transaccionService;
        this.webController = webController;
    }

    @GetMapping("/transacciones")
    private String verTransaccion(Model model,@AuthenticationPrincipal OidcUser principal){
        if (principal != null) {
        model.addAttribute("transacciones", transaccionService.verTransaccion());
        return "transacciones";
    }
        webController.index(model,principal);
        return "index";
    }

    @GetMapping("/agregar-transaccion")
    private String verFormularioRegistroTransaccion(Transaccion transaccion){
        return "agregar-transaccion";
    }

    @PostMapping("/transacciones")
    private String crearYActualizarTransaccion(Transaccion transaccion){
        transaccionService.crearYActualizarTransaccion(transaccion);
        return "redirect:/transacciones";
    }

//    Eliminar, Actualizar y Editar
    @GetMapping("/transacciones/borrar/{id}")
    private String eliminarTransaccion(@PathVariable("id") Long id){
    transaccionService.eliminarTransaccion(id);
    return "redirect:/transacciones";
}

    @GetMapping("/transacciones/editar/{id}")
    private String verTransaccionPorId(@PathVariable("id") Long id, Model model){
        Transaccion transaccion = transaccionService.verTransaccionPorId(id);
        model.addAttribute("transaccion", transaccion);
        return "actualizar-transaccion";
    }

    @PostMapping("/transacciones/actualizar/{id}")
    private String editarTransaccion(@PathVariable("id") Long id, Transaccion transaccion){
        transaccionService.crearYActualizarTransaccion(transaccion);
        return "redirect:/transacciones";
    }
}
