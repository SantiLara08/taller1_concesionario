public class Alquiler {
    private int dias_alquilado;
    private Vehiculo vehiculo_alquilado;
    private Cliente cliente_arrendador;
    private String fecha_inicio;
    private boolean activo;
    private static int total_alquileres;
    private double montoDanos;

    public Alquiler(int dias_alquilado, Vehiculo vehiculo_alquilado, Cliente cliente_arrendador, String fecha_inicio) {
        this.dias_alquilado = dias_alquilado;
        this.vehiculo_alquilado = vehiculo_alquilado;
        this.cliente_arrendador = cliente_arrendador;
        this.fecha_inicio = fecha_inicio;
        this.activo = true;
        this.montoDanos = 0;

        total_alquileres+=1;
        cliente_arrendador.aumentarNumeroAlquileres();
        vehiculo_alquilado.setEstado(Estado.ALQUILADO);
    }

    public void devolverVehiculo(double monto) throws AlquilerYaCerradoException{
        if(activo == false){
            throw new AlquilerYaCerradoException("El vehiculo ya habia sido devuelto");
        }
        else{
            activo = false;
            montoDanos = vehiculo_alquilado.calcularDanos(monto);
            vehiculo_alquilado.setEstado(Estado.DISPONIBLE);
        }
    }

    public static int getTotal_alquileres(){
        return total_alquileres;
    }

    public boolean getActivo(){
        return activo;
    }

    public Cliente getCliente_arrendador(){
        return cliente_arrendador;
    }


}
