import java.util.Objects;

public class Cliente implements Verificable{
    private final String nombre;
    private String telefono;
    private final String documento;
    private int numero_alquileres;
    private Licencia licencia;

    public Cliente(String nombre, String telefono, String documento,Licencia licencia){
        this.nombre = nombre;
        this.telefono = telefono;
        this.documento = documento;
        this.licencia = licencia;
    }

    public Cliente(String nombre, String telefono, String documento){
        this(nombre,telefono,documento,null);
    }

    public String getNombre(){
        return nombre;
    }

    public void aumentarNumeroAlquileres(){
        numero_alquileres+=1;
    }

    public boolean esFrecuente(){
        int numero = 2; //Cantidad de alquileres para que se considere frecuente
        return numero_alquileres>=numero;
    }

    @Override
    public boolean estaHabilitado() {
        if(licencia == null){
            return false;
        }
        else if(licencia.vigencia()==true){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Cliente){
            Cliente otro = (Cliente) o;
            if(documento.equals(otro.documento)==true){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }

    @Override
    public int hashCode(){
        return Objects.hash(documento);
    }

}



