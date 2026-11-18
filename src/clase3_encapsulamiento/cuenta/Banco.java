package clase3_encapsulamiento.cuenta;

public class Banco {
    public static void main(String[] args) {
        System.out.println("--------------------------------------------");
        System.out.println("  SISTEMA BANCARIO PROTEGIDO-");
        System.out.println("------------------------------------------\n");

        CuentaBancaria cuenta1 = new CuentaBancaria("ACR-1001", "Carla Gómez");
        CuentaBancaria cuenta2 = new CuentaBancaria("ACR-1002", "Alejandro Perez");

        System.out.println("📌 Estado inicial de las cuentas:");
        cuenta1.mostrarInfo();
        cuenta2.mostrarInfo();

        // Probando DEPÓSITOS
        System.out.println("\n--- Depositando $500 a Carla (cuenta1) ---");
        boolean dep1 = cuenta1.depositar(500.0);
        System.out.println(dep1 ? "✅ Depósito exitoso" : "❌ Depósito fallido");
        cuenta1.mostrarInfo();

        System.out.println("\n--- Intentando retirar $600 de Carla (saldo insuficiente) ---");
        boolean ret1 = cuenta1.retirar(600.0);
        System.out.println(ret1 ? "✅ Retiro exitoso" : "❌ Retiro rechazado: Fondos insuficientes (sin sobregiros).");

        System.out.println("\n--- Retirando $200 de Carla correctamente ---");
        cuenta1.retirar(200.0);
        cuenta1.mostrarInfo();

        System.out.println("\n--- Transfiriendo $150 de Carla (cuenta1) a Alejandro (cuenta2) ---");
        boolean trans = cuenta1.transferir(cuenta2, 150.0);

        if (trans) {
            System.out.println("✅ ¡Transferencia atómica realizada con éxito!");
        } else {
            System.out.println("❌ Transferencia fallida.");
        }

        System.out.println("\n📊 Estados finales tras la transferencia:");
        cuenta1.mostrarInfo();
        cuenta2.mostrarInfo();

        System.out.println("\n✅ ¡Simulación bancaria finalizada con éxito!");
    }
}
