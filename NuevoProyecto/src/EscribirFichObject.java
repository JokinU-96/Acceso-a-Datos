import java.io.*;

public class EscribirFichObject {
    public static void main(String[] args) {
        File fichero = new File("FichPersona.dat");
        try {
            FileOutputStream fileout = new FileOutputStream(fichero);
            ObjectOutputStream objectOS = new ObjectOutputStream(fileout);

            //Datos
            String[] nombres = {"Ana","Luis Miguel","Alicia","Pedro","Manuel","Andrés",
                    "Julio","Antonio","María Jesús"};
            int[] edades = {14,15,13,15,16,12,16,14,13};

            System.out.print("Añade una persona en la posición que quieras:\nIndica la posición: ");
            int posicion = Integer.parseInt(System.console().readLine());

            for(int i = 0;i < edades.length + 1; i++){
                if(i == (posicion - 1)){
                    System.out.println("Escribe el nombre de una persona: ");
                    String nombre = System.console().readLine();
                    System.out.println("Escribe la edad de una persona: ");
                    int edad = Integer.parseInt(System.console().readLine());
                    objectOS.writeObject(new Persona(nombre,edad));
                    System.out.println("Nueva persona incluida en la posición 3.");
                } else if(i > (posicion - 1)){
                    objectOS.writeObject(new Persona(nombres[i-1],edades[i-1]));
                } else {
                    objectOS.writeObject(new Persona(nombres[i],edades[i]));
                }
            }

            objectOS.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try{
            FileInputStream filein = new FileInputStream(fichero);
            ObjectInputStream objectIS = new ObjectInputStream(filein);
            int i = 1;
            //Escritura
            while(true){
                try{
                    String p = objectIS.readObject().toString();

                    System.out.println("Posición: " + i );
                    i++;

                    System.out.println(p);
                } catch(EOFException e){
                    break;
                }
            }
        } catch (FileNotFoundException ex) {
            // Display message when FileNotFoundException occurs
            System.out.println("Cannot Open the Output File");
            return;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
