package com.jokinurteaga;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        BaseDeDatos bd = new BaseDeDatos();
        ArrayList<Empleado> empleados = bd.getEmpleadosByDeptNo(10);

        System.out.println("Empleados del departamento 10: ");
        for (Empleado empleado : empleados) {
            System.out.println(empleado);
        }

        double salario = bd.getSalarioMaximo();
        System.out.println("Salario maximo actual: " + salario);
        bd.aumentarSalarioMaximo(salario, 50);


    }
}
