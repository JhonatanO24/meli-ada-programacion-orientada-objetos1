package clase4_herencia.nomina;

public class PruebaNomina {
    public static void main(String[] args) {
        System.out.println("----------------------------------------");
        System.out.println("--- SISTEMA DE NÓMINA ---");
        System.out.println("--------------------------------------\n");

        // Vendedor y un Gerente
        Vendedor v1 = new Vendedor("Ana Torres", 1000.0, 5000.0, 0.10); // Sueldo base + 10% de 5000 en ventas
        Gerente g1 = new Gerente("Carlos Mendoza", 3000.0, 1200.0);   // Sueldo base + bono fijo de 1200

        System.out.println("📌 --- ESTADO INICIAL DE LA NÓMINA ---");
        v1.mostrarInfo();
        g1.mostrarInfo();

        // (Aumentar sueldo)
        System.out.println("\n--- Aplicando aumentos de sueldo (Sobrecarga) ---");
        v1.aumentarSueldo(200.0); // Usando la versión de monto fijo
        g1.aumentarSueldo(10.0, true); // Usando la versión de porcentaje

        System.out.println("\n --- ESTADOS FINALES TRAS EL AUMENTO ---");
        v1.mostrarInfo();
        g1.mostrarInfo();

        System.out.println("\n✅ ¡Desafío de nómina, herencia y sobrecarga finalizado con éxito!");
    }
}
