public class Carro extends Vehiculo {

    private final int numeroPuertas;
    private String tipoTransmision;

    public Carro(String placa, String marca, String modelo, double tarifaDia, int numeroPuertas, String tipoTransmision) {
        super(placa, marca, modelo, tarifaDia);
        this.numeroPuertas = numeroPuertas;
        this.tipoTransmision = tipoTransmision;
    }

    @Override
    public double calcularDanos(double monto) {
        return monto * 1.20;
    }

    @Override
    public String toString() {
        return "Carro{placa=" + placa
                + ", marca=" + marca
                + ", modelo=" + modelo
                + ", numeroPuertas=" + numeroPuertas
                + ", tipoTransmision=" + tipoTransmision
                + ", tarifaDia=" + tarifaDia
                + ", estado=" + estadoVehiculo + "}";
    }
}
