package Excepciones;

public class StockInsuficienteExcepcion extends Exception{
    public StockInsuficienteExcepcion(String mensaje)
    {
        super(mensaje);
    }
}