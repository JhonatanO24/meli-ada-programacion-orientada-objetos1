package clase1_introduccion;

public class GestionEmpleado {

    public static void main(String[] args) {
        System.out.println("------------------------------------------");
        System.out.println(" ---SISTEMA DE GESTIÓN DE EMPLEADOS---");
        System.out.println("-------------------------------------------\n");

        Empleado emp1 = new Empleado("Carla Gómez", 28, "Desarrolladora Frontend", 1500.0, 3);
        Empleado emp2 = new Empleado("Alejandro Pérez", 35, "Arquitecto de Software", 3200.0, 6);
        Empleado emp3 = new Empleado("Sofía Rodríguez", 24, "Analista de Datos", 1200.0, 1);

        System.out.println("📌 Fichas iniciales registradas:\n");
        emp1.mostrarFicha();
        emp2.mostrarFicha();
        emp3.mostrarFicha();

        System.out.println("⏳ [Simulación del tiempo]: ¡Carla Gómez ha cumplido 2 años en la empresa!\n");
        emp1.cumplirAnio();
        emp1.cumplirAnio();

        System.out.println("----------------------------------------");
        System.out.println(" ---FICHAS FINALES TRAS ACTUALIZACIÓN--- ");
        System.out.println("----------------------------------------");

        emp1.mostrarFicha();
        emp2.mostrarFicha();
        emp3.mostrarFicha();

        System.out.println("✅ ¡Proceso de empleados finalizado con éxito!");
    }
}

class Empleado {
    private String nombre;
    private int edad;
    private String cargo;
    private double salario;
    private int antiguedad;

    public Empleado(String nombre, int edad, String cargo, double salario, int antiguedad) {
        this.nombre = nombre;
        this.edad = edad;
        this.cargo = cargo;
        this.salario = salario;
        this.antiguedad = antiguedad;
    }

    public double calcularBono() {
        if (this.antiguedad >= 5) {
            return this.salario * 0.20;
        } else {
            return this.salario * 0.10;
        }
    }

    public void cumplirAnio() {
        this.edad += 1;
        this.antiguedad += 1;
        this.salario += (this.salario * 0.03);
    }

    public void mostrarFicha() {
        System.out.println("👤 ----------------------------------------");
        System.out.println("Nombre     : " + nombre);
        System.out.println("Cargo      : " + cargo);
        System.out.println("Edad       : " + edad + " años");
        System.out.println("Antigüedad : " + antiguedad + " años");
        System.out.printf("Salario    : $%.2f USD\n", salario);
        System.out.printf("Bono calc. : $%.2f USD\n", calcularBono());
        System.out.println("👤 ----------------------------------------\n");
    }
}
