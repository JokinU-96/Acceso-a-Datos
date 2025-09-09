import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EscribirFichTexto {
    public static void main(String[] args) {
        File fichero = new File("FichTexto.txt");
        try {
            FileWriter fw = new FileWriter(fichero, true);
            String texto = "El texto que deseo escribir.";

            char[] ta = texto.toCharArray();

            fw.write(ta);

            fw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
