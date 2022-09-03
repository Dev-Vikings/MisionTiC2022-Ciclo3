package com.example.demo.entities;

import java.util.ArrayList;

public class ListEmpresas {

    private ArrayList<Empresa> list;

    public ListEmpresas(){
        list =new ArrayList<>();
    }

    public Empresa findEmpresa(int NIT){
        for(Empresa empresa:list){
            if(Integer.compare(empresa.getNIT(), NIT)==0){
                return empresa;
            }
        }
        return null;
    }

    public boolean addEmpresa(Empresa empresa){
        if(findEmpresa(empresa.getNIT())==null){
            list.add(empresa);
            return true;
        }
        return false;
    }

    public Empresa updateEmpresa(Empresa empresa){
        Empresa empresaAux=findEmpresa(empresa.getNIT());
        if(empresaAux!=null){
            list.set(list.indexOf(empresaAux),empresa);
            return list.get(list.indexOf(empresa));
        }
        return null;
    }

    public Empresa deleteEmpresa(Empresa empresa){
        if(list.contains(empresa)){
            list.remove(empresa);
            return empresa;
        }
        return null;
    }

    public ArrayList<Empresa> getList() {
        return (ArrayList<Empresa>) list.clone();
    }
}


