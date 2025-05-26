package Menu.Operaciones;

import Productos.Producto;
import Productos.Bebida;
import Productos.Comida;
import Menu.Menu;
import Excepciones.Entrada;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class BuscarActualizar {
    
    public static void buscarProducto(ArrayList<Producto> listaProducto)
    {
        String productoBuscar = new String();
        do
        {   
            System.out.print("\nIngrese el nombre del producto a buscar: ");
            Entrada.ES.nextLine();
            productoBuscar = Entrada.ES.nextLine();
        }while(productoBuscar==null || productoBuscar.trim().isEmpty());
        productoBuscar = productoBuscar.toUpperCase().trim();

        int cont = 0;
        int encontrado = 0;
        for(Producto P : listaProducto)
        {
            cont++;

            if(P.getNombre().equals(productoBuscar))
            {
                System.out.print("\tEl producto: "+ productoBuscar + ", ESTÁ EN EL CATÁLOGO\n");

                encontrado=1;
                int operacion = 0;

                    do
                    {
                            while(true)
                            {
                                try {
                                    System.out.println("\t\t0- No hacer nada.");
                                    System.out.println("\t\t1- Actualizar producto.");
                                    System.out.println("\t\t2- Eliminar producto.");
                                    System.out.print(("\t\t\t Indique lo que desea hacer: "));
                                    operacion = Entrada.ES.nextInt();
                                    break;
                                } catch (InputMismatchException e) {
                                    System.out.println("\t\t\t\t ERROR: Ingrese un tipo de dato entero.");
                                    Entrada.ES.next();
                                }
                            }
                    }while(operacion<0 || operacion>2);

            
                if(operacion==1)
                {
                    actualizarProducto(P);
                }

                if(operacion==2)
                {
                    System.out.println("\n\t\t SE VA A ELIMINAR EL PRODUCTO: ");
                    System.out.println("\n\t\t\t NOMBRE: " + P.getNombre() + "\n\t\t\t PRECIO: $" + P.getPrecio() + "\n\t\t\t STOCK: " + P.getStock());
                    
                    if(P instanceof Comida)
                    {
                        System.out.print("\t\t\t FECHA DE VENCIMIENTO: " + ((Comida) P).getfechaVencimiento() + "\n");
                    }

                    if(P instanceof Bebida)
                    {
                        System.out.print("\t\t\t VOLUMEN EN LITROS: " + ((Bebida) P).getvolumenLitros() +"L \n");
                        System.out.print("\t\t\t FECHA DE VENCIMIENTO: " + ((Bebida) P).getfechaVencimiento() + "\n");
                    }  

                    String confirmacion = new String ();

                    Entrada.ES.nextLine();
                     System.out.print("\n\t\t INGRESE LA PALABRA \"ELIMINAR\" PARA ELIMINAR EL PRODUCTO: ");
                     
                     confirmacion = Entrada.ES.nextLine();
                     confirmacion = confirmacion.trim().toUpperCase();

                     if(confirmacion.equals("ELIMINAR"))
                     {
                        listaProducto.remove(P);
                        System.out.print("\t\t\t PRODUCTO ELIMINADO\n");
                        break;
                     }else
                     {
                        System.out.print("\t\t\t PRODUCTO NO ELIMINADO\n");
                        break;
                    }

                }

                 //Entrada.ES.nextLine(); //no haria falta porque lo ultimo que se ingresa es un String y son los ingresos de enteros o flotantes los que guardan el salto de linea.
                break;                
            }

            if(cont==listaProducto.size() && encontrado==0)
            {
                System.out.println("\tEl producto: "+ productoBuscar + ", NO ESTÁ EN EL CATÁLOGO\n");
            }
        }
    }



    public static void actualizarProducto(Producto P)
    {
        System.out.print("\n\t SE VA A ACTUALIZAR: \n\t\t PRODUCTO NOMBRE: " + P.getNombre() + "\n\t\t PRECIO INICIAL: $" + P.getPrecio() + "\n\t\t STOCK INICIAL: " + P.getStock());
        if(P instanceof Comida)
        {
            System.out.print("\n\t\t FECHA DE VENCIMIENTO: " + ((Comida) P).getfechaVencimiento());
        }

        if(P instanceof Bebida)
        {
            System.out.print("\n\t\t VOLUMEN EN LITROS: " + ((Bebida) P).getvolumenLitros() +"L");
            System.out.print("\n\t\t FECHA DE VENCIMIENTO: " + ((Bebida) P).getfechaVencimiento());
        }

        System.out.print("\n\n\t INGRESE LOS NUEVOS VALORES");
        Menu.auxiliarProductos(P);
        int vencimiento = 0;
        double volumen = 0;

        if(P instanceof Comida)
        {
            do {
                while (true) 
                {
                    try {
                        System.out.print("\t\t\t Ingrese la fecha de vencimiento del producto: ");
                        vencimiento = Entrada.ES.nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.print("\t\t\t\t ERROR: Ingresar un numero entero.");
                        Entrada.ES.next();
                    }
                }
            } while (vencimiento<0);

            ((Comida) P).setfechaVencimiento(vencimiento);
        }


        if(P instanceof Bebida)
        {
            do {
                while (true) 
                {
                    try {
                        System.out.print("\t\t\t Ingrese el volumen en litros del producto: ");
                        volumen = Entrada.ES.nextDouble();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.print("\t\t\t\t ERROR: Ingresar un numero flotante.\n");
                        Entrada.ES.next();
                    }
                }
            } while (volumen<0);

            ((Bebida) P).setVolumenLitros(volumen);

            do {
                while (true) 
                {
                    try {
                        System.out.print("\t\t\t Ingrese la fecha de vencimiento del producto: ");
                        vencimiento = Entrada.ES.nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.print("\t\t\t\t ERROR: Ingresar un numero entero.");
                        Entrada.ES.next();
                    }
                }
            } while (vencimiento<0);

            ((Bebida) P).setfechaVencimiento(vencimiento);
        }
    }

}
