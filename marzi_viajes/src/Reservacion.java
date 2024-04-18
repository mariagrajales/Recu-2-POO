public class Reservacion {
    private int codigoReservacion;
    private int cantidadViajeros;
    private int diaCompra;
    private int totalPagar;
    private PaqueteTuristico paquete;


    public Reservacion(int codigoReservacion, int cantidadViajeros, int diaCompra, int totalPagar, PaqueteTuristico paquete) {
        this.codigoReservacion = codigoReservacion;
        this.cantidadViajeros = cantidadViajeros;
        this.diaCompra = diaCompra;
        this.totalPagar = totalPagar;
        this.paquete = paquete;
    }

    public int getCodigoReservacion() {
        return codigoReservacion;
    }

    public void setCodigoReservacion(int codigoReservacion) {
        this.codigoReservacion = codigoReservacion;
    }

    public int getCantidadViajeros() {
        return cantidadViajeros;
    }

    public void setCantidadViajeros(int cantidadViajeros) {
        this.cantidadViajeros = cantidadViajeros;
    }

    public int getDiaCompra() {
        return diaCompra;
    }

    public void setDiaCompra(int diaCompra) {
        this.diaCompra = diaCompra;
    }

    public int getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(int totalPagar) {
        this.totalPagar = totalPagar;
    }

    public PaqueteTuristico getPaquete() {
        return paquete;
    }

    public void setPaquete(PaqueteTuristico paquete) {
        this.paquete = paquete;
    }
}
