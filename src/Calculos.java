public class Calculos {

    private Calculos() {
    }

    public static double calcularDescuento(double monto, double porcentaje) {
        return monto - (monto * porcentaje);
    }
}
