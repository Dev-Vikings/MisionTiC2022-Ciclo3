package com.app;

public class Empresa {
    private String nombre;
    private String direccion;
    private Integer telefono;
    private Integer NIT;

    public Empresa(String nombre, String direccion, Integer telefono, Integer NIT) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.NIT = NIT;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Integer getNIT() {
        return NIT;
    }

    public void setNIT(Integer NIT) {
        this.NIT = NIT;
    }
}
