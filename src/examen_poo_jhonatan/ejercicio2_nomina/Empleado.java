package examen_poo_jhonatan.ejercicio2_nomina;

public abstract class Empleado {
    // Atributo protegido para que las subclases accedan directamente el nombre si lo necesitan
    protected  String nombre;

    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    // Contrato polimorfico: cada subclase define como se calcula su salario
    public abstract double salario();
}
