package Cliente;

public class Cliente {
    private String nombre;
    private int dni;
    private String email;

    public Cliente(String nombre, int dni, String email)
    {
        this.nombre=nombre;
        this.dni=dni;
        this.email=email;
    }

    public void setNombre(String nombre)
    {
        this.nombre=nombre;
    }

    public String getNombre()
    {
        return nombre;
    }


    public void setDni(int dni)
    {
        this.dni = dni;
    }

    public int getDni()
    {
        return dni;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }
}

