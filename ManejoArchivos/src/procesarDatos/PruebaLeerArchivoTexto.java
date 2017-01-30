package procesarDatos;

public class PruebaLeerArchivoTexto
{
   public static void main( String args[] )
   {
      double time_start;
      double time_end;
      int [] arreglo;
      LeerArchivoTexto aplicacion = new LeerArchivoTexto();
      aplicacion.abrirArchivo();
      arreglo = aplicacion.leer_informacion();
      aplicacion.cerrarArchivo();
      OrdenamientoCombinacion ordenamientos = new OrdenamientoCombinacion(arreglo);
      System.out.println("Datos Iniciales:");
      ordenamientos.imprimirArreglo();
      System.out.println("\n\n");
      time_start = System.currentTimeMillis();
      ordenamientos.ordenar();
      time_end = System.currentTimeMillis();
      System.out.println("Datos Ordenados:");
      ordenamientos.imprimirArreglo();
      System.out.println("");
      System.out.println("\nTiempo de ejecucion: "+ ( time_end - time_start ) +" millisegundos");
   } // fin de main
} // fin de la clase PruebaLeerArchivoTexto

