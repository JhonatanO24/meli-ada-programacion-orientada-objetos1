package clase4_herencia.nomina;

public class Empleado {
    // Atributos protectores para las clases hijas
    protected String nombre;
    protected double sueldoBase;

    // Constructor que recibe los dos datos
    public Empleado(String nombre, double sueldoBase) {
        this.nombre = nombre;
        this.sueldoBase = sueldoBase;
    }

    // Método
    public double calcularSueldo() {
        return this.sueldoBase;
    }

    // Primera versión de aumentarSueldo (por monto fijo de dinero)
    public void aumentarSueldo(double monto) {
        if (monto > 0) {
            this.sueldoBase += monto;
        }
    }

    // Segunda versión de aumentarSueldo (por porcentaje, usando booleano de apoyo)
    public void aumentarSueldo(double porcentaje, boolean esPorcentaje) {
        if (esPorcentaje && porcentaje > 0) {
            this.sueldoBase += this.sueldoBase * (porcentaje / 100.0);
        }
    }

    public void mostrarInfo() {
        System.out.println("----------------------------------------");
        System.out.println("👤 Empleado   : " + this.nombre);
        System.out.printf("💲 Sueldo Base: $%.2f USD\n", this.sueldoBase);
    }
}
