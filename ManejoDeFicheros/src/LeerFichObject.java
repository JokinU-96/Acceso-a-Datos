import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LeerFichObject {

    public static void modificarListado(List<Persona> personas, File fichero) throws IOException {

        FileOutputStream fileout = new FileOutputStream(fichero);
        ObjectOutputStream objectOS = new ObjectOutputStream(fileout);

        System.out.print("Añade una persona en la posición que quieras.\nIndica la posición (1<" + personas.size() +"): ");
        int posicion = Integer.parseInt(System.console().readLine());

        for (int i = 0; i < personas.size() + 1; i++) {
            if (i == (posicion - 1)) {
                System.out.println("Escribe el nombre de una persona: ");
                String nombre = System.console().readLine();
                System.out.println("Escribe la edad de una persona: ");
                int edad = Integer.parseInt(System.console().readLine());
                objectOS.writeObject(new Persona(nombre, edad));
                System.out.println("Nueva persona incluida en la posición " + posicion + ".");
            } else if (i > (posicion - 1)) {
                objectOS.writeObject(personas.get(i - 1));
            } else {
                objectOS.writeObject(personas.get(i));
            }
        }

        objectOS.close();
    }

    private static List<Persona> mostrarListado(File fichero) {

        List<Persona> personas = new ArrayList<>();

        try {
            FileInputStream filein = new FileInputStream(fichero);
            ObjectInputStream objectIS = new ObjectInputStream(filein);

            int i = 1;
            //Escritura
            while (true) {
                try {
                    Persona p = (Persona) objectIS.readObject();

                    personas.add(p);

                    System.out.println("Posición: " + i);
                    i++;

                    System.out.println(p.toString());
                } catch (EOFException e) {
                    System.out.println("\nEOF\n");
                    return personas;
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {

        File fichero = new File("FichPersona.dat");

        List<Persona> personas = mostrarListado(fichero);

        System.out.println("\n¿Quieres modificar el listado y añadir una persona nueva? (y/n)");
        String respuesta = System.console().readLine();

        if (respuesta.equals("y")) {
            modificarListado(personas, fichero);
            mostrarListado(fichero);
        } else if (respuesta.equals("n")) {
            System.out.println("Gracias por todo, hasta la próxima.");
        } else {
            System.out.println("¿De qué vas?");
        }

    }
}
