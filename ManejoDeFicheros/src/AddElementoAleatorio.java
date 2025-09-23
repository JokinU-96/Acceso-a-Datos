import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Array;

public class AddElementoAleatorio {

    public static Empleado recogerDatos(){
        System.out.println("Para insertar un nuevo registro sigue los siguientes pasos: ");
        String apellido = "sin asignar";
        while(apellido.length() > 10){
            System.out.println("Introduce un apellido: ");
            apellido = System.console().readLine();
            if(apellido.length() > 10){
                System.out.println("Introduce un apellido de menos de 10 carácteres.");
            }
        }

        System.out.println("Introduce el código del departamento: ");
        int codigo = 0;

        try{
            while(codigo < 9 || codigo > 100){
                codigo = Integer.parseInt(System.console().readLine());
                if (codigo < 9 || codigo > 100) {
                    System.out.println("Introduce un número entre 10 y 99.");
                }
            }
        } catch(NumberFormatException e){
            System.out.println("Introduce el codigo del departamento correctamente.");
        }

        System.out.println("Introduce el salario: ");
        double salario = 0;
        try{
            salario = Double.parseDouble(System.console().readLine());

        }catch(NumberFormatException e){
            System.out.println("Introduce el salario correctamente.");
        }

        Empleado empleado = new Empleado(0, apellido, codigo, salario);
        return empleado;

    }

    public static void main(String[] args) {
        //Crea un programa Java que reciba desde la línea de comandos un apellido
        //de empleado, un departamento y un salario. Se debe añadir al empleado al final del archivo de
        //registros si no hay un hueco disponible, si hay algún hueco disponible,
        //tendrá que escribirse en el primero de ellos.

        //El programa debe visualizar el registro completo de empleados después de añadirlo.

        File fichero = new File("empleados.dat");

        //Defino tamaños del patrón de datos.
        int idBytes = 4;
        int apellidoBytes = 20;
        int idDepartamentoBytes = 4;
        int sueldoBytes = 8;

        long totalBytes = idBytes + apellidoBytes + idDepartamentoBytes + sueldoBytes;

        try {
            RandomAccessFile raf = new RandomAccessFile(fichero, "rw");
            long numeroRegistrosTotal = (raf.length() / totalBytes);
            System.out.println("Número total de registros: " + numeroRegistrosTotal);

            Empleado nuevoEmpleado = recogerDatos();

            boolean datosInsertados = false;
            for(int i = 0; i < numeroRegistrosTotal; i++){
                raf.seek(i * totalBytes);
                //Me aseguro de que los Id sean únicos.
                nuevoEmpleado.setId(raf.readInt() + 10);

                if(raf.readInt() == -1){
                    //Escribo los datos en el registro vacío (Id = -1 = vacío).
                    System.out.println("Rellenando un hueco vacío en la posición " + i);
                    insertarDatos(nuevoEmpleado, raf, i);
                    datosInsertados = true;
                }
            }

            if(!datosInsertados){
                //Añado un registro al final del fichero.
                insertarDatos(nuevoEmpleado, raf, raf.length());
            }

            System.out.println("Número total de registros: " + raf.length() / totalBytes);
            raf.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void insertarDatos(Empleado empleado, RandomAccessFile raf, long posicion) throws IOException {
        //Defino tamaños del patrón de datos.
        int idBytes = 4;
        int apellidoBytes = 20;
        int idDepartamentoBytes = 4;
        int sueldoBytes = 8;

        int totalBytes = idBytes + apellidoBytes + idDepartamentoBytes + sueldoBytes;
        long registrosCompletados = raf.length();//Tamaño del fichero antes de empezar a escribir el nuevo empleado.

        //Posiciono el cursor para empezar a escribir.
        if (posicion == raf.length()) {
            //Opción 1: Escribir al final del fichero.
            raf.seek(raf.length());
        } else {
            //Opción 2: Escribir en una posición determinada.
            raf.seek(posicion * totalBytes);
        }
        System.out.println("Comienzo el registro en la posición: " + raf.getFilePointer());

        //Inserto los datos del empleado nuevo.
        //ID
        raf.writeInt(empleado.getId());

        //Apellido
        if(empleado.getApellido().length() > 10){
            //En el caso de que ocupe más de 20 bytes recorto el apellido.
            raf.writeChars(empleado.getApellido().substring(0, 10));
        } else {
            raf.writeChars(empleado.getApellido());
        }

        //Después del apellido hay que desplazarse para evitar romper el patrón.
        if (posicion == registrosCompletados) {
            //Cantidad de bytes antes de añadir nada
            long offset = idBytes + apellidoBytes;//más el offset del apellido.
            raf.seek( registrosCompletados + offset);
        } else {
            raf.seek((posicion * totalBytes) + idBytes + apellidoBytes);
        }
        //Departamento.
        raf.writeInt(empleado.getDepartamento());

        //Salario
        raf.writeDouble(empleado.getSalario());

        System.out.println("Nuevo registro añadido correctamente.\n\t" + empleado);
    }
}
