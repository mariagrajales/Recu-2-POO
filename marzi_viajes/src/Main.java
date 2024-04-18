import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static private ArrayList<Reservacion> listaReservaciones = new ArrayList<>();
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        boolean ciclo=true;
        do{
            System.out.println("1.- Registra un nuevo viaje");
            System.out.println("2.- Ver el reporte general");
            System.out.println("3.- Ver los datos de un cliente");
            System.out.println("4.- Salir");
            int opcion = teclado.nextInt();
            switch (opcion){
                case 1:
                    validarDia();

                    break;

                case 2:
                    imprimirListaReservaciones();

                    break;

                case 3:
                    verDatosReservacion();
                    break;

                case 4:
                    ciclo=false;
                    System.out.println("Adios");
                    break;

                default:
                    System.out.println("Dato incorrecto");
                    break;

            }
        }while (ciclo);

    }


    static void validarDia(){
        int diaCompra;

        System.out.println("Porfavor ingrese el dia");
        diaCompra=teclado.nextInt();
        if (diaCompra <= 19 || diaCompra >= 31) {
            System.out.println("En este dia ya no esta la promocion disponible");
        } else {

            ingresarDatos(diaCompra);
        }

    }
    static void ingresarDatos(int diaCompra){
        int codigo;
        int cantidadPersonas;
        int diaViaje;
        int precioPaquete;
        int opcion;
        PaqueteTuristico paqueteT = null;

        System.out.println("Para que temporada realizara su viaje?");
        System.out.println("1.- Invierno     2.- Verano");
        int op = teclado.nextInt();
        if (op == 1) {

            System.out.println("Para la temporada de invierno ofrece las siguientes promociones:");
            System.out.println("Destino: Cancun     Precio: $4242   Periodo de promocion: 20-30 de noviembre    Periodo a viajar: 5-24 de Enero");
            System.out.println("Destino: Huatulco     Precio: $2402   Periodo de promocion: 20-30 de noviembre    Periodo a viajar: 5-24 de Enero");
            System.out.println("¿Cual deseas reservar? 1.Cancun 2.Huatulco");
        }else {
            System.out.println("Para la temporada de verano ofrece las siguientes promociones:");
            System.out.println("Destino: Cancun     Precio: $4842   Periodo de promocion: 20-30 de noviembre    Periodo a viajar: 5-24 de Enero");
            System.out.println("Destino: Huatulco     Precio: $3202   Periodo de promocion: 20-30 de febrero    Periodo a viajar: 5-24 de Enero");
            System.out.println("¿Cual deseas reservar? 1.Cancun 2.Huatulco");
        }
        opcion = teclado.nextInt();

        do {
            do {
                System.out.println("Ingrese su codigo de cliente/reserva (4 digitos)");
                codigo=teclado.nextInt();
                if (buscarCodigo(codigo)) {
                    System.out.println("Este codigo ya esta en uso");
                }
            } while (buscarCodigo(codigo));
        } while (codigo < 1000 || codigo > 9999 );


        System.out.println("Cantidad de personas que viajaran:");
        cantidadPersonas=teclado.nextInt();


        do {
            System.out.println("Los dias para realizar el viaje es del 5  al 24 de enero de 2024");
            System.out.println("Que dia va a viajar");
            diaViaje=teclado.nextInt();
        } while (diaViaje<4 || diaViaje>24);


        if (op==1) {

            if (opcion == 1) {
                precioPaquete = 4242;
                paqueteT = new PaqueteInvierno("Invierno","cancun",precioPaquete);
                //destino = new DestinoCancun(diaViaje, precioPaquete);



            } else {
                precioPaquete = 2402;
                paqueteT = new PaqueteInvierno("Invierno","Huatulco",precioPaquete);
                //destino = new DestinoHuatulco(diaViaje, precioPaquete);
            }
        }else {
            if (opcion == 1) {
                precioPaquete = 4842;
                paqueteT = new PaqueteVerano("Verano","cancun",precioPaquete);
                //destino = new DestinoCancun(diaViaje, precioPaquete);



            } else {
                precioPaquete = 3202;
                paqueteT = new PaqueteVerano("Verano","Huatulco",precioPaquete);
                //destino = new DestinoHuatulco(diaViaje, precioPaquete);
            }

        }

        int totalPagar= calcularPrecio(cantidadPersonas,precioPaquete);



        Reservacion reservacion = new Reservacion(codigo,cantidadPersonas,diaCompra,totalPagar,paqueteT);

        listaReservaciones.add(reservacion);

    }

    static int calcularPrecio(int cantidadPersonas, int precio){
        int totalPagar;
        totalPagar=cantidadPersonas*precio;
        return totalPagar;
    }

    public static boolean buscarCodigo(int codigoBuscado) {
        for (Reservacion reserva : listaReservaciones) {
            if (reserva.getCodigoReservacion() == codigoBuscado) {
                return true;
            }
        }
        return false;
    }


    static void imprimirListaReservaciones() {
        System.out.println("Lista de reservaciones:");
        for (Reservacion reserva : listaReservaciones) {
            System.out.println("Código de reserva: " + reserva.getCodigoReservacion());
            System.out.println("Cantidad de personas: " + reserva.getCantidadViajeros());
            System.out.println("Día de compra: " + reserva.getDiaCompra());
            System.out.println("Total a pagar: $" + reserva.getTotalPagar());
            System.out.println(reserva.getPaquete().toString());
            System.out.println("------------------------");
        }
    }
    static void verDatosReservacion() {
        System.out.println("Ingrese el codigo del viaje a buscar");
        int codigoBuscado= teclado.nextInt();
        for (Reservacion reserva : listaReservaciones) {
            if (reserva.getCodigoReservacion() == codigoBuscado) {
                System.out.println("Código de reserva: " + reserva.getCodigoReservacion());
                System.out.println("Cantidad de personas: " + reserva.getCantidadViajeros());
                System.out.println("Día de compra: " + reserva.getDiaCompra());
                System.out.println("Total a pagar: $" + reserva.getTotalPagar());
                System.out.println(reserva.getPaquete().toString());
                System.out.println("------------------------");
                return;
            }
        }
        System.out.println("No se encontró ninguna reservación con el código " + codigoBuscado);
    }





}