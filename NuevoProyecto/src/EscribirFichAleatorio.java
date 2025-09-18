import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class EscribirFichAleatorio {
    public static void main(String[] args) {
        File fichero = new File("empleados.dat");

        List<Empleado> empleados = new ArrayList<>();

        empleados.add(new Empleado(1, "Urteaga", 2, 3400.45));
        empleados.add(new Empleado(2, "Zengotitabengoa", 1, 2300.25));
        empleados.add(new Empleado(3, "Luis Miguel", 2, 2300.25));
        empleados.add(new Empleado(4, "Antonio", 2, 2300.25));
        empleados.add(new Empleado(5, "Pedro", 2, 2300.25));

        try (RandomAccessFile raf = new RandomAccessFile(fichero, "rw")) {
            StringBuilder bufferApellido;
            int n = empleados.size();

            for (int i = 0; i < n; i++) {
                // Escribir el ID del empleado (índice + 1)
                raf.writeInt(i + 1);

                // Escribir el apellido
                bufferApellido = new StringBuilder(empleados.get(i).getApellido());
                bufferApellido.setLength(10); // Asegurar 10 caracteres
                raf.writeChars(bufferApellido.toString());

                // Escribir el departamento
                raf.writeInt(empleados.get(i).getDepartamento());

                // Escribir el salario
                raf.writeDouble(empleados.get(i).getSalario());
            }

            System.out.println("✅ Datos de empleados insertados correctamente en 'empleados.dat'.");

        } catch (IOException e) {
            System.err.println("❌ Error de E/S: " + e.getMessage());
        }

    }
}
