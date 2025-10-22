import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LeerFichTexto3 {
    public static void main(String[] args) {
        try{

            File f = new File(args[0]);
            System.out.println("El fichero es: " + f.getName());

            BufferedReader br = new BufferedReader(new FileReader(f));
            String l;
            while((l = br.readLine()) != null){
                System.out.println(l);
            }

        }catch (Exception e){
            System.out.println("Error al leer fichero");
        }
    }
}
