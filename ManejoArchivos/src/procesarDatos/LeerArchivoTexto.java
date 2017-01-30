package procesarDatos;

// Ejemplo tomado del libro 
// D EITEL , P AUL J. Y H ARVEY M. D EITEL
// CÓMO PROGRAMAR EN J AVA . Séptima edición
// fines educativos
// Prueba de la clase ArchivoTexto.

// Este programa lee un archivo de texto y muestra cada registro.
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Arrays;

public class LeerArchivoTexto {

    private Scanner entrada;

    // permite al usuario abrir el archivo
    public void abrirArchivo() {
        try {
            entrada = new Scanner(new File("Archivos/Un_millon.txt"));
        } // fin de try
        catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error al abrir el archivo.");
            System.exit(1);
        } // fin de catch
    } // fin del método abrirArchivo

    // lee registro del archivo
    public int[] leer_informacion() {
        
        ArrayList<Integer> numeros = new ArrayList<>() ;
        try // lee registros del archivo, usando el objeto Scanner
        {
            while (entrada.hasNext()) {
                String linea = entrada.nextLine();
                numeros.add(Integer.parseInt(linea));
            } // fin de while
        } // fin de try
        catch (NoSuchElementException elementException) {
            System.err.println("El archivo no esta bien formado.");
            entrada.close();
            System.exit(1);
        } // fin de catch
        catch (IllegalStateException stateException) {
            System.err.println("Error al leer del archivo.");
            System.exit(1);
        } // fin de catch
        return arrayList_toArray(numeros);
    }
    
    public int[] arrayList_toArray(ArrayList<Integer> lista){
        int [] arreglo = new int[lista.size()];
        for (int i = 0; i < lista.size(); i++) {
           arreglo[i] = lista.get(i);
        }
        return arreglo;
    }

    public void cerrarArchivo() {
        if (entrada != null) {
            entrada.close(); // cierra el archivo
        }
    } // fin del metodo cerrarArchivo
} // fin de la clase LeerArchivoTexto

