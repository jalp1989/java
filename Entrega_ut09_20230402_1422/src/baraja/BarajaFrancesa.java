package baraja;

import enumerados.PalosBarajaFrancesa;

/**
 * Baraja francesa
 * @author Joseph
 */
public class BarajaFrancesa extends Baraja<CartaFrancesa> {
    private boolean poker;
    
    public BarajaFrancesa(boolean poker) {
        super();
        this.numCartasBaraja=52;
        this.numCartasPorPalo=13;
        
        this.poker=poker;
        
        crearBaraja(); //Creamos la baraja
        super.barajar(); // barajamos la baraja
    }

    @Override
    public void crearBaraja(){
        //Pasamos el enum de palo a una array
        PalosBarajaFrancesa[] palos = PalosBarajaFrancesa.values();
        
        //Recorro los palos, le quito el ultimo palo de tipo JOKER ya que no es un palo.
        for(int i = 0; i < palos.length-1; i++){
            //Recorro los numeros
            for(int j = 0; j < numCartasPorPalo; j++){
                this.cartasDentroBaraja.add(new CartaFrancesa(j + 1, palos[i]));
            }
        }
        //Si es poker añadimos los dos comodines a la baraja.
        boolean poker=this.poker;
        
        if (poker){
            this.cartasDentroBaraja.add(this.cartasDentroBaraja.size()-1,new CartaFrancesa(14, palos[palos.length-1]));
            this.cartasDentroBaraja.add(this.cartasDentroBaraja.size()-1,new CartaFrancesa(15, palos[palos.length-1]));
        } else{
           // this.cartasDentroBaraja.remove(this.cartasDentroBaraja.size()-1);
           // this.cartasDentroBaraja.remove(this.cartasDentroBaraja.size()-1);
        }
        
        
    }

//    public boolean cartaRoja(Carta<PalosBarajaFrancesa> c) {
//        return c.getPalo() == PalosBarajaFrancesa.CORAZONES || c.getPalo() == PalosBarajaFrancesa.DIAMANTES;
//    }
//
//    public boolean cartaNegra(Carta<PalosBarajaFrancesa> c) {
//        return c.getPalo() == PalosBarajaFrancesa.TREBOLES || c.getPalo() == PalosBarajaFrancesa.PICAS;
//    }

}
