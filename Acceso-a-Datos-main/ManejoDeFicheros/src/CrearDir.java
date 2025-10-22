import java.io.File;
import java.io.IOException;

public class CrearDir {
    public static void main(String[] args){
        //Realiza un programa Java que cree un directorio en el directorio actual,
        //a continuación crea dos ficheros en el directorio.
        //Elimina uno de los ficheros y elimina el directorio

        System.out.println("Creando Directorio...");
        File d = new File(args[0] + "/NUEVODIR");

        try {
            d.mkdir();

            File f1 = new File(d, "fichero1.txt");
            if (f1.createNewFile()){
                System.out.println("Fichero 1 creado correctamente");
            };

            File f2 = new File(d, "fichero2.txt");

            if (f2.createNewFile()){
                System.out.println("Fichero 2 creado correctamente");
            };

            if (f1.delete()){System.out.println("Fichero 1 borrado.");};
            System.out.println("Fichero eliminado.");

            d.delete();

            if (d.exists()) {
                System.out.println("Para poder eliminar el directorio, este debe estar vacío.");
            } else {

                System.out.println("Directorio eliminado.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }


    }
}
