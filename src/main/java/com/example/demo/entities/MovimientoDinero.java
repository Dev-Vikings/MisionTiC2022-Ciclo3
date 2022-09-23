package com.example.demo.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "movdinero")
public class MovimientoDinero {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mov_dinero")
    @SequenceGenerator(name="mov_dinero",sequenceName="DB_SEQUENCIA3", allocationSize=1)
    private int id;
    @Column(name = "monto",nullable = false)
    private float montoMovimiento;
    @Column(name = "concepto")
    private String concepto;

    @ManyToOne
    @JoinTable(name="empleado_id")
    private Empleado empleado;

    public MovimientoDinero(){}

    public MovimientoDinero(int id, float montoMovimiento, String concepto, Empleado empleado) {
        this.montoMovimiento = montoMovimiento;
        this.concepto = concepto;
        this.empleado=empleado;
    }

    public float getMontoMovimiento() {
        return montoMovimiento;
    }

    public void setMontoMovimiento(float montoMovimiento) {
        this.montoMovimiento = montoMovimiento;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public int getId() {
        return id;
    }

//    public void setId(Integer id) {
//        this.id = id;
//    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public String toString() {
        return "MovimientoDinero{" +
                "id=" + id +
                ", montoMovimiento=" + montoMovimiento +
                ", concepto='" + concepto + '\'' +
                ", Empleado='" + empleado + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovimientoDinero that = (MovimientoDinero) o;
        return id == that.id && Float.compare(that.montoMovimiento, montoMovimiento) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, montoMovimiento,empleado);
    }
}
