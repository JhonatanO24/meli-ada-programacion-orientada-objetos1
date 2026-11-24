package examen_poo_jhonatan.ejercicio2_nomina;

import java.util.ArrayList;
import java.util.List;

public class MainNomina {

    // Suma todos los salarios usando el polimorfismo puro (sin el instandeof ni condicionales por tipo)
    public static double pagarTotal(List<Empleado> lista) {
        if (lista == null) {
            return 0.0;
        }
        double total = 0.0;
        for (Empleado e :  lista) {
            if (e != null) {
                total += e.salario();
            }
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println("----------------------------------------");
        System.out.println("--- NÓMINA POLIMÓRFICA ---");
        System.out.println("--------------------------------------\n");

        // Programamos contra la interfaz List<Empleado> con distintos tipos mezclados
        List<Empleado> nomina = new ArrayList<>();
        nomina.add(new EmpleadoFijo("Laura", 2500.0));
        nomina.add(new EmpleadoPorHora("Mateo", 40, 25.0)); // 40 * 25 = 1000.0
        nomina.add(new Vendedor("Sofía", 2000.0, 650.0));    // 2000 + 650 = 2650.0

        for (Empleado e : nomina) {
            System.out.printf("👤 %-8s | 💵 Salario: $%.2f%n", e.getNombre(), e.salario());
        }

        System.out.printf("Total a pagar en nómina: $%.2f%n", pagarTotal(nomina));
    }
}
