package clase3_encapsulamiento.agenda;

public class MainAgenda {
    public static void main(String[] args) {
        System.out.println("📒 ------------------------------------ ");
        System.out.println("--- AGENDA ENCAPSULADA ---");
        System.out.println("--------------------------------------\n");

        // Creamos la agenda con capacidad inicial pequeñita para probar el redimensionamiento automático
        AgendaEncapsulada agenda = new AgendaEncapsulada(2);

        // Agregando contactos
        boolean a1 = agenda.agregar(new Contacto("Carlos Pérez", "carlos@meli.com", "300111"));
        boolean a2 = agenda.agregar(new Contacto("Carla Gómez", "carla@meli.com", "300222"));
        // Este tercero forzará a que se active el método privado redimensionar() porque la capacidad era 2
        boolean a3 = agenda.agregar(new Contacto("Alejandro Ruiz", "alejandro@meli.com", "300333"));

        System.out.println("¿Se agregó Carlos?: " + a1);
        System.out.println("¿Se agregó Carla?: " + a2);
        System.out.println("¿Se agregó Alejandro (con redimensión automática)?: " + a3);
        System.out.println("Total de contactos en la agenda: " + agenda.getCantidad() + "\n");

        // Probando la regla de duplicados (intentamos meter otro carlos@meli.com)
        boolean duplicado = agenda.agregar(new Contacto("Carlos Falso", "carlos@meli.com", "99999"));
        System.out.println("Intentando agregar email duplicado -> ¿Exitoso?: " + duplicado + " (Bloqueado correctamente 🛡️)\n");

        // Listando mediante copia defensiva
        System.out.println("📋 --- LISTADO GENERAL (Vía Copia Defensiva) ---");
        Contacto[] todos = agenda.listar();
        for (Contacto c : todos) {
            c.mostrarInfo();
        }

        // Probando filtro por nombre (ej: buscar los que empiezan por "Car")
        System.out.println("\n🔍 --- FILTRANDO POR NOMBRE (Prefijo: 'Car') ---");
        Contacto[] filtrados = agenda.filtrarPorNombre("Car");
        for (Contacto c : filtrados) {
            c.mostrarInfo();
        }

        // Probando eliminación
        System.out.println("\n🗑️ --- ELIMINANDO A 'carlos@meli.com' ---");
        boolean eliminado = agenda.eliminar("carlos@meli.com");
        System.out.println("¿Eliminación exitosa?: " + eliminado);
        System.out.println("Cantidad final de contactos: " + agenda.getCantidad());

        System.out.println("\n✅ ¡Prueba de agenda avanzada completada con éxito!");
    }
}
