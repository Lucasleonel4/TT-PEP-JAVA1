package Menu.Operaciones;

import java.util.InputMismatchException; // La excepción InputMismatchException se produce cuando los datos introducidos por un Scanner no coinciden con el tipo esperado por el programa.
import java.util.ArrayList;

import Productos.Producto;
import Productos.Bebida;
import Productos.Comida;
import Menu.Menu;
import Excepciones.Entrada;


public class AgregarProducto {
    private static int menuAgregarProducto()
    {
        int oppAgg;
        System.out.print("\n\t\t 1) Agregar un producto general.");
        System.out.print("\n\t\t 2) Agregar una bebida.");
        System.out.print("\n\t\t 3) Agregar una comida.");
        
        do
        {
            while(true)
            {
                try {
                    System.out.print("\n\t\t\t Elija la operacion a realizar: ");
                    oppAgg=Entrada.ES.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.print("\t\t\t\t ERROR: Tipee un numero entero.");
                    Entrada.ES.next();
                }
            }
        }while(oppAgg<1 || oppAgg>3);
        return oppAgg;
    }
    
    public static void agregarProducto(ArrayList<Producto> listaProducto)
    {
        int operAgg = menuAgregarProducto();
        int vencimiento;

        Producto P = new Producto("",0,0);
        Menu.auxiliarProductos(P);

        switch (operAgg) {
            case 1:
                listaProducto.add(P);
                break;
                
            case 2:
                double volumen;
                Bebida B = new Bebida(P.getNombre(), P.getPrecio(), P.getStock(), 0, 0);
                    do {
                        while (true) 
                        {
                            try {
                                System.out.print("\t\t\t Ingrese el volumen en litros del producto: ");
                                volumen = Entrada.ES.nextDouble();
                                break;
                            } catch (InputMismatchException e) {
                                System.out.print("\t\t\t\t ERROR: Ingresar un numero flotante.");
                                Entrada.ES.next();
                            }
                        }
                    } while (volumen<0);
                    B.setVolumenLitros(volumen);

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
                    B.setfechaVencimiento(vencimiento);
                    listaProducto.add(B);
                break;

            case 3:
                Comida C = new Comida(P.getNombre(), P.getPrecio(), P.getStock(),0);

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
                    C.setfechaVencimiento(vencimiento);
                    listaProducto.add(C);
                break;
        }
    }

}
