package Productos;

public class Bebida extends Producto{
    private double volumenLitros;
    private int fechaVencimiento;

    public Bebida(String nombre,double precio,int stock,double volumenLitros,int fechaVencimiento)
    {
        super(nombre,precio,stock);
        this.volumenLitros=volumenLitros;
        this.fechaVencimiento=fechaVencimiento;
    }

    public void setVolumenLitros(double volumen)
    {
        this.volumenLitros=volumen;
    }

    public double getvolumenLitros()
    {
        return this.volumenLitros;
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
