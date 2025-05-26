package Menu.Operaciones;

import Productos.Producto;
import Productos.Comida;
import Productos.Bebida;
import Cliente.Cliente;

import Pedido.Pedido;
import Excepciones.StockInsuficienteExcepcion;
import Excepciones.Entrada;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class CrearPedido {

    public static void crearCliente(Cliente cli){
        String aux;
        int dni;
        do {
            System.out.print("\n Ingrese el nombre del cliente: ");
            Entrada.ES.nextLine();
            aux=Entrada.ES.nextLine();
        } while (aux==null || aux.trim().isEmpty());
        cli.setNombre(aux);

        do {
            while(true)
            {
                try {
                    System.out.print("\t Ingrese el DNI del cliente: ");
                    dni = Entrada.ES.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.print("\t\t ERROR: Ingresá un entero.\n");
                    Entrada.ES.next();
                }
            }
        } while (dni<0);

        Entrada.ES.nextLine(); //limpio buffer. newInt guarda salto de linea
        cli.setDni(dni);

        do {
            System.out.print("\t Ingrese el email del cliente: ");
            aux=Entrada.ES.nextLine();
        } while (aux==null || aux.trim().isEmpty());
        cli.setEmail(aux);
        System.out.println("");
    }

    private static void productosDisponibles(ArrayList<Producto> listaProductos)
    {
        ListaProductos.listarProductos(listaProductos);
    }

    public static void AgregarProductos(ArrayList<Producto> listaProductos, Pedido ped)
    {
        Producto ProdPedido;
        int indice=1, cantidad=0;

        while(indice!=0 && listaProductos.size()>0)
        {
            productosDisponibles(listaProductos);

                do {
                    while(true)
                    {
                            try {
                                System.out.print("\t Ingrese el indice del producto a agregar (o cero para terminar): ");
                                indice = Entrada.ES.nextInt();
                                break;
                            } catch (InputMismatchException e) {
                                System.out.print("\t\t ERROR: Ingrese un indice entero.\n");
                                Entrada.ES.next();
                            }
                    }
                } while (indice<0 || indice>listaProductos.size());

            if(indice!=0)
            {
                    ProdPedido = listaProductos.get(indice-1);
                    
                    while(true)
                    {
                        try {
                                do {
                                    while (true) {
                                        try {
                                                System.out.print("\t\t Ingrese la cantidad de producto a reservar: ");
                                                cantidad = Entrada.ES.nextInt();
                                                break;
                                        } catch (InputMismatchException e) {
                                                System.out.print("\t\t\t ERROR: Ingrese un tipo de dato entero.\n");
                                                Entrada.ES.next();
                                        }
                                    }
                                } while (cantidad<0);

                            ProdPedido.retirarStockPedido(cantidad);
                            break;
                        } catch (StockInsuficienteExcepcion e) {
                            System.err.println("\t\t\t ERROR: " + e.getMessage());
                        }
                    }

                    
                    if(ProdPedido instanceof Comida && cantidad>0)
                    {
                        Producto P = new Comida(ProdPedido.getNombre(),ProdPedido.getPrecio(),cantidad,((Comida) ProdPedido).getfechaVencimiento());
                        ped.agregarProducto(P);
                    }

                    if(ProdPedido instanceof Bebida && cantidad>0)
                    {
                        Producto P = new Bebida(ProdPedido.getNombre(),ProdPedido.getPrecio(),cantidad,((Bebida) ProdPedido).getvolumenLitros(),((Bebida) ProdPedido).getfechaVencimiento());
                        ped.agregarProducto(P);
                    }

                    if(cantidad>0 && !(ProdPedido instanceof Comida) && !(ProdPedido instanceof Bebida))
                    {
                        Producto P = new Producto(ProdPedido.getNombre(), ProdPedido.getPrecio(), cantidad);
                        ped.agregarProducto(P);
                    }

                
            }
            System.out.println("");
        }
    }
    
}
