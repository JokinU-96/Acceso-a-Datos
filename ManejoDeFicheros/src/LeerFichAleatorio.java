import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class LeerFichAleatorio {
    public static void main(String[] args) {
        File fichero = new File("empleados.dat");

        //Defino tamaños del patrón de datos.
        int idBytes = 4;
        int apellidoBytes = 20;
        int idDepartamentoBytes = 4;
        int sueldoBytes = 8;

        int totalBytes = 0;
        totalBytes = idBytes + apellidoBytes + idDepartamentoBytes + sueldoBytes;

        try {
            RandomAccessFile raf = new RandomAccessFile(fichero , "rw");
            long numeroRegistrosTotal = (raf.length() / totalBytes);
            System.out.println("Número de registros total: " + numeroRegistrosTotal);

            for(int i = 0; i < numeroRegistrosTotal; i++) {
                raf.seek((long) i * totalBytes);//Para situarse al inicio de cada registro.

                //Recojo el identificador de cada registro.
                int idRegistro = raf.readInt();

                //Recojo el apellido.
                char[] apellidoChars = new char[10];

                for(int j = 0; apellidoChars.length > j; j++){
                    apellidoChars[j] = raf.readChar();
                }
                String apellido = new String(apellidoChars).trim();

                //Recojo el número de departamento.
                int departamento = raf.readInt();

                //Recojo el salario.
                double sueldo = raf.readDouble();

                System.out.println("\nIdentificador: " + idRegistro + "\n" +
                        "Apellido: " + apellido + "\n" +
                        "Departamento: " + departamento + "\n" +
                        "Sueldo: " + sueldo + "\n");
            }

            raf.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
