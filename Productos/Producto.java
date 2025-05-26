package Productos;
import Excepciones.StockInsuficienteExcepcion;

public class Producto {
    private String nombre;
    private double precio;
    private int stock;
    private int cantstockPedido;
    private int codigo;
    
    private static int cantgenerada = 0;

    public Producto(String nombre,double precio,int stock)
    {
        this.nombre=nombre;
        this.precio=precio;
        this.stock=stock;
        cantgenerada++;
        codigo=11*cantgenerada;
    }

    public void setNombre(String nombre)
    {
        this.nombre=nombre;
    }

    public String getNombre()
    {
        return this.nombre;
    }

    public void setPrecio(double precio)
    {
        this.precio=precio;
    }

    public double getPrecio()
    {
        return this.precio;
    }


    public void setStock(int stock)
    {
        this.stock=stock;
    }

    public int getStock()
    {
        return this.stock;
    }

    public void setCantidadPedido(int cantstockPedido)
    {
        this.cantstockPedido=cantstockPedido;
    }

    public int getCantidadPedido()
    {
        return cantstockPedido;
    }

    public int getCodigo()
    {
        return codigo;
    }

    public String toString(int cont)
    {
        return "\n (IND: " + cont + ")" + " Producto Nombre: " + this.nombre + "\n\t  Precio: $" + this.precio + "\n\t  Cantidad Stock: " + this.stock;
    }


    public void retirarStockPedido(int cantResevada) throws StockInsuficienteExcepcion{

        if(cantResevada > stock) 
        {
            throw new StockInsuficienteExcepcion("Cantidad de stock insuficiente para hacer el pedido");
        }
        stock -= cantResevada;
        cantstockPedido+=cantResevada;
    }
}
