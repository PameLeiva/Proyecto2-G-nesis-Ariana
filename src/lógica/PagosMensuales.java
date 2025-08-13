
package lógica;

import java.time.LocalDate;

/**
 *
 * @author Génesis Leiva
 * @author Ariana Araya
 */
public class PagosMensuales {
   private int idPago;
   private LocalDate fechCreacion;
   private String mes;
   private LocalDate fechaPago;
   private int estudiante;
   private double totalBeneficios;
   private double deducSeguro;
   private double deducRenta;
   private double pagoNeto;

    public PagosMensuales() {
        this.idPago = 0;
        this.fechCreacion = null;
        this.mes = "";
        this.fechaPago = null;
        this.estudiante = 0;
        this.totalBeneficios = 0;
        this.deducSeguro = 0;
        this.deducRenta = 0;
        this.pagoNeto = 0;
    }

    public PagosMensuales(int idPago, LocalDate fechCreacion, String mes, LocalDate fechaPago, int estudiante, double totalBeneficios, double deducSeguro, double deducRenta, double pagoNeto) {
        this.idPago = idPago;
        this.fechCreacion = fechCreacion;
        this.mes = mes;
        this.fechaPago = fechaPago;
        this.estudiante = estudiante;
        this.totalBeneficios = totalBeneficios;
        this.deducSeguro = deducSeguro;
        this.deducRenta = deducRenta;
        this.pagoNeto = pagoNeto;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public LocalDate getFechCreacion() {
        return fechCreacion;
    }

    public void setFechCreacion(LocalDate fechCreacion) {
        this.fechCreacion = fechCreacion;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

    public int getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(int estudiante) {
        this.estudiante = estudiante;
    }

    public double getTotalBeneficios() {
        return totalBeneficios;
    }

    public void setTotalBeneficios(double totalBeneficios) {
        this.totalBeneficios = totalBeneficios;
    }

    public double getDeducSeguro() {
        return deducSeguro;
    }

    public void setDeducSeguro(double deducSeguro) {
        this.deducSeguro = deducSeguro;
    }

    public double getDeducRenta() {
        return deducRenta;
    }

    public void setDeducRenta(double deducRenta) {
        this.deducRenta = deducRenta;
    }

    public double getPagoNeto() {
        return pagoNeto;
    }

    public void setPagoNeto(double pagoNeto) {
        this.pagoNeto = pagoNeto;
    }
           
           
}
