public class Moto extends Vehiculo {

    private double cilindraje;

    public Moto(String placa, String marca, String modelo, double tarifaDia,
                double cilindraje) {
        super(placa, marca, modelo, tarifaDia);
        this.cilindraje = cilindraje;
    }

    @Override
    public double calcularDanos(double monto) {
        return monto * 1.10;
    }

    @Override
    public String toString() {
        return "Moto{placa=" + placa
                + ", marca=" + marca
                + ", modelo=" + modelo
                + ", cilindraje=" + cilindraje
                + ", tarifaDia=" + tarifaDia
                + ", estado=" + estadoVehiculo + "}";
    }
}
