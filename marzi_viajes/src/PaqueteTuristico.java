public class PaqueteTuristico {
    private String temporada;
    private String destino;
    private float precio;


    public PaqueteTuristico(String temporada, String destino, float precio) {
        this.temporada = temporada;
        this.destino = destino;
        this.precio = precio;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }


    @Override
    public String toString() {
        return "PaqueteTuristico{" + "temporada='" + temporada  + ", destino='" + destino +'}';
    }
}
