package Menu.Operaciones;
import Productos.Producto;
import Productos.Comida;
import Productos.Bebida;

import java.util.ArrayList;

public class ListaProductos {
    
    public static void listarProductos(ArrayList<Producto> listaProducto)
    {
        int cont=0;
        
        for(Producto P : listaProducto)
        {
            cont++;
            System.out.println(P.toString(cont));
            if(P instanceof Comida) //si P es una instancia de Comida (subclase de Producto) cumple la condicion
            {
                //Comida C = (Comida) P; //casteo de P (superclase producto) a la subclase Comida, para acceder a sus atributos de la subclase.
                System.out.print("\t  Fecha de Vencimiento: " + ((Comida) P).getfechaVencimiento()); //casteo dentro de SOUT se castea el tipo de dato P (Producto) a "Comida"
                System.out.println("");
            }

            if(P instanceof Bebida) //si P es una instancia de Bebida (subclase de Producto) cumple la condicion
            {
                System.out.print("\t  Volumen en Litros: " + ((Bebida) P).getvolumenLitros()); //casteo dentro de SOUT se castea el tipo de dato P (Producto) a "Bebida"
                System.out.print("\n\t  Fecha de Vencimiento: " + ((Bebida) P).getfechaVencimiento()); //casteo dentro de SOUT se castea el tipo de dato P (Producto) a "Bebida"
                System.out.println("");

            }
        }
        System.out.println("");
    }

}
