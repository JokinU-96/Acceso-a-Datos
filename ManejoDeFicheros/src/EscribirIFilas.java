import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EscribirIFilas {
    public static void main(String[] args) {
        File fichero = new File("EscribirIFilas.txt");
        try{
            FileWriter fw = new FileWriter(fichero,false);
            BufferedWriter bw = new BufferedWriter(fw);

            int lineas = 20;

            for(int i = 1; i < lineas+1; i++){
                bw.write("Fila número " + i);
                bw.newLine();
            }

            //bw.write(texto);//Para que el buffer escriba todo.
            //bw.write(texto, 15, 50);//Para que se imprima un rango determinado del String.

            bw.close();
            fw.close();

        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}
