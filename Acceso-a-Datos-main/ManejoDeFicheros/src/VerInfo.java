import java.io.File;

public class VerInfo {
    public static void main(String[] args) {
        try{
            System.out.println("Acaba de ejecutar un programa que mostrará los datos del siguiente fichero: ");

            if(args.length == 1){
                File f = new File(args[0]);
                String nombre = f.getName();
                String ruta = f.getPath();
                String rutaAbsoluta = f.getAbsolutePath();
                double tamanyo = f.length();
                Boolean lectura = f.canRead();
                Boolean escritura = f.canWrite();
                Boolean directorio = f.isDirectory();
                Boolean fichero = f.isFile();

                String directorioMsg = null;
                String ficheroMsg = null;
                String tipo = null;


                if(directorio){
                    directorioMsg = "\nLa ruta es de un directorio.";
                    tipo = "directorio";
                }

                if(fichero){
                    ficheroMsg = "\nLa ruta es de un fichero.";
                    tipo = "fichero";
                }

                String mensaje = "El "+ tipo + " " + nombre + " tiene la ruta: " +
                        ruta + "\ny la ruta absoluta: \n" +
                        rutaAbsoluta+
                        "\nTamaño: " + tamanyo + "Bytes\n";

                if(directorioMsg != null){
                    mensaje = mensaje + directorioMsg;
                }
                if(ficheroMsg != null){
                    mensaje = mensaje + ficheroMsg;
                }

                if(lectura){
                    mensaje = mensaje + "\nEl " + tipo + " " + "se puede leer\n";
                } else{
                    mensaje = mensaje + "\nEl " + tipo + " NO se puede leer\n";
                }

                if(escritura){
                    mensaje = mensaje + "\nEl " + tipo + " se puede escribir\n";
                }else{
                    mensaje = mensaje + "\nEl " + tipo + " NO se puede escribir\n";
                }

                System.out.println(mensaje);
            }else if(args.length == 0){
                System.out.println("¡Pero pon algo POR FAVOR!");
            }else{
                System.out.println("Comprueba que la ruta especificada esté correctamente escrita (sin espacios y una única ruta a la vez).");
            };

        } catch (Exception e) {
            System.out.println("Error, comprueba la variable introducida.");
        }
    }
}
