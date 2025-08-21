package datos;

import java.util.ArrayList;
import lógica.Carreras;

/**
 *
 * @author Génesis Leiva
 * @author Ariana Araya
 */
public class AlmacenamientoCarreras {

    private ArrayList<Carreras> listaCarreras;
    private int nextId;

    public AlmacenamientoCarreras() {
        this.listaCarreras = new ArrayList<>();
        this.nextId = 1;
    }

    public ArrayList<Carreras> getListaCarreras() {
        return listaCarreras;
    }

    public void setListaCarreras(ArrayList<Carreras> listaCarreras) {
        this.listaCarreras = listaCarreras;
    }

    // CRUD

    // Insertar carrera y asignar ID automáticamente
    public void insertarCarreras(Carreras carrera) {
        if (carrera != null) {
            carrera.setIdCarrera(nextId++); // 👈 asignamos ID único
            listaCarreras.add(carrera);
        }
    }

    // Editar carrera en posición i
    public void editarCarreras(int i, Carreras newCarrera) {
        if (i >= 0 && i <= listaCarreras.size() && newCarrera != null) {
            listaCarreras.set(i, newCarrera);
        }
    }

    // Eliminar carrera
    public boolean eliminarCarreras(Carreras carrera) {
        if (carrera != null) {
            return listaCarreras.remove(carrera); // elimina el objeto, no deja null
        }
        return false;
    }

    // Buscar por ID
    public Carreras buscarId(int id) {
        for (Carreras ca : listaCarreras) {
            if (ca != null && ca.getIdCarrera() == id) { // 👈 validación extra
                return ca;
            }
        }
        return null;
    }
}
