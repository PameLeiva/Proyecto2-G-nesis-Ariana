package datos;

import java.util.ArrayList;
import java.time.LocalDate;
import lógica.PagosMensuales;

/**
 * @author Génesis Leiva
 * @author Ariana Araya
 */
public class AlmacenamientoPagosMensuales {
    
    private ArrayList<PagosMensuales> listaPagosMensuales;
    private int consecutivoId;
    
    public AlmacenamientoPagosMensuales() {
        this.listaPagosMensuales = new ArrayList<>();
        this.consecutivoId = 1;
    }
    
    public ArrayList<PagosMensuales> getListaPagosMensuales() {
        return listaPagosMensuales;
    }
    
    public void setListaPagosMensuales(ArrayList<PagosMensuales> listaPagosMensuales) {
        this.listaPagosMensuales = listaPagosMensuales;
        // Actualizar el consecutivo basándose en los datos existentes
        actualizarConsecutivo();
    }
    
    private void actualizarConsecutivo() {
        int maxId = 0;
        for (PagosMensuales pago : listaPagosMensuales) {
            if (pago.getIdPago() > maxId) {
                maxId = pago.getIdPago();
            }
        }
        this.consecutivoId = maxId + 1;
    }
    
    public int getProximoId() {
        return consecutivoId;
    }
    
    // CRUD
    public void insertarPago(PagosMensuales pago) {
        if (pago != null) {
            pago.setIdPago(consecutivoId++);
            this.listaPagosMensuales.add(pago);
        }
    }
    
    public boolean eliminarPago(PagosMensuales pago) {
        if (this.listaPagosMensuales.contains(pago)) {
            this.listaPagosMensuales.remove(pago);
            return true;
        }
        return false;
    }
    
    public PagosMensuales buscarPorId(int id) {
        for (PagosMensuales pago : listaPagosMensuales) {
            if (pago.getIdPago() == id) {
                return pago;
            }
        }
        return null;
    }
    
    public ArrayList<PagosMensuales> obtenerPagosPorMesAnio(String mes, int anio) {
        ArrayList<PagosMensuales> pagosFiltrados = new ArrayList<>();
        for (PagosMensuales pago : listaPagosMensuales) {
            LocalDate fecha = pago.getFechaPago();
            if (pago.getMes().equalsIgnoreCase(mes) && fecha.getYear() == anio) {
                pagosFiltrados.add(pago);
            }
        }
        return pagosFiltrados;
    }
    
    public boolean existePlanilla(String mes, int anio) {
        for (PagosMensuales pago : listaPagosMensuales) {
            LocalDate fecha = pago.getFechaPago();
            if (pago.getMes().equalsIgnoreCase(mes) && fecha.getYear() == anio) {
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<PagosMensuales> obtenerPagosPorEstudiante(int cedula) {
        ArrayList<PagosMensuales> pagosEstudiante = new ArrayList<>();
        for (PagosMensuales pago : listaPagosMensuales) {
            if (pago.getEstudiante() == cedula) {
                pagosEstudiante.add(pago);
            }
        }
        return pagosEstudiante;
    }
    
    public double calcularTotalPlanilla(String mes, int anio) {
        double total = 0;
        ArrayList<PagosMensuales> pagos = obtenerPagosPorMesAnio(mes, anio);
        for (PagosMensuales pago : pagos) {
            total += pago.getPagoNeto();
        }
        return total;
    }
}