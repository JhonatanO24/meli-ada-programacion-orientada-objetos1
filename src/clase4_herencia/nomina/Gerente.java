package clase4_herencia.nomina;

public class Gerente extends Empleado {
    // Atributo propio del Gerente
    private double bono;

    // Constructor que usa super()
    public Gerente(String nombre, double sueldoBase, double bono) {
        super(nombre, sueldoBase);
        this.bono = bono;
    }

    // Sobrescribir (Override) calcularSueldo() sumando el bono
    @Override
    public double calcularSueldo() {
        return this.sueldoBase + this.bono;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.printf("🎁 Bono Gerencia: $%.2f USD\n", this.bono);
        System.out.printf("💲 Sueldo Total (Gerente): $%.2f USD\n", this.calcularSueldo());
        System.out.println("----------------------------------------");
    }
}
