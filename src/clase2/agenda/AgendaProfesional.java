package clase2.agenda;

import java.util.Scanner;

public class AgendaProfesional {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("📒 -----------------------------------------");
        System.out.println("---  SISTEMA DE AGENDA PROFESIONAL ---");
        System.out.println("-------------------------------------------\n");

        // Se inicializa la agenda con su capacidad fija (ej: 5 contactos)
        Agenda myAgenda = new Agenda(5);

        int opcion = 0;

        // Menu interactivo
        do {
            System.out.println("\n📌 ---------------- MENÚ PRINCIPAL ----------------");
            System.out.println("1️. Agregar Contacto");
            System.out.println("2️. Listar Todos los Contactos");
            System.out.println("3️. Listar Solo Favoritos (⭐)");
            System.out.println("4️. Buscar Contacto por Nombre");
            System.out.println("5️. Eliminar Contacto");
            System.out.println("6️. Ver Estadísticas (Contar Favoritos / Estado)");
            System.out.println("7️. Salir");
            System.out.print("👉 Selecciona una opción: ");

            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                sc.nextLine();
            } else {
                System.out.println("❌ ¡Por favor, ingresa un número válido!");
                sc.nextLine();
                continue;
            }

            System.out.println("--------------------------------------------------");

            switch (opcion) {
                case 1:
                    System.out.print("✍️ Ingresa el nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("@ Ingresa el email (debe tener '@'): ");
                    String email = sc.nextLine();
                    System.out.print("📞 Ingresa el teléfono: ");
                    String telefono = sc.nextLine();
                    System.out.print("⭐ ¿Es favorito? (true/false): ");
                    boolean esFavorito = sc.nextBoolean();
                    sc.nextLine();

                    Contacto nuevo = new Contacto(nombre, email, telefono, esFavorito);
                    boolean agregado = myAgenda.agregar(nuevo);

                    if (agregado) {
                        System.out.println("✅ ¡Contacto agregado exitosamente a Agenda!");
                    } else {
                        System.out.println("❌ Error: Agenda llena o email inválido (falta '@').");
                    }
                    break;

                case 2:
                    System.out.println("📋 Listado general de contactos:\n");
                    myAgenda.listar();
                    break;

                case 3:
                    System.out.println("⭐ Listado exclusivo de favoritos:\n");
                    myAgenda.listarFavoritos();
                    break;

                case 4:
                    System.out.print("🔍 Ingresa el nombre del contacto a buscar: ");
                    String buscado = sc.nextLine();
                    Contacto encontrado = myAgenda.buscar(buscado);
                    if (encontrado != null) {
                        System.out.println("🎉 ¡Contacto encontrado!");
                        encontrado.mostrarInfo();
                    } else {
                        System.out.println("❌ No se encontró ningún contacto con ese nombre.");
                    }
                    break;

                case 5:
                    System.out.print("🗑️ Ingresa el nombre del contacto a eliminar: ");
                    String aEliminar = sc.nextLine();
                    boolean eliminado = myAgenda.eliminar(aEliminar);
                    if (eliminado) {
                        System.out.println("✅ Contacto eliminado y array reorganizado correctamente.");
                    } else {
                        System.out.println("❌ No se pudo eliminar (contacto no encontrado).");
                    }
                    break;

                case 6:
                    System.out.println("--- ESTADÍSTICAS DE LA AGENDA ---");
                    System.out.println("⭐ Total de favoritos: " + myAgenda.contarFavoritos());
                    System.out.println("   ¿Está vacía?: " + (myAgenda.estaVacia() ? "Sí" : "No"));
                    System.out.println("   ¿Está llena?: " + (myAgenda.estaLlena() ? "Sí" : "No"));
                    break;

                case 7:
                    System.out.println("👋 ¡Gracias por usar la Agenda. ¡Hasta pronto!");
                    break;

                default:
                    System.out.println("⚠️ Opción inválida, intenta de nuevo.");
            }
        } while (opcion != 7);
        sc.close();
    }
}
