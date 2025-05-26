package Menu;

import Productos.Producto;
import Menu.Operaciones.AgregarProducto;
import Menu.Operaciones.ListaProductos;
import Menu.Operaciones.BuscarActualizar;
import Menu.Operaciones.CrearPedido;
import Menu.Operaciones.ListarPedidos;

import Cliente.Cliente;
import Excepciones.Entrada;

import Pedido.Pedido;

import java.util.ArrayList;
import java.util.InputMismatchException; // La excepción InputMismatchException se produce cuando los datos introducidos por un Scanner no coinciden con el tipo esperado por el programa.

public class Menu {
    private static String[] opcionesMenu ={"1) Agregar producto","2) Listar productos","3) Buscar/Actualizar/Eliminar producto","4) Crear un pedido","5) Listar pedidos","6) Salir"};

    public static int ejecutarMenu()
    {
        int option=0;
        for(String opp : opcionesMenu)
        {
            System.out.println(opp);
        }

        do
        {
            while(true)
            {
                try{
                    System.out.print("\t Ingrese el código de operacion: ");
                    option = Entrada.ES.nextInt();
        
                    break; //sale del bucle si no entra la excepcion Catch.
                }catch(InputMismatchException e){
                    System.out.println("\t\tERROR: debe ingresar un número.");
                    Entrada.ES.next(); //limpia el buffer - Se va a repetir nuevamente por el while(true)
                }
            }
        }while(option<1 || option>6);
        return option;
    }

    public static void ejecutarOperacion(int opp, ArrayList<Producto> listaProducto, ArrayList<Pedido> listaPedido)
    {
        switch (opp) {
            case 1:
                AgregarProducto.agregarProducto(listaProducto);
                break;

            case 2:
                System.out.println("\n SE LISTARÁN " + listaProducto.size() + " PRODUCTOS");
                ListaProductos.listarProductos(listaProducto);
                break;

            case 3:
                BuscarActualizar.buscarProducto(listaProducto);
                break;
            
            case 4:

                Cliente cli = new Cliente("",0,"");
                CrearPedido.crearCliente(cli);
                Pedido ped = new Pedido(cli);

                if(cli.getDni()!=0)
                {
                    CrearPedido.AgregarProductos(listaProducto, ped);
                    listaPedido.add(ped);
                }else
                {
                    System.out.println("\t\t\t ERROR: INGRESÁ UN DNI VÁLIDO.\n");
                }

                break;

            case 5:
                ListarPedidos.operarPedidos(listaPedido);

            break;

            default:
                break;
        }
    }


    public static void auxiliarProductos(Producto P)
    {
        String nombre = new String();
        double precio;
        int stock;

        do {

            System.out.print("\n\t\t\t Ingrese el nombre del producto: ");
            Entrada.ES.nextLine(); //se limpia el buffer sino salta dos veces.
            nombre = Entrada.ES.nextLine();
        } while (nombre==null || nombre.trim().isEmpty());
        nombre = nombre.toUpperCase().trim();
        P.setNombre(nombre);

        do {
                while (true) 
                {
                    try {
                        System.out.print("\t\t\t Ingrese el precio del producto: $");
                        precio=Entrada.ES.nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("\t\t\t\tERROR: debe ingresar un numero flotante");
                        Entrada.ES.next();
                    }
                }
        } while (precio<0);
        P.setPrecio(precio);
 
        do {
                while(true)
                {
                    try {
                        System.out.print("\t\t\t Ingrese el stock del producto: ");
                        stock =Entrada.ES.nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("\t\t\t\tERROR: debe ingresar un numero entero");
                        Entrada.ES.next();
                    }
                }
            
        } while (stock<0);
        P.setStock(stock);
    }
}
