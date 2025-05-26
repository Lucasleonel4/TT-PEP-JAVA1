package Principal;

import java.util.ArrayList;

import Menu.Menu;
import Productos.Producto;
import Pedido.Pedido;


public class Programa{
    public static void main(String[] args) {
        ArrayList<Producto> listaProductos = new ArrayList<>();
        ArrayList<Pedido> listaPedidos = new ArrayList<>();

        int option = 0;
            
        while(option!=6)
        {
            option = Menu.ejecutarMenu();
            if(option!=7)
            {
                Menu.ejecutarOperacion(option,listaProductos,listaPedidos);
            }
        }
    }
}