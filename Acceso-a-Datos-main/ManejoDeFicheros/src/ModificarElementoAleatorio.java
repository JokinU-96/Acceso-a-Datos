import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ModificarElementoAleatorio {
    public static void main(String[] args) {
        //Crea un programa en Java que reciba desde la línea de comandos un identificador de empleado y un
        //importe. Se debe sumar al salario del empleado el importe tecleado. El programa debe visualizar
        // el apellido, el salario antiguo y el nuevo.

        //Si el identificador no existe se visualizará un mensaje indicándolo.

        File fichero = new File("empleados.dat");

        //Defino tamaños del patrón de datos.
        int idBytes = 4;
        int apellidoBytes = 20;
        int idDepartamentoBytes = 4;
        int sueldoBytes = 8;

        long totalBytes = idBytes + apellidoBytes + idDepartamentoBytes + sueldoBytes;

        try {
            RandomAccessFile raf = new RandomAccessFile(fichero, "rw");

            long numeroRegistrosTotal = raf.length() / totalBytes;
            System.out.println("Numero de registros: " + numeroRegistrosTotal);

            System.out.println("Elige la operación:\n" +
                    "1. Eliminar un registro.\n" +
                    "2. Incrementar el salario de un registro.\n" +
                    "3. Salir");
            try{
                int opcion = 0;
                while(opcion > 3 || opcion == 0){
                    opcion = Integer.parseInt(System.console().readLine());
                    if(opcion > 3){
                        System.out.println("Escribe un valor correcto.");
                    }
                }


                switch (opcion){
                    case 1:


                }


            } catch (NumberFormatException e) {
                System.out.println("Escribe un valor numérico.");
            }

        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}
