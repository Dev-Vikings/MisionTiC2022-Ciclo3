package com.backend.DEVikings.controller;

import com.backend.DEVikings.model.Empresa;
import com.backend.DEVikings.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class EmpresaController {
    @Autowired
    EmpresaService empresaService;
    WebController webController;

    public EmpresaController(EmpresaService empresaService, WebController webController) {
        this.empresaService = empresaService;
        this.webController = webController;
    }

    @GetMapping("/empresas")
    private String verEmpresa(Model model,@AuthenticationPrincipal OidcUser principal){
        if (principal != null) {
            model.addAttribute("empresas", empresaService.verEmpresa());
            model.addAttribute("nick", principal.getClaims().get("nickname"));

            return "empresas";
        }
        webController.index(model,principal);
        return "index";
    }

    @GetMapping("/agregar-empresa")
    private String verFormularioRegistroEmpresa(Empresa empresa){
        return "agregar-empresa";
    }

    @PostMapping("/empresas")
    private String crearEmpresa(Empresa empresa){
        empresaService.crearYActualizarEmpresa(empresa);
        return "redirect:/empresas";
    }

    @GetMapping("/empresas/borrar/{id}")
    private String eliminarEmpresa(@PathVariable("id") Long id){
        empresaService.eliminarEmpresa(id);
        return "redirect:/empresas";
    }

    @GetMapping("empresas/editar/{id}")
    private String verEmpresaPorId(@PathVariable("id") Long id, Model model){
        Empresa empresa = empresaService.verEmpresaPorId(id);
        model.addAttribute("empresa", empresa);
        return "actualizar-empresa";
    }

    @PutMapping("/empresas/actualizar/{id}")
    private RedirectView editarEmpresa(@PathVariable("id") Long id, Empresa empresa){
        empresaService.crearYActualizarEmpresa(empresa);
        return new RedirectView("/empresas");
    }
}