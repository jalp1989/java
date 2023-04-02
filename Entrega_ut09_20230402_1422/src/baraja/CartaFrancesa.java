package baraja;

import enumerados.PalosBarajaFrancesa;

/**
 * Clase CartaFrancesa
 *
 * @author Joseph
 */

public class CartaFrancesa extends Carta<PalosBarajaFrancesa> {

    public CartaFrancesa(int numero, PalosBarajaFrancesa palo) {
        super(numero, palo);
    }

    public CartaFrancesa() {
    }

    @Override
    public String toString() {

        String estado = "";
        String nombreFigura = "";

        switch (numero) {
            case 1:
                nombreFigura = "As";
                break;
            case 11:
                nombreFigura = "Jota";
                break;
            case 12:
                nombreFigura = "Reina";
                break;
            case 13:
                nombreFigura = "Rey";
                break;
            case 14:
                nombreFigura = "Joker 1";
                break;
            case 15:
                nombreFigura = "Joker 2";
                break;
            default:
                nombreFigura = numero + "";
        }

        estado = nombreFigura + " de " + palo;

        return estado;

    }

}
