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

            // Lleno el array con un carácter.
            for (int i = 0; i < bfr.length; i++){
                bfr[i] = '-';
            }

            // Muestro el array por pantalla antes de modificarlo.
            for (int i=0; i<bfr.length; i++){
                System.out.print(bfr[i]);
            }

            System.out.println("\nSu contenido es: ");

            int l = bfr.length;

            // Mientras lea un valor que devuelva un número distinto a -1
            // leo el bfr o el array de carácteres con un offset de 2 al principio y con un máximo de l - 5 carácteres.
            // es decir, de la posición 3 a la 45 hago un println del bfr.
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
