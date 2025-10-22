[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/odPK0BTA)

Acceso a Datos Azterketa 1.Eb

# Manejo de Ficheros

File f = new File(args[0])

* f.exists();
* f.getName(); -> devuelve el nombre del fichero.
* f.getPath(); -> devuelve la ruta relativa del fichero
* f.length(); -> devuelve el tamaño en bytes.
* f.isFile();
* f.isDirectory;
* f.list(); -> hace un listado de ficheros y directorios dentro de la ruta señalada.
* etc.
---
## Flujos o Streams

* Reader / Writer : escriben y leen caracteres.
* Input y Output Streams : escriben y leen bytes.
  ##FileWriter
* File fichero = new Flie(“FicheroDeTexto.txt”);
* FileWriter fw = new FileWriter(fichero , false)
* Indíco el fichero que deseo manipular y una condición para indicar si quiero que se añada contenido a lo anterior o
  directamente lo sobreescriba.
* char[] texto = string.toCharArray();
* fw.writte( texto )
* for ( int i = 0; i < string.length(); i++){ fw.write( string.charAt( i ) ); }
* fw.write( string )
* fw.close( ) <- importante cerrar el flujo de escritura.
---
## BufferedWriter

* Sirve para escribir ficheros línea por línea.
* FileWriter fw = new FileWriter( fichero, false )
* BufferedWriter bw = new BufferedWriter( fw );
* for ( int = 1; i < 20; i++) { bw.write( “Fila número” + i ); bw.newLine( );}; <- escribe 20 líneas con el texto: Fila
  número x.
---
## FileReader

* File fichero = new File( “./usr/fichero.txt” );
* FileReader fr = new FileReader( fichero );
* while ( ( int i = fr.read( ) ) != 1) { System.out.print( ( char ) i ); }
* fr.close( ) <- importante cerrar el flujo de lectura.
* fr.read ( char[ ] bfr = new char[ 50 ], 5, 20) -> escribir un buffer de 50 carácteres cada vez, personalizado a un
  rango de 5 a 20.
---
## BufferedReader

* Sirve para leer ficheros línea por línea.
* File fichero = new File( “./usr/fichero.txt” );
* BufferedReader br = new BufferedReader( new FileReader( fichero ));
* while ( ( String l = br.readLine( ) ) != null ){ System.out.println( l ) };
---
## FileOutputStream y FileInputStream (2 en 1)

* File fichero = new File( “FichBytes.dat” ); <- se va a crear un flujo de entrada y salida sobre estre fichero.
* FileOutputStream fos = new FileOutputStream( fichero );
* for ( int i = 1; i < 100; i++) { fos.write( i ) }
* fos.close( ) <- importante cerrar el flujo de escritura.
* FileInputStream fin = new FileInputStream( fichero );
* while ( ( int i = fin.read( ) ) != 1) { System.out.println( i ); };
* fin.close( ) <- importante cerrar el flujo de lectura.
---
## FileOutputStream y DataOutputStream

* FileOutputStream fos = new FileOutputStream( new File( fichero ) );
* DataOutputStream dos = new DataOutputStream( fos ); <- es una clase para leer datos de tipo primarios (readBoolean(),
  readByte(), readInt(), readUTF() ).
* String[] nombres = { "Ana”, “Luis Miguel” };
* int[] edades = { 12, 19 };
* for ( int i = 0; i < edades.length; i++ ) { dos.writeUTF( nombres[ i ] ); dos.writeInt( edades[ i ]); };
* dos.close( ) <- importante cerrar el flujo de salida.
* fos.close( )
---
## FileInputStream y DataInputStream

* FileInputStream fis = new FileInputStream( new File( fichero ) );
* DataInputStream dis = new DataInputStream( fis ); <- es una clase para escribir datos de tipo primarios (
  readBoolean(), readByte(), readInt(), readUTF() ).
* while( dis.availble() > 0 ) { String nombre = dis.readUTF( ); int edad = dis.readInt( ); System.out.println( “Sujeto
  número ” + nombre + edad ); };
---
## FileOutputStream y ObjectOutputStream

* FileOutputStream fos = new FileOutputStream( new File( fichero ) );
* ObjectOutputStream oos = new ObjectOutputStream( fos );
* Persona persona1 = new Persona( “Ana”, 17 );
* Persona persona2 = new Persona( “Jose”, 25 );
* oos.writeObject( persona1 );
* oos.writeObject( persona2 );
* oos.close( );
* fos.close( );
---
## FileInputStream y ObjectInputStream

* FileInputStream fis = new FileInputStream( new File( fichero ) );
* ObjectInputStream ois = new ObjectInputStream( fis );
* while( true ) { Persona p = (Persona) ois.readObject( ); personas.add( p ); }; <- al parecer hay que crear un búcle
  infinito.
* ois.close( );
---
## RandomAccessFile write

* RandomAccessFile raf = new RandomAccessFile( fichero, “rw” ); -> hay que poner el fichero y el modo de acceso que
  puede ser sólo lectura ( r ) o escritura/lectura ( rw ).
* raf.getFilePointer( ); -> decuelve un valor numérico indicando la posición del cursor en ese momento.
* raf.writeInt( );
* raf.writeChars( );
* raf.seek( ); <- posiciona el cursor. Por ejemplo, si estas recorriendo un bucle porque se quieren escribir multitud de
  registros, la fórmula sería la siguiente: ( número del registro actual ( registro 18 ) * cantidad de bytes que ocupa
  un registro ( 36 bytes por registro ) )  + el offset requerido ( para el campo x se necesita avanzar 24 bytes ): (
  18 * 36 ) + 24 = 672 y escribimos a partir de ahí.
* raf.close( ); <- importante cerrar el flujo.
---
## RandomAccessFile read

* RandomAccessFile raf = new RandomAccessFile( fichero, “rw” );
* long numeroRegistrosToral = ( raf.length( ) / totalBytesRegistro ); <- es necesario saber cuántos registros hay para
  leerlos en un bucle.
* for ( int i = 0; i < numeroRegistrosTotal; i++ ) { raf.seek( ( long) i * tatalBytesRegistro ); } <- antes de empezar a
  leer un registro hay que situar el cursor delante.
* raf.readInt( );
* for( int j = 0; j < stringChars.length; j++) { stringChars[ j ] ‎ = raf.readChar( ); }; <- para leer strings o frases
  hay que construir un array de caracteres e ir llenandolo.
* String apellido = new String( string ).trim( ); <- haciendo un trim se omiten los carácteres que faltan por rellenar
  en el array.
* raf.readDouble( );
* raf.close( );
