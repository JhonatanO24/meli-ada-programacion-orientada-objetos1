package ExamenPOO_Osorio_Jhonatan.ejercicio3;

import java.util.ArrayList;

public class Arena {
    private String nombreA;
    private String nombreB;
    private ArrayList<Personaje> equipoA;
    private ArrayList<Personaje> equipoB;

    public Arena(String nombreA, String nombreB) {
        this.nombreA = nombreA;
        this.nombreB = nombreB;
        this.equipoA = new ArrayList<>();
        this.equipoB = new ArrayList<>();
    }

    public void agregar(Personaje p, String equipo) {
        if (p == null || equipo == null) {
            return;
        }
        if (equipo.equals(this.nombreA)) {
            this.equipoA.add(p);
        } else if (equipo.equals(this.nombreB)) {
            this.equipoB.add(p);
        }
    }

    public void mostrarEquipos() {
        imprimirEquipo(this.nombreA, this.equipoA);
        imprimirEquipo(this.nombreB, this.equipoB);
    }

    private void imprimirEquipo(String nombreEquipo, ArrayList<Personaje> integrantes) {
        System.out.println(nombreEquipo + ":");
        for (Personaje p : integrantes) {
            System.out.println("  " + p.toString());
        }
    }

    public String combatir(int maxRondas) {
        for (int ronda = 1; ronda <= maxRondas; ronda++) {
            System.out.println("--- Ronda " + ronda + " ---");

            if (!ejecutarTurno(this.equipoA, this.equipoB)) {
                return this.nombreA;
            }
            if (!ejecutarTurno(this.equipoB, this.equipoA)) {
                return this.nombreB;
            }
        }
        return "EMPATE";
    }

    // Devuelve false si el equipo defensor se queda sin integrantes vivos
    private boolean ejecutarTurno(ArrayList<Personaje> atacantes, ArrayList<Personaje> defensores) {
        for (Personaje atacante : atacantes) {
            if (!atacante.estaVivo()) {
                continue;
            }
            Personaje objetivo = primerVivo(defensores);
            if (objetivo == null) {
                return false;
            }
            int danio = atacante.atacar(objetivo);
            System.out.printf("%s (%s) -> %s: %d de danio [%d/%d]%n",
                    atacante.getNombre(),
                    atacante.getTipo(),
                    objetivo.getNombre(),
                    danio,
                    objetivo.getVida(),
                    objetivo.getVidaMaxima());
            if (!objetivo.estaVivo()) {
                System.out.println("   " + objetivo.getNombre() + " ha caido");
            }
        }
        return primerVivo(defensores) != null;
    }

    private Personaje primerVivo(ArrayList<Personaje> lista) {
        for (Personaje p : lista) {
            if (p.estaVivo()) {
                return p;
            }
        }
        return null;
    }
}
