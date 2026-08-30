import java.time.LocalDate;

public class Licencia {

    private final String numero;
    private final String fechaVencimiento;

    public Licencia(String numero, String fechaVencimiento) {
        this.numero = numero;
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getNumero() {
        return numero;
    }

    public String getFecha() {
        return fechaVencimiento;
    }

    public boolean vigencia() {
        LocalDate fecha = LocalDate.parse(fechaVencimiento);
        return !fecha.isBefore(LocalDate.now());
    }
}
