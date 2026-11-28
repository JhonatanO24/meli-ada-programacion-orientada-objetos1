package ExamenPOO_Osorio_Jhonatan.ejercicio3;

import java.util.ArrayList;

public class MainArena {
    public static void main(String[] args) {
        System.out.println("⚔️ --- PRUEBAS PREVIAS ---");
        Guerrero prueba = new Guerrero("Prueba");
        System.out.println(prueba);
        System.out.println("Danio real al recibir 30: " + prueba.recibirDanio(30));
        System.out.println(prueba);
        prueba.curar();
        System.out.println("Tras curar(): " + prueba);
        prueba.curar(100);
        System.out.println("Tras curar(100): " + prueba);

        ArrayList<Personaje> todos = new ArrayList<>();
        todos.add(new Guerrero("Tupac", 60, 14, 5, 2));
        todos.add(new Mago("Amaru", 40, 9, 2, 40));
        todos.add(new Arquero("Kusi", 45, 11, 3));
        todos.add(new Guerrero("Yaku"));
        todos.add(new Arquero("Killa", 40, 13, 2));
        todos.add(new Mago("Wara"));

        Arena arena = new Arena("Andes", "Llanos");
        for (int i = 0; i < todos.size(); i++) {
            if (i < 3) {
                arena.agregar(todos.get(i), "Andes");
            } else {
                arena.agregar(todos.get(i), "Llanos");
            }
        }

        System.out.println();
        System.out.println("--- EQUIPOS ---");
        arena.mostrarEquipos();

        System.out.println();
        System.out.println("🔥 --- COMBATE ---");
        String ganador = arena.combatir(10);

        System.out.println();
        System.out.println("🏆 Ganador: " + ganador);

        System.out.println();
        System.out.println("--- ESTADO FINAL ---");
        arena.mostrarEquipos();
    }
}
