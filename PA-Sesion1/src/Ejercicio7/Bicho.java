// Escribir una clase Bicho que herede de Thread y que trate de representar un organismo vivo. Su funcionamiento es el siguiente: cuando se
// crea un nuevo bicho, se le pasan dos parámetros: la generación a la que pertenece y un nombre formado por cuatro letras al azar. Cada
// bicho:
//a) escribe un mensaje en la pantalla, indicando “NACE: “, su nombre y generación a la que pertenece;
//b) espera un tiempo aleatorio entre 0,5 y 1 segundos;
//c) crea un nuevo bicho hijo (de la siguiente generación) y le pone nombre;
//d) espera a que su hijo termine (muera) y
//e) escribe en la pantalla un mensaje indicando “MUERE: “, su nombre, generación y tiempo en milisegundos que ha durado su vida.
//Los bichos de la quinta generación son estériles y no pueden tener hijos. Escribir un programa que cree un primer bicho de la primera
//generación, de nombre ADAN y lo lance al mundo.

package Ejercicio7;

/**
 *
 * @author crist
 */
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;

public class Bicho extends Thread {

    private int generacion;
    private String nombre;
    private static final String LETRAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    
    public Bicho(int generacion) {
        this.generacion = generacion;
        
        if (generacion == 1) {
            this.nombre = "ADAN";  // El de primera generación será ADAN
        }   
        else {
            this.nombre = generarNombre();
             }
        }
    
    
    
    private String generarNombre() {
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append(LETRAS.charAt(rnd.nextInt(LETRAS.length())));
        }
        return sb.toString();
    }
    @Override
    public void run() {
        try {
            System.out.println("NACE " + nombre + " de generacion" + generacion);

            // Si no es la última generación, crea el siguiente
            if (generacion < 5) {
                Bicho hijo = new Bicho(generacion + 1); //RECURSIVIDAD no muere ninguno hasta llegar a la 5 generación
                hijo.start();                           // Luego empiezan a morir de forma recursiva
                hijo.join();    
                
            }
            // espera entre 0.5 y 1 segundo
                long espera = ThreadLocalRandom.current().nextLong(500, 1001); // 500..1000 ms
                Thread.sleep(espera);
            System.out.println("Muere bicho de generación " + generacion +
                               " (vivio " + espera + " ms)");// espera a que el hijo muera
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    

    public String getNombre() {
        return nombre;
    }

    public int getGeneracion() {
        return generacion;
    }
}
