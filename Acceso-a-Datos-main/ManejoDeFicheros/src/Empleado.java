public class Empleado {
    int id;
    String apellido;
    int departamento;
    double salario;

    public Empleado(int id, String apellido, int departamento, double salario) {
        this.id = id;
        this.apellido = apellido;
        this.departamento = departamento;
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public String getApellido() {
        return apellido;
    }

    public int getDepartamento() {
        return departamento;
    }

    public double getSalario() {
        return salario;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDepartamento(int departamento) {
        this.departamento = departamento;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Empleado: \n" +
                "id=" + id +
                ", apellido='" + apellido + '\'' +
                ", departamento=" + departamento +
                ", salario=" + salario;
    }
}
