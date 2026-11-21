package clase4_herencia.nomina;

public class Vendedor extends Empleado {
    // Atributos propios del Vendedor
    private double ventasMes;
    private double comision; // Ej: 0.10 = 10%

    // Constructor que usa super() para heredar nombre y sueldoBase
    public Vendedor(String nombre, double sueldoBase, double ventasMes, double comision) {
        super(nombre, sueldoBase);
        this.ventasMes = ventasMes;
        this.comision = comision;
    }

    // Sobrescribir (Override) calcularSueldo() sumando comisiones por ventas
    @Override
    public double calcularSueldo() {
        return this.sueldoBase + (this.ventasMes * this.comision);
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.printf("Ventas Mes : $%.2f USD\n", this.ventasMes);
        System.out.printf("🏷️  Comisión   : %.0f%%\n", (this.comision * 100));
        System.out.printf("💲 Sueldo Total (Vendedor): $%.2f USD\n", this.calcularSueldo());
        System.out.println("----------------------------------------");
    }
}
