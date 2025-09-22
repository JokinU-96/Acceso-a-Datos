import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static java.lang.System.in;

public class LeerFichTexto2 {
    public static void main(String[] args) {
        try {
            File f = new File(args[0]);
            System.out.println("El fichero es: " + f.getName());

            FileReader fr = new FileReader(f);
            char[] bfr = new char[50];

            for (int i=0; i<bfr.length; i++){
                bfr[i] = '-';
            }

            for (int i=0; i<bfr.length; i++){
                System.out.print(bfr[i]);
            }

            System.out.println("\nSu contenido es: ");

            int l = bfr.length;

            while (fr.read(bfr, 2, (l - 5) ) != -1) {
                System.out.println(new String(bfr));
            }

            System.out.println("Ahora solo con un rango: ");

            //var i = fr.read(bfr, 150, 245);
            for (char c : bfr) {
                if (((int) c) == 0)
                    c = '-';
                System.out.print(c);
            }

            fr.close();

        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado");
        } catch (IOException e) {
            System.out.println("Error al leer fichero");
        }
    }
}
