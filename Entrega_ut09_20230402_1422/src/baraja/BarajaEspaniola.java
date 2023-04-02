package baraja;

import enumerados.PalosBarajaEspañola;


/**
 * Baraja Española
 * @author Joseph
 */
public class BarajaEspaniola extends Baraja<CartaEspaniola> {
    private boolean incluye_8_9;
    
    public BarajaEspaniola() {
        super();
        this.numCartasBaraja=48;
        this.numCartasPorPalo=12;
        
        crearBaraja(); //Creamos la baraja
        super.barajar(); // barajamos la baraja
    }
       
    public BarajaEspaniola(boolean incluye_8_9) {
        super();
        this.incluye_8_9=incluye_8_9;
        if (this.incluye_8_9){
            this.numCartasBaraja=48;
            this.numCartasPorPalo=12;
        }
        else{
            this.numCartasBaraja=40;
            this.numCartasPorPalo=10;
        }

        crearBaraja(); //Creamos la baraja
        super.barajar(); // barajamos la baraja
    }
    
    @Override
    public void crearBaraja(){

        PalosBarajaEspañola[] palos = PalosBarajaEspañola.values();

        //Recorro los palos, le quito el ultimo palo de tipo JOKER ya que no es un palo.
        for(int i = 0; i < palos.length-1; i++){
            //Recorro los numeros
            for (int j = 0; j < numCartasPorPalo; j++){
                if (this.incluye_8_9){
                    this.cartasDentroBaraja.add(new CartaEspaniola(j + 1, palos[i]));
                } else {
                    //Las posiciones del 8 y del 9 son el 7 y el 8 (emepzamos en 8)
                    if (j >= 7){
                        //Solo para la sota, caballo y rey
                         this.cartasDentroBaraja.add(new CartaEspaniola(j + 3, palos[i]));
                    } else {
                        //Para los casos de 1 a 7
                         this.cartasDentroBaraja.add(new CartaEspaniola(j + 1, palos[i]));
                    }
                }
            }
        }
    }
       

}
