import java.io.*;

public class LeerFichTexto {
    public static void main(String[] args) {
        try {
            File f = new File(args[0]);
            System.out.println("El fichero es: " + f.getName());

            FileReader fr = new FileReader(f);
            int i = 0;
            System.out.println("Su contenido es: ");

            while ((i = fr.read()) != -1) {
                System.out.print((char) i);
            }
            fr.close();

        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado");
        } catch (IOException e) {
            System.out.println("Error al leer fichero");
        }
    }
}
