package baraja;

import java.util.Collections;
import java.util.ArrayList;


/**
 * Clase Baraja
 *
 * @author Joseph
 * @param <T>
 * Se cambia la coleccion de linkedlist a ArrayList para poder usar el metodo shuffle
 */
public abstract class Baraja<T extends Carta> {

    //Atributos
    protected ArrayList<T> cartasDentroBaraja;
    protected ArrayList<T> cartasFueraBaraja;
    //La Mano pertenece al juego por lo tanto tendre que implementar una clase abstracta juego
    //protected ArrayList<T> cartasMano;
    protected int numCartasBaraja;
    protected int numCartasPorPalo;

    public Baraja() {
        this.cartasDentroBaraja = new ArrayList<>();
        this.cartasFueraBaraja = new ArrayList<>();
        this.numCartasBaraja = 0;
        this.numCartasPorPalo = 0;
    }
    
    public Baraja(int numCartasBaraja, int numCartasPorPalo) {
        this.cartasDentroBaraja = new ArrayList<>();
        this.cartasFueraBaraja = new ArrayList<>();
        this.numCartasBaraja = numCartasBaraja;
        this.numCartasPorPalo = numCartasPorPalo;
    }

    /**
     * Metodo abstracto crearBaraja
     * ¿En vez de declararlo como abstracto y tener implementarlo en la subclase
     * podriaa declarar un metodo generico que cree la bajara?
     * La respuesta es que en la forma de crear una baraja tradicional
     * es algo que se hace de la misma forma. Sin embargo si alguien
     * crea una baraja nueva y sus cartas lleva otra distribucion habria
     * que modificar este metodo y readaptarlo, es por ello que se prefiere 
     * declarar como abstracto
     */
    public abstract void crearBaraja();

    
    /**
     * Baraja todas las cartas
     */
    public void barajar(){
    Collections.shuffle(cartasDentroBaraja);
    }
    
    /**
     * Saca de la baraja un numero de cartas determinado
     * se empieza sacando las cartas desde arriba la carta de mas arriba
     * hacia la carta de mas abajo
     *
     * @param numCartas
     * @return 
     */
    public Carta[] sacarCartas(int numCartas){
        if (numCartas > this.numCartasBaraja) {
            System.out.println("No se puede dar mas cartas de las que hay");
        } else if (cartasDisponible() < numCartas) {
            System.out.println("No hay suficientes cartas que mostrar");
        } else {
//          Se va crear un array de numCartas cuadrados o variables
            Carta[] cartasSacadas=new Carta[numCartas]; 
//          length devuelve el numero de elementos que posee el array, habria que restar uno sin embargo
//          el < hace que no se evalue en ese limite 
//          en este caso numCartas = length
            for(int i = 0; i < cartasSacadas.length; i++){
//              Primero copiamos la carta sacada de la baraja en cartas sacadas y cartas fuera de baraja
//              size() me devuelve el numero de elementos de la coleccion. Sin embargo se empieza de cero
//              por lo tanto hay que restart 1.
                cartasSacadas[i]= cartasDentroBaraja.get(this.cartasDentroBaraja.size()-1);
                this.cartasFueraBaraja.add(cartasDentroBaraja.get(this.cartasDentroBaraja.size()-1));
                
                //Luego eliminamos la carta de la baraja
                //Se supone que cuando eleminamos y volvemos a llamar a size() nos devolver el valor restado -1
                this.cartasDentroBaraja.remove(this.cartasDentroBaraja.size()-1);
            }
            return cartasSacadas;
        }
        //solo en caso de error
        return null;
    }
    
    /**
     * Guarda en la baraja todas las cartas que estaban fuera
     * Para ello se utiliza la coleccion o ArrayList de cartasFueraBaraja
     * y las metemos en CartasDentroBaraja.
     */
    public void guardarCartas(){
        //Las cartas de fuera la guardamos en baraja
        this.cartasDentroBaraja.addAll(cartasFueraBaraja);
        //Las cartas de fuera de la baraja se deben borrar
        this.cartasFueraBaraja.clear();
    }
    
    /**
     * Indica el numero de cartas que hay disponibles
     *
     * @return
     */
    public int cartasDisponible() {
        return this.cartasDentroBaraja.size();
    }

    /**
     * Muestro las cartas que aun no han salido
     */
    public void mostrarCartasDentroBaraja() {
        if (cartasDentroBaraja.isEmpty()) {
            System.out.println("No hay cartas que mostrar");
        } else {
            for (Carta a: cartasDentroBaraja){
            System.out.println(a);
            }
        }
    }
    
    /**
     * Muestro las cartas que ya han salido
     */
    public void mostrarCartasFueraBaraja() {
        if (cartasDentroBaraja.size() == numCartasBaraja) {
            System.out.println("No se ha sacado ninguna carta");
        } else {
            for(Carta b:cartasFueraBaraja){
            System.out.println(b);
            }
        }
    }

}
