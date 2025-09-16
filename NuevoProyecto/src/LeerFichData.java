import java.io.*;

public class LeerFichData {
    public static void main(String[] args) {
        File fichero = new File("FichData.dat");
        FileInputStream filein = null;
        try {
            filein = new FileInputStream(fichero);

            DataInputStream dataIS = new DataInputStream(filein);

            int orden = 0;
            while(dataIS.available()>0) {
                String nombre = dataIS.readUTF();
                int edad =  dataIS.readInt();

                System.out.println("Sujeto número " + "\n" + nombre + " --- Edad: " + edad + "\n");
            }

//            for (int i = 0; i < 9 ; i++){// Leyendo texto UTF.
//                String nombre = dataIS.readUTF();
//                int edad =  dataIS.readInt();
//                System.out.println("Sujeto número " + (i + 1) + "\n" + nombre + " --- " + edad + "\n");
//
//            }

        } catch (FileNotFoundException ex) {

            // Display message when FileNotFoundException occurs
            System.out.println("Cannot Open the Output File");
            return;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }// Catch block to handle the exceptions

    }
}
