package com.example.demo.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="empresa")
public class Empresa {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name="nombre",nullable = false)
    private String nombre;
    @Column(name="direccion")
    private String direccion;
    @Column(name="telefono")
    private Integer telefono;
    @Column(name="nit",nullable = false)
    private Integer nit;



    public Empresa(){

    }

    public Empresa(String nombre, String direccion, Integer telefono, Integer nit) {

        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.nit = nit;
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

    public Integer getNit() {
        return nit;
    }

    public void setNit(Integer nit) {
        this.nit = nit;
    }

    public int getId() {
        return id;
    }
// Se evita con el fin de que cuando se utilize el Post no se sobre escriba un registro ya existente
//    public void setId(Integer id) {
//        this.id = id;
//    }

    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono=" + telefono +
                ", NIT=" + nit +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empresa empresa = (Empresa) o;
        return id == empresa.id && nombre.equals(empresa.nombre) && nit.equals(empresa.nit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, nit);
    }
}
