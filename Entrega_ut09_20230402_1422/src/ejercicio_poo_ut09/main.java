package ejercicio_poo_ut09;

import java.util.Scanner;
import baraja.Baraja;
import baraja.BarajaEspaniola;
import baraja.BarajaFrancesa;
import baraja.Carta;

public class main {

    public static void main(String[] args) {
        // Parametros de configuracion del proyecto
        // Los argumentos se guardan en en el array args de tipo string por lo tanto hay que hacer un cast int
//        System.out.println("Los argumentos son:");
//        for (int z = 0; z < args.length; z++) {
//            if (z<args.length-1){
//                System.out.print(args[z]+",");
//            }
//            else if (z==args.length-1){
//                System.out.print(args[z]);
//            }
//        }
        
        System.out.println();
        
        int numJugadores=0;        
        int numCartasPorJugador=0;
        int seleccionBaraja=0;

        if(args.length==3){
            // Configuracion del juego atraves del teclado
            Scanner lectura = new Scanner (System.in);
            System.out.println("Ingrese el numero de jugadores: ");
            args[0] = lectura.next();
            System.out.println("Ingrese el numero de cartas por jugador: ");
            args[1] = lectura.next();
            System.out.println("Seleccione la baraja 0=Espaniola, 1=Francesa: ");
            args[2] = lectura.next();
            
            // Numero de jugadores (hasta 4 jugadores)
            numJugadores=Integer.parseInt(args[0]);
        
            // Numero de cartas por jugador (hasta diez cartas por jugador)
            numCartasPorJugador=Integer.parseInt(args[1]);
        
            // Seleccion de Baraja (0 española, 1 francesa)
            seleccionBaraja=Integer.parseInt(args[2]);
        } 
        else if((args.length==0)||(args.length>3)){
            numJugadores = 4;
            numCartasPorJugador = 4;
            seleccionBaraja = 0;
        }
         
        // Arreglamos para que segun el parametro int de la seleccion de baraja imprima Espaniola o francesa
        String baraja="";
        
        switch(seleccionBaraja){
            case 0:
                baraja="Espaniola";
                break;
            case 1:
                baraja="Francesa";
                break;
            default:               
        }
        
        // Arreglamos para segun la configuracion seleccionada me indique el tipo de juego seleccionado
        String tipoJuego="";
        
        switch(numJugadores+numCartasPorJugador+seleccionBaraja){
            case 8:
                tipoJuego="Mus";
                break;
            case 10:
                tipoJuego="Pocker";
                break;
            case 14:
                tipoJuego="Tute";
                break;
            default:
        }
        
        //Mostramos la configuracion
        System.out.println("Se ha seleccionado: ");   
        
        System.out.println(numJugadores+" jugadores."+numCartasPorJugador+" cartas por jugador."+"Baraja "+baraja+"."+"Combinacion tipica del "+tipoJuego+".");
        
        System.out.println("--------------------------------------------------------------------------");   
        
        //Inicializamos una referencia a clase madre Baraja para poder apuntar
        // a sus hijas
        Baraja b;
        
        //Creamos la baraja
        switch(seleccionBaraja){
            case 0:
                b = new BarajaEspaniola(false);
                break;
            case 1:
                if (numCartasPorJugador==5){
                b = new BarajaFrancesa(true);
                } else{
                b = new BarajaFrancesa(false);
                }
                break;
            default:  
                b = null;
        }
        
        //Mostramos el numero de cartas disponibles en la baraja (40)
        System.out.println("Hay " + b.cartasDisponible() + " cartas disponibles en la baraja");
        
        //Barajamos
        b.barajar();
        
        //Reparticion de cartas para todos los jugadores
        Carta[] c;
        
        for (int x=0;x<numJugadores;x++){
            //Saco las cartas para un jugador
            c=b.sacarCartas(numCartasPorJugador);
            //Mostramos las cartas para un jugador
            for (int i = 0; i < c.length; i++) {
                if (i==0){
                    System.out.print("["+c[i]+", ");
                }
                else if ((i>0)&&(i<c.length-1)){
                    System.out.print(c[i]+", ");
                } 
                else if(i==c.length-1){
                    System.out.print(c[i]+"]");
                }                
            }
            System.out.println();
        }
        
        //Mostramos el numero de cartas cartas disponibles en la baraja despues de repartir
        System.out.println("Quedan " + b.cartasDisponible() + " cartas disponibles en la baraja");
        
        System.out.println("--------------------------------------------------------------------------");
        
        //Mostramos las cartas que quedan dentro de la baraja
        //System.out.println("Cartas que quedan dentro de la baraja:");
        //b.mostrarCartasDentroBaraja();
        
    }

}
