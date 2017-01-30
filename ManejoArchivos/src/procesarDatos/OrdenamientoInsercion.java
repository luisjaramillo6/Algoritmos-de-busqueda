/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesarDatos;

/**
 *
 * @author reroes
 */
import java.util.Random;

public class OrdenamientoInsercion
{
   private int[] datos; // arreglo de valores

   // crea un arreglo de un tama�o dado y lo llena con enteros aleatorios
   public OrdenamientoInsercion( int [] arreglo)
   {
      datos = arreglo;
   } // fin del constructor de OrdenamientoInsercion

   // ordena el arreglo usando el ordenamiento por inserci�n
   public void sort()
   {
       
      int insercion; // variable temporal para contener el elemento a insertar

      // itera a trav�s de datos.length - 1 elementos
      for ( int siguiente = 1; siguiente < datos.length; siguiente++ )
      {
         // almacena el valor en el elemento actual
         insercion = datos[ siguiente ]; 

         // inicializa ubicaci�n para colocar el elemento
         int moverElemento = siguiente; 

         // busca un lugar para colocar el elemento actual
         while ( moverElemento > 0 && datos[ moverElemento - 1 ] > insercion )
         {
            // desplaza el elemento una posici�n a la derecha
            datos[ moverElemento ] = datos[ moverElemento - 1 ];
            moverElemento--;
         } // fin de while

         datos[ moverElemento ] = insercion; // coloca el elemento insertado
      } // fin de for
   } // fin del m�todo ordenar

   // imprime una pasada del algoritmo
   public void imprimirArreglo()
   {
      for ( int i = 0; i < datos.length; i++ ){
         System.out.print( datos[ i ] + ", " );
        if(i%15==0){
            System.out.println("");
        }
      }

      System.out.println( "\n" ); // agrega fin de l�nea
   } // fin del m�todo imprimirPasada

   // m�todo para mostrar los valores del arreglo en pantalla
   public String toString()
   {
      StringBuilder temporal = new StringBuilder();

      // itera a trav�s del arreglo
      for ( int elemento : datos )
         temporal.append( elemento + "  " );
     
      temporal.append( "\n" ); // agrega car�cter de fin de l�nea
      return temporal.toString();
   } // fin del m�todo toString
} // fin de la clase OrdenamientoInsercion

