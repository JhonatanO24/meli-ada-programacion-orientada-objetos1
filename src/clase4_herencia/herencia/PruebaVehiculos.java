package clase4_herencia.herencia;

public class PruebaVehiculos {
    public static void main(String[] args) {
        System.out.println("--------------------------------------");
        System.out.println("--- SISTEMA DE VEHÍCULOS ---");
        System.out.println("-----------------------------------\n");

        Auto miAuto = new Auto("Chevrolet", "Onix Turbo", 4);
        Moto miMoto = new Moto("Yamaha", "MT-03", 321);

        System.out.println("📌 Estado inicial de los vehículos:");
        miAuto.mostrarInfo();
        miMoto.mostrarInfo();

        System.out.println("\n--- Acelerando el auto y la moto ---");
        miAuto.acelerar(80);
        miMoto.acelerar(60);

        System.out.println("\nEstados de los vehiculos :D:");
        miAuto.mostrarInfo();
        miMoto.mostrarInfo();

        System.out.println("\n✅ ¡Simulación de vehículos con Auto y Moto finalizada!");
    }
}