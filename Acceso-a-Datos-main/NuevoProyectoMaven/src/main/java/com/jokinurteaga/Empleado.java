package com.jokinurteaga;

public class Empleado {
    int id ;
    String apellido;
    String oficio;
    double salario;

    public Empleado(int id, String apellido, String oficio, double salario) {
        this.id = id;
        this.apellido = apellido;
        this.oficio = oficio;
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Empleado:\n" +
                "\tApellido= " + apellido + "\n" +
                "\tOficio= " + oficio + "\n" +
                "\tSalario= " + salario + "\n";
    }
}
