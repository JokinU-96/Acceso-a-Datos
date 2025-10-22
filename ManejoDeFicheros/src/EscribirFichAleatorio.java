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

        empleados.add(new Empleado(10, "Urteaga", 20, 3400.45));
        empleados.add(new Empleado(-1, "Urteaga", 20, 3400.45));
        empleados.add(new Empleado(20, "Zengotitabengoa", 10, 2300.25));
        empleados.add(new Empleado(30, "Luis Miguel", 20, 2300.25));
        empleados.add(new Empleado(40, "Antonio", 20, 2300.25));
        empleados.add(new Empleado(50, "Pedro", 20, 2300.25));

        int totalPorRegistro = 36; //Son 36 bytes por registro.
        int offsetDepartamento = 24; //Son 24 bytes de datos hasta el punto final del departamento. (4 bytes del ID + 20 bytes del apellido)

        try {
            RandomAccessFile raf = new RandomAccessFile(fichero, "rw");

            for(int i = 0; i < empleados.size(); i++){
                //Escribo el identificador de cada registro en un entero de 4 bytes.
                //Necesito que sean números entre 10 y 99.
                System.out.println("Comienzo del registro: " + raf.getFilePointer());
                raf.writeInt(empleados.get(i).getId());
                System.out.println("Termino con el ID del registro: " + raf.getFilePointer() + " || ID: " +  empleados.get(i).getId());

                //Escribo el apellido de cada empleado en una cadena de carácteres de 20 bytes.
                //Necesito comprobar que el apellido introducido no sea mayor al espacio en memoria. (20 bytes = 10 carácteres)
                System.out.println("Inserto el apellido: " + raf.getFilePointer());
                if(empleados.get(i).getApellido().length() > 10){
                    //En el caso de que ocupe más de 20 bytes recorto el apellido.
                    raf.writeChars(empleados.get(i).getApellido().substring(0, 10));
                    System.out.println("Apellido: " + empleados.get(i).getApellido().substring(0, 10));
                } else {
                    raf.writeChars(empleados.get(i).getApellido());
                    System.out.println("Apellido: " + empleados.get(i).getApellido());
                }
                System.out.println("FIN apellido: " + raf.getFilePointer());

                //Necesito asegurarme de estar en la posición correcta en la memoria de mi patrón de datos.
                //De este modo puedo seguir introduciendo el siguiente dato donde corresponde.
                raf.seek(((long) i * totalPorRegistro) + offsetDepartamento);
                System.out.println("Desplazado: " + raf.getFilePointer());

                //Escribo el identificador de cada departamento en un entero de 4 bytes.
                //Necesito que sean números entre 10 y 99.
                raf.writeInt(empleados.get(i).getDepartamento());
                System.out.println("Código de departamento FIN: " + raf.getFilePointer());

                //Escribo el salario en un Double de 8 bytes.
                raf.writeDouble(empleados.get(i).getSalario());
                System.out.println("FIN: " + raf.getFilePointer() + "\n");

            }

            //Termino el búcle y muestro por consola los datos del fichero.
            System.out.println("Tamaño total del fichero: " + raf.length());
            System.out.println("Número de registros: " + raf.length() / totalPorRegistro);

            raf.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //raf.writeChars(apellidos[i].length() > 10 ? apellidos[i].substring(0, 10) : apellidos[i]);


    }
}
