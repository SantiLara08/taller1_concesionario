public abstract class Vehiculo implements Verificable {

    protected final String placa;
    protected final String marca;
    protected final String modelo;
    private double tarifaDia;
    private Estado estadoVehiculo;

    public Vehiculo(String placa, String marca, String modelo, double tarifaDia) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.tarifaDia = tarifaDia;
        this.estadoVehiculo = Estado.DISPONIBLE;
    }

    public double calcularPago(int dias) {
        return tarifaDia * dias;
    }

    public double calcularPago(int dias, double descuento) {
        double total = tarifaDia * dias;
        return Calculos.calcularDescuento(total, descuento);
    }

    @Override
    public boolean estaHabilitado() {
        return estadoVehiculo == Estado.DISPONIBLE;
    }

    public void setEstado(Estado estadoVehiculo) {
        this.estadoVehiculo = estadoVehiculo;
    }

    public void setTarifa(double tarifaDia) {
        this.tarifaDia = tarifaDia;
    }

    public abstract double calcularDanos(double monto);
}