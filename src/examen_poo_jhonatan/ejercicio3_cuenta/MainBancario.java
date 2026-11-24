package examen_poo_jhonatan.ejercicio3_cuenta;

public class MainBancario {
    public static void main(String[] args) {
        System.out.println("-------------------------------------------");
        System.out.println("--- CUENTA BANCARIA ---");
        System.out.println("-----------------------------------------\n");

        CuentaBancaria cuenta = new CuentaBancaria();

        // ✅ Caso feliz: depósito válido
        System.out.println("Depositar 200.0 -> " + cuenta.depositar(200.0)
                + " | Saldo: " + cuenta.getSaldo());

        // 🛑 Escenario que rompía el código original: depósito negativo o cero
        System.out.println("Depositar -50.0 -> " + cuenta.depositar(-50.0)
                + " | Saldo: " + cuenta.getSaldo());

        // 🛑 Escenario que rompía el código original: retiro mayor al saldo (sobregiro)
        System.out.println("Retirar 500.0 (sin fondos) -> " + cuenta.retirar(500.0)
                + " | Saldo: " + cuenta.getSaldo());

        // 🛑 Escenario que rompía el código original: retiro negativo
        System.out.println("Retirar -20.0 -> " + cuenta.retirar(-20.0)
                + " | Saldo: " + cuenta.getSaldo());

        // ✅ Caso feliz: retiro válido dentro del saldo disponible
        System.out.println("Retirar 75.0 -> " + cuenta.retirar(75.0)
                + " | Saldo final: " + cuenta.getSaldo());
    }
}