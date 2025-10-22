import java.io.*;
public class VerDir {
    public static void main(String[] args) {
        System.out.println("Archivos en el directorio raíz del sistema:");
        File f = new File("/");
        String[] archivos = f.list();
        for (int i = 0; i < archivos.length; i++) {
            System.out.println(archivos[i]);
        }
    }
}