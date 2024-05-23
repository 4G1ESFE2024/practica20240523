import java.time.LocalDate;

public class Empleado {

    private String nombre;
    private double sueldo;
    private LocalDate fechaPago;
    
    public Empleado() {
    }

    public Empleado(String nombre, double sueldo, LocalDate fechaPago) {
        this.nombre = nombre;
        this.sueldo = sueldo;
        this.fechaPago = fechaPago;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

    
    
}
