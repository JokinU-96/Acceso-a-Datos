import java.io.*;

public class EscribirFichData {
    public static void main(String[] args) {
        File fichero = new File("FichData.dat"); //Crea el fichero con el que se trabajará.
        FileOutputStream fileout = null; //Crea un flujo de escritura.
        try {
            fileout = new FileOutputStream(fichero); //Define el nuevo flujo de escritura a partir del fichero.

            DataOutputStream dataOS = new DataOutputStream(fileout); //Define y crea un flujo de salida de datos.
            String[] nombres = {"Ana","Luis Miguel","Alicia","Pedro","Manuel","Andrés",
                    "Julio","Antonio","María Jesús"};
            int[] edades = {14,15,13,15,16,12,16,14,13};
            for (int i=0;i<edades.length; i++){
                dataOS.writeUTF(nombres[i]); //inserta nombre dentro del fichero con el metodo writeUTF, de modo que, tiene en cuenta carácteres de tipo unicode.
                dataOS.writeInt(edades[i]); //inserta edad hace lo mismo pero con las edades.
            }
            dataOS.close(); //cerrar stream
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
