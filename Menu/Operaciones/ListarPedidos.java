package Menu.Operaciones;

import Excepciones.Entrada;
import Pedido.Pedido;

import java.util.InputMismatchException;

import Cliente.Cliente;

import java.util.ArrayList;


public class ListarPedidos{


    public static void operarPedidos(ArrayList<Pedido> listaPedido)
    {
        System.out.println("\n INFORMACION SOBRE PEDIDOS");
        int oper=0;

        do {
            while (true) 
            {
                try {
                    System.out.println("\t1) Ver resumen todos los pedidos: ");
                    System.out.println("\t2) Ver detalle un pedido");
                    System.out.print("\t\t Ingrese la operacion a realizar: ");
                    oper = Entrada.ES.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.print("\t\t\t ERROR : Ingresá un entero.\n");
                    Entrada.ES.next();
                }
            }
        } while (oper<1 || oper>2);

        if(listaPedido.size()>0)
        {
        
                switch (oper) {
                    case 1:
                        System.out.println("\nSE LISTARÁN " + listaPedido.size() + " PEDIDOS \n");
                        listarResumenPedidos(listaPedido);    
                        System.out.println("");    
                        break;
            
                    case 2:    
                        int indice = 0;
                        System.out.println("\nSE LISTARÁN " + listaPedido.size() + " PEDIDOS \n");
                        listarResumenPedidos(listaPedido);  

                        do {
                            while(true)
                            {
                                try {
                                    System.out.print("\t Ingrese el indice del pedido a ver en detalle: ");
                                    indice = Entrada.ES.nextInt();
                                    break;
                                } catch (Exception e) {
                                    System.out.println("\t ERROR : Ingresá un tipo de dato entero.");
                                    Entrada.ES.next();
                                }
                            }
                        } while (indice<1 || indice>listaPedido.size());

                        Pedido P = listaPedido.get(indice-1);
                        Cliente C = P.getCliente();
                        System.out.println("\n\n CLIENTE NOMBRE: " + C.getNombre() + ". DNI: " + C.getDni() + ". EMAIL: " + C.getEmail() + ". TOTAL: $" + P.calcularTotal());
                        System.out.println("\n DETALLE DE " + P.getlistaProductosPedido().size() + " PRODUCTOS PEDIDOS");
                        ListaProductos.listarProductos(P.getlistaProductosPedido());
                        break;
                }
        }else
        {
            System.out.print("\t ERROR : No existen pedidos.\n\n");
        }


    }

    static private void listarResumenPedidos(ArrayList<Pedido> listaPedido)
    {
        int indice=0;

        for(Pedido PD : listaPedido)
        {   indice++;
            System.out.println(PD.toString(indice));
        }
    }


}
