package Productos;

public class Comida extends Producto{
    private int fechaVencimiento;
    public Comida(String nombre,double precio,int stock,int fechaVencimiento)
    {
        super(nombre, precio, stock);
        this.fechaVencimiento=fechaVencimiento;
    }

    public void setfechaVencimiento(int fecha)
    {
        this.fechaVencimiento=fecha;
    }

    public int getfechaVencimiento()
    {
        return this.fechaVencimiento;
    }

}
