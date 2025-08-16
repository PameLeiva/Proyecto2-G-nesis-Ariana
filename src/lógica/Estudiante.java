
package lógica;

import java.time.LocalDate;

/**
 *
 * @author Génesis Leiva
 * @author Ariana Araya
 */
public class Estudiante extends Persona{
    private int carnet;
    private LocalDate fechaIngreso;
    private LocalDate fechaEgreso;
    private int carrera;

    public Estudiante() {
        super();
        this.carnet = 0;
        this.fechaIngreso = null;  
        this.fechaEgreso = null;
        this.carrera = 0;
    }
    
    public Estudiante(int carnet, LocalDate fechaIngreso, LocalDate fechaEgreso, int carrera, int ced, String nom, LocalDate fechNac, String direccion, String telefono, String email) {
        super(ced, nom, fechNac, direccion, telefono, email);
        this.carnet = carnet;
        this.fechaIngreso = fechaIngreso;
        this.fechaEgreso = fechaEgreso;
        this.carrera = carrera;
    }

    public int getCarnet() {
        return carnet;
    }

    public void setCarnet(int carnet) {
        this.carnet = carnet;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDate getFechaEgreso() {
        return fechaEgreso;
    }

    public void setFechaEgreso(LocalDate fechaEgreso) {
        this.fechaEgreso = fechaEgreso;
    }

    public int getCarrera() {
        return carrera;
    }

    public void setCarrera(int carrera) {
        this.carrera = carrera;
    }
    
}
