package examen_poo_jhonatan.ejercicio2_nomina;

public class Vendedor extends EmpleadoFijo{
    private double comision;

    public Vendedor(String nombre, double salarioMensual, double comision) {
        super(nombre, salarioMensual);
        this.comision = comision;
    }

    // Reutiliza super.salario() (el sueldo fijo del padre) y le suma la comision
    @Override
    public double salario() {
        return super.salario() * this.comision;
    }
}
