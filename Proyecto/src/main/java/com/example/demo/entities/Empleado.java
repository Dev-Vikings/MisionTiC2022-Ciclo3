package com.example.demo.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="empleado")
public class Empleado {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empleado")
    @SequenceGenerator(name="empleado",sequenceName="DB_SEQUENCIA2", allocationSize=1)
    private int id;
    @Column(name = "nombre",nullable = false)
    private String nombre;
    @Column(name = "correo")
    private String correo;

    @ManyToOne
    @JoinTable(name="empresa_id")
    private Empresa empresa;
    @Column(name = "rol")
    private String rol;

    public Empleado(){}

    public Empleado(String nombre, String correo, Empresa empresa, String rol) {
        this.nombre = nombre;
        this.correo = correo;
        this.empresa = empresa;
        this.rol = rol;
//        this.movdinero = movdinero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getId() {
        return id;
    }

//    public void setId(Integer id) {
//        this.id = id;
//    }


//    public MovimientoDinero getMovdinero() {
//        return movdinero;
//    }
//
//    public void setMovdinero(MovimientoDinero movdinero) {
//        this.movdinero = movdinero;
//    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", empresa='" + empresa + '\'' +
                ", rol='" + rol + '\'' +
//                ", movdinero=" + movdinero +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return id == empleado.id && nombre.equals(empleado.nombre) && empresa.equals(empleado.empresa)/* && movdinero.equals(empleado.movdinero)*/;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, empresa/*, movdinero*/);
    }
}
