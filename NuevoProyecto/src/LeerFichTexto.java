import java.io.*;

public class LeerFichTexto {
    public static void main(String[] args) {
        File f = new File(args[0]);
        System.out.println("El fichero es: " + f.getName());

        try {

            FileReader fr = new FileReader(f);
            int i = 0;
            System.out.println("Su contenido es: ");

            while ((i = fr.read()) != -1) {
                System.out.print((char) i);
            }
            fr.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
