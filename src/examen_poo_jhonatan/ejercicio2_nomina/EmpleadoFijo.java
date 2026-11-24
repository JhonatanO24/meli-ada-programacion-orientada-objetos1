package examen_poo_jhonatan.ejercicio2_nomina;

public class EmpleadoFijo  extends Empleado {
    private double salarioMensual;

    public EmpleadoFijo(String nombre, double salarioMensual) {
        super(nombre);
        this.salarioMensual = salarioMensual;
    }

    @Override
    public double salario() {
        return salarioMensual;
    }
}
