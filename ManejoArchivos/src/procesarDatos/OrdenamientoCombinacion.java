/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesarDatos;
import java.util.Random;

public class OrdenamientoCombinacion
{
   private int[] datos; // arreglo de valores

   // crea un arreglo de un tama�o dado y lo llena con enteros aleatorios
   public OrdenamientoCombinacion( int [] arreglo )
   {
      //inicializa los valores del arreglo
       datos = arreglo;
   } // fin del constructor de OrdenamientoCombinacion
   
   // llama al m�todo de divisi�n recursiva para comenzar el ordenamiento por combinaci�n
   public void ordenar()
   {
      ordenarArreglo( 0, datos.length - 1 ); // divide todo el arreglo
   } // fin del m�todo ordenar

   // divide el arreglo, ordena los subarreglos y los combina en un arreglo ordenado
   private void ordenarArreglo( int inferior, int superior ) 
   {
      // eval�a el caso base; el tama�o del arreglo es igual a 1
      if ( ( superior - inferior ) >= 1 ) // si no es el caso base
      {
         int medio1 = ( inferior + superior ) / 2; // calcula el elemento medio del arreglo
         int medio2 = medio1 + 1; // calcula el siguiente elemento arriba

         // imprime en pantalla el paso de divisi�n
         /*System.out.println( "division:   " + subarreglo( inferior, superior ) );
         System.out.println( "            " + subarreglo( inferior, medio1 ) );
         System.out.println( "            " + subarreglo( medio2, superior ) );
         System.out.println();*/

         // divide el arreglo a la mitad; ordena cada mitad (llamadas recursivas)
         ordenarArreglo( inferior, medio1 ); // primera mitad del arreglo
         ordenarArreglo( medio2, superior ); // segunda mitad del arreglo

         // combina dos arreglos ordenados despu�s de que regresan las llamadas de divisi�n
         combinar ( inferior, medio1, medio2, superior );
      } // fin de if
   } // fin del m�todo ordenarArreglo
   
   // combina dos subarreglos ordenados en un subarreglo ordenado
   private void combinar( int izquierdo, int medio1, int medio2, int derecho ) 
   {
      int indiceIzq = izquierdo; // �ndice en subarreglo izquierdo
      int indiceDer = medio2; // �ndice en subarreglo derecho
      int indiceCombinado = izquierdo; // �ndice en arreglo de trabajo temporal
      int[] combinado = new int[ datos.length ]; // arreglo de trabajo

      // imprime en pantalla los dos subarreglos antes de combinarlos
      /*System.out.println( "combinacion:" + subarreglo( izquierdo, medio1 ) );
      System.out.println( "            " + subarreglo( medio2, derecho ) );*/
      
      // combina los arreglos hasta llegar al final de uno de ellos
      while ( indiceIzq <= medio1 && indiceDer <= derecho )
      {
         // coloca el menor de dos elementos actuales en el resultado
         // y lo mueve al siguiente espacio en los arreglos
         if ( datos[ indiceIzq ] <= datos[ indiceDer ] )
            combinado[ indiceCombinado++ ] = datos[ indiceIzq++ ]; 
         else 
            combinado[ indiceCombinado++ ] = datos[ indiceDer++ ];
      } // fin de while
   
      // si el arreglo izquierdo est� vac�o
      if ( indiceIzq == medio2 )
         // copia el resto del arreglo derecho
         while ( indiceDer <= derecho )
            combinado[ indiceCombinado++ ] = datos[ indiceDer++ ];
      else // el arreglo derecho est� vac�o
         // copia el resto del arreglo izquierdo
         while ( indiceIzq <= medio1 ) 
            combinado[ indiceCombinado++ ] = datos[ indiceIzq++ ];      

      // copia los valores de vuelta al arreglo original
      for ( int i = izquierdo; i <= derecho; i++ )
         datos[ i ] = combinado[ i ];

      // imprime en pantalla el arreglo combinado
      //System.out.println( "            " + subarreglo( izquierdo, derecho ) );
      //System.out.println();
   } // fin del m�todo combinar

   // m�todo para imprimir en pantalla ciertos valores en el arreglo
   public String subarreglo( int inferior, int superior )
   {
      StringBuilder temporal = new StringBuilder();

      // imprime en pantalla espacios para la alineaci�n
      for ( int i = 0; i < inferior; i++ )
         temporal.append( "   " );

      // imprime en pantalla el resto de los elementos en el arreglo
      for ( int i = inferior; i <= superior; i++ )
         temporal.append( " " + datos[ i ] );

      return temporal.toString();
   } // fin del m�todo subarreglo
   
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

   // m�todo para imprimir los valores en el arreglo
   public String toString(){
      return subarreglo( 0, datos.length - 1 );
   } // fin del m�todo toString 
} // fin de la clase OrdenamientoCombinacion