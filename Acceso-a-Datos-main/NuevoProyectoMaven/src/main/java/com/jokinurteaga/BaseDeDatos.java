package com.jokinurteaga;

import java.sql.*;
import java.util.ArrayList;

public class BaseDeDatos {
    public Connection conectar() {
        try {
            // Establecemos la conexion con la BD
            return DriverManager.getConnection("jdbc:sqlite:empresa.sqlite");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void getDepartamentos() {
        try {

            Connection conexion = conectar();
            // Preparamos la consulta
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery("SELECT * FROM departamentos");
            // Recorremos el resultado para visualizar cada fila
            // Se hace un bucle mientras haya registros, se van visualizando
            while (resultado.next()) {
                System.out.println(
                        resultado.getInt(1) + " " +
                                resultado.getString(2) + " " +
                                resultado.getString(3)
                );
            }
            resultado.close();// Cerrar ResultSet
            sentencia.close();// Cerrar Statement
            conexion.close();//Cerrar conexion
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Empleado> getEmpleadosByDeptNo(int deptNo) {
        ArrayList<Empleado> empleados = new ArrayList<>();

        try {

            Connection conexion = conectar();
            // Preparamos la consulta
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery("SELECT emp_no, apellido, oficio, salario FROM empleados WHERE dept_no = " + deptNo + ";");
            // Recorremos el resultado para visualizar cada fila
            // Se hace un bucle mientras haya registros, se van visualizando
            while (resultado.next()) {
                int empNo = resultado.getInt(1);
                String apellido = resultado.getString(2);
                String oficio = resultado.getString(3);
                double salario = resultado.getDouble(4);

                empleados.add(new Empleado(empNo, apellido, oficio, salario));

            }
            resultado.close();// Cerrar ResultSet
            sentencia.close();// Cerrar Statement
            conexion.close();//Cerrar conexion
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return empleados;
    }

    public double getSalarioMaximo() {
        double salario = 0;

        Connection conexion = conectar();
        // Preparamos la consulta
        Statement sentencia = null;
        try {
            sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery("SELECT MAX(salario) FROM empleados;");
            while (resultado.next()) {
                salario = resultado.getDouble(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return salario;

    }

    public void aumentarSalarioMaximo(double salario, int porcentaje) {

        double n = (double) (porcentaje + 100) / 100;
        try {
            Connection conexion = conectar();
            // Preparamos la consulta
            Statement sentencia = conexion.createStatement();
            sentencia.executeUpdate("UPDATE empleados SET salario=salario*" + n + " WHERE salario=" + salario + ";");
            sentencia.close();
            conexion.close();

            System.out.println("\nEl salario ha sido modificado. -- " + getSalarioMaximo());


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
