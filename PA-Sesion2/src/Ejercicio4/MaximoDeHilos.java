
package Ejercicio4;
/**
 *
 * @author crist
 */
public class MaximoDeHilos {

    // Clase interna similar a tus hilos anteriores
    static class HiloPrueba extends Thread {
        @Override
        public void run() {
            try {
                // El hilo se queda durmiendo indefinidamente
                while (true) {
                    sleep(1000);
                }
            } catch (InterruptedException e) {
                // Ignorar, no vamos a interrumpir hilos
            }
        }
    }

    public static void main(String[] args) {
        int contador = 0;
        try {
            while (true) {
                HiloPrueba h = new HiloPrueba();
                h.start();
                contador++;
                if (contador % 100 == 0) {
                    System.out.println("Hilos creados: " + contador);
                }
            }
        } catch (OutOfMemoryError e) {
            System.out.println("Se alcanzó el límite en: " + contador + " hilos");
            e.printStackTrace();
        }
    }
}

