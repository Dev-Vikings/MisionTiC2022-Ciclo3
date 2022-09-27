package com.backend.DEVikings.controller;

import com.backend.DEVikings.model.Empleado;
import com.backend.DEVikings.model.Transaccion;
import com.backend.DEVikings.service.EmpleadoService;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class TransaccionController {

    @Autowired
    TransaccionService transaccionService;
    WebController webController;
    EmpresaService empresaService;
    EmpleadoService empleadoService;

    public TransaccionController(TransaccionService transaccionService, WebController webController, EmpresaService empresaService,EmpleadoService empleadoService) {
        this.transaccionService = transaccionService;
        this.webController = webController;
        this.empresaService=empresaService;
        this.empleadoService=empleadoService;

    }

    @GetMapping("/transacciones")
    private String verTransaccion(Model model,@AuthenticationPrincipal OidcUser principal){
        if (principal != null) {

            String email= (String) principal.getClaims().get("email");
            Empleado empleado=empleadoService.getEmpleadobyEmail(email);
            Long idEmpresa=empleado.getEmpresa().getId();
            model.addAttribute("empleado", empleado);
//            model.addAttribute("transacciones", transaccionService.verTransaccion());
            model.addAttribute("transacciones", transaccionService.verTransaccionByEmpresaID(idEmpresa));


            model.addAttribute("empresas",empresaService.verEmpresa());
//            System.out.println(transaccionService.verTransaccionByEmpresaID(1).get(0).getEmpleado().getEmpresa().getNombre());
//            System.out.println(transaccionService.verTransaccionByEmpresaID(1).size());


            return "transacciones";
    }
        webController.index(model,principal);
        return "index";
    }

    @GetMapping("/agregar-transaccion")
    private String verFormularioRegistroTransaccion(Transaccion transaccion,@AuthenticationPrincipal OidcUser principal,Model model){

        String email= (String) principal.getClaims().get("email");
        Empleado empleado=empleadoService.getEmpleadobyEmail(email);
        model.addAttribute("empleado", empleado);

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
    private String verTransaccionPorId(@PathVariable("id") Long id, Model model, @AuthenticationPrincipal OidcUser principal){

        String email= (String) principal.getClaims().get("email");
        Empleado empleado=empleadoService.getEmpleadobyEmail(email);
        model.addAttribute("empleado", empleado);

        Transaccion transaccion = transaccionService.verTransaccionPorId(id);
        model.addAttribute("transaccion", transaccion);
        return "actualizar-transaccion";
    }

    @PutMapping("/transacciones/actualizar/{id}")
    private RedirectView editarTransaccion(@PathVariable("id") Long id, Transaccion transaccion){
        transaccionService.crearYActualizarTransaccion(transaccion);
        return new RedirectView("/transacciones");
    }
}
