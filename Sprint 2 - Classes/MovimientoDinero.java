package com.app;

public class MovimientoDinero {
    private float montoMovimiento;
    private String concepto;
    private String empleado;

    public MovimientoDinero(float montoMovimiento, String concepto, String empleado) {
        this.montoMovimiento = montoMovimiento;
        this.concepto = concepto;
        this.empleado = empleado;
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

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }
}
