package Pedido;
import Cliente.Cliente;
import Productos.Producto;
import java.util.ArrayList;

public class Pedido {

    private int nropedido;
    private Cliente cli = new Cliente("", 0,"");
    private ArrayList<Producto> listaProductosPedido = new ArrayList<>();
    private static int contpedidos;

    public Pedido(Cliente cli)
    {
        this.cli.setNombre(cli.getNombre());
        this.cli.setDni(cli.getDni());
        this.cli.setEmail(cli.getEmail());
        
        contpedidos++;
        this.nropedido = 10*contpedidos;
    }

    public void agregarProducto(Producto P)
    {
        listaProductosPedido.add(P);
    }


    public int getnroPedido()
    {
        return nropedido;
    }

    public double calcularTotal()
    {
        double total=0;
        for(Producto P : listaProductosPedido)
        {
            total+=P.getPrecio()*P.getStock();
        }

        return total;
    }

    public String toString(int ind)
    {
        double total = calcularTotal();
        return "(IND "+ind+")"+" CLIENTE: \n\t NOMBRE: " + this.cli.getNombre() + "\n\t DNI: " + this.cli.getDni() + "\n\t EMAIL: " + this.cli.getEmail() + "\n\t TOTAL: $" + total + "\n";
    }

    public ArrayList<Producto> getlistaProductosPedido()
    {
        return listaProductosPedido;
    }

    public Cliente getCliente(){
        return cli;
    }
}
