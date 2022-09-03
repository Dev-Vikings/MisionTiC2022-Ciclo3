package com.example.demo.services;

import com.example.demo.entities.Empresa;
import com.example.demo.entities.ListEmpresas;

import java.util.ArrayList;
import java.util.List;

public class EmpresaService {
//    Empresa empresa;
    private ListEmpresas listEmpresa;

    public EmpresaService(){
        listEmpresa=new ListEmpresas();
    }

    public ArrayList<Empresa> getEmpresas(){
        return listEmpresa.getList();
    }

    public Empresa getEmpresa(int INT){

        return listEmpresa.findEmpresa(INT);
    }

    public Empresa nuevaEmpresa(Empresa empresa){
        if(listEmpresa.addEmpresa(empresa)){
            return empresa;
        }
        return null;
    }


    public Empresa patchEmpresa(Empresa empresa){
       return listEmpresa.updateEmpresa(empresa);
    }

    public Empresa deleteEmpresa(int NIT){
    return listEmpresa.deleteEmpresa(listEmpresa.findEmpresa(NIT));
    }
}

