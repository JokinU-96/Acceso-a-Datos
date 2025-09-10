import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EscribirFichTexto {
    public static void main(String[] args) {
        File fichero = new File("FichTexto.txt");
        try {
            FileWriter fw = new FileWriter(fichero, false);
            String texto = "El texto que deseo escribir.";
            String textoB = "\nEl texto que escribo con un bucle For";

            char[] ta = texto.toCharArray();

            fw.write(ta);

            for(int i = 0; i < textoB.length(); i++) {
                fw.write(textoB.charAt(i));
            }

            fw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
