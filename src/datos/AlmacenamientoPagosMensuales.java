package datos;

import java.util.ArrayList;
import java.time.LocalDate;
import lógica.Estudiante;
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

    public boolean puedeGenerarPlanilla(String mes, int anio) {
        // Verificar que no exista ya
        if (existePlanilla(mes, anio)) {
            return false;
        }

        // Verificar que no sea anterior al mes actual
        LocalDate fechaActual = LocalDate.now();
        int mesActual = fechaActual.getMonthValue();
        int anioActual = fechaActual.getYear();

        // Convertir nombre del mes a número
        int numeroMes = convertirMesANumero(mes);

        // No permitir meses anteriores al actual
        if (anio < anioActual || (anio == anioActual && numeroMes < mesActual)) {
            return false;
        }

        return true;
    }

    private int convertirMesANumero(String mes) {
        return switch (mes.toLowerCase()) {
            case "enero" ->
                1;
            case "febrero" ->
                2;
            case "marzo" ->
                3;
            case "abril" ->
                4;
            case "mayo" ->
                5;
            case "junio" ->
                6;
            case "julio" ->
                7;
            case "agosto" ->
                8;
            case "septiembre" ->
                9;
            case "octubre" ->
                10;
            case "noviembre" ->
                11;
            case "diciembre" ->
                12;
            default ->
                0;
        };
    }

    public ArrayList<PagosMensuales> generarPlanillaCompleta(String mes, int anio,
            AlmacenamientoEstudiante listaEstudiantes) {
        if (!puedeGenerarPlanilla(mes, anio)) {
            return new ArrayList<>();
        }

        ArrayList<PagosMensuales> pagosInsertados = new ArrayList<>();

        // Aquí generas los pagos directamente
        for (Estudiante est : listaEstudiantes.getListaEstudiantes()) {
            double totalBeneficios = est.getCarrera();
            double deducSeguro = totalBeneficios * 0.10;
            double deducRenta = totalBeneficios * 0.05;
            double pagoNeto = totalBeneficios - deducSeguro - deducRenta;
            PagosMensuales pago = new PagosMensuales(
                    consecutivoId++, // idPago
                    LocalDate.now(), // fechCreacion
                    mes, // mes
                    LocalDate.now(), // fechaPago
                    est.getCed(), // estudiante (solo cédula)
                    totalBeneficios, // totalBeneficios
                    deducSeguro, // deducSeguro
                    deducRenta, // deducRenta
                    pagoNeto // pagoNeto
            );

            this.listaPagosMensuales.add(pago);
            pagosInsertados.add(pago);
        }

        return pagosInsertados;
    }

    // CRUD
    public boolean insertarPago(PagosMensuales pago) {
        if (pago == null) {
            return false;
        }

        // Validar que no exista ya un pago para este estudiante en este mes/año
        if (existePagoEstudianteMes(pago.getEstudiante(), pago.getMes(), pago.getFechaPago().getYear())) {
            return false;
        }

        // Asignar ID si no tiene
        if (pago.getIdPago() <= 0) {
            pago.setIdPago(consecutivoId++);
        }

        this.listaPagosMensuales.add(pago);
        return true;
    }

    public boolean eliminarPago(PagosMensuales pago) {
        if (this.listaPagosMensuales.contains(pago)) {
            this.listaPagosMensuales.remove(pago);
            return true;
        }
        return false;
    }

    public boolean eliminarPlanillaCompleta(String mes, int anio) {
        ArrayList<PagosMensuales> pagosAEliminar = obtenerPagosPorMesAnio(mes, anio);
        boolean eliminado = false;

        for (PagosMensuales pago : pagosAEliminar) {
            if (listaPagosMensuales.remove(pago)) {
                eliminado = true;
            }
        }
        return eliminado;
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

    public ArrayList<PagosMensuales> filtrarPagos(boolean filtrarEstudiante, int cedula,
            boolean filtrarMes, String mes,
            boolean filtrarAnio, int anio) {
        ArrayList<PagosMensuales> pagosFiltrados = new ArrayList<>();

        for (PagosMensuales pago : listaPagosMensuales) {
            boolean cumpleFiltros = true;

            // Filtro por estudiante
            if (filtrarEstudiante && pago.getEstudiante() != cedula) {
                cumpleFiltros = false;
            }

            // Filtro por mes
            if (filtrarMes && !pago.getMes().equalsIgnoreCase(mes)) {
                cumpleFiltros = false;
            }

            // Filtro por año
            if (filtrarAnio && pago.getFechaPago().getYear() != anio) {
                cumpleFiltros = false;
            }

            if (cumpleFiltros) {
                pagosFiltrados.add(pago);
            }
        }

        return pagosFiltrados;
    }

    public ArrayList<PagosMensuales> obtenerPagosPorAniosUnicos() {
        ArrayList<PagosMensuales> pagosPorAño = new ArrayList<>();

        for (PagosMensuales pago : listaPagosMensuales) {
            int añoPago = pago.getFechaPago().getYear();

            // Verificar si ya tenemos un pago de este año
            boolean añoExiste = false;
            for (PagosMensuales pagoExistente : pagosPorAño) {
                if (pagoExistente.getFechaPago().getYear() == añoPago) {
                    añoExiste = true;
                    break;
                }
            }

            // Si no existe, agregar este pago como representativo del año
            if (!añoExiste) {
                pagosPorAño.add(pago);
            }
        }

        return pagosPorAño;
    }

    public ArrayList<PagosMensuales> obtenerPagosPorMesesUnicos() {
        ArrayList<PagosMensuales> pagosPorMes = new ArrayList<>();

        for (PagosMensuales pago : listaPagosMensuales) {
            String mesPago = pago.getMes();

            // Verificar si ya tenemos un pago de este mes
            boolean mesExiste = false;
            for (PagosMensuales pagoExistente : pagosPorMes) {
                if (pagoExistente.getMes().equalsIgnoreCase(mesPago)) {
                    mesExiste = true;
                    break;
                }
            }

            // Si no existe, agregar este pago como representativo del mes
            if (!mesExiste) {
                pagosPorMes.add(pago);
            }
        }

        return pagosPorMes;
    }

    public boolean existePagoEstudianteMes(int cedula, String mes, int anio) {
        for (PagosMensuales pago : listaPagosMensuales) {
            if (pago.getEstudiante() == cedula
                    && pago.getMes().equalsIgnoreCase(mes)
                    && pago.getFechaPago().getYear() == anio) {
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

    public double calcularTotalBeneficiosPlanilla(String mes, int anio) {
        double total = 0;
        ArrayList<PagosMensuales> pagos = obtenerPagosPorMesAnio(mes, anio);
        for (PagosMensuales pago : pagos) {
            total += pago.getTotalBeneficios();
        }
        return total;
    }

    public int contarEstudiantesPlanilla(String mes, int anio) {
        ArrayList<PagosMensuales> pagos = obtenerPagosPorMesAnio(mes, anio);
        return pagos.size(); // Un pago por estudiante en cada planilla
    }
}
