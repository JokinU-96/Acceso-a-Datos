import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EscribirFichObject {
    public static void main(String[] args) {
        File fichero = new File("FichPersona.dat");
        try {
            FileOutputStream fileout = new FileOutputStream(fichero);
            ObjectOutputStream objectOS = new ObjectOutputStream(fileout);

            //Datos
            String[] nombres = {"Ana","Luis Miguel","Alicia","Pedro","Manuel","Andrés","Julio","Antonio","María Jesús"};
            int[] edades = {14,15,13,15,16,12,16,14,13};

            for(int i = 0;i < edades.length; i++){
                objectOS.writeObject(new Persona(nombres[i],edades[i]));
            }

            objectOS.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
