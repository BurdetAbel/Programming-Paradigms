

package Ejercicio6;

import java.awt.Color;
import javax.swing.JButton;

public class Pintor extends Thread {

    JButton b;
    Color paleta[] = new Color[5];

    public Pintor(JButton b) {
        this.b = b;
        paleta[0]=Color.YELLOW;
        paleta[1]=Color.RED;
        paleta[2]=Color.GREEN;
        paleta[3]=Color.BLUE;
        paleta[4]=Color.BLACK;
        start(); // arrancar hilo
    }

    public void run() {
        while (true) {
            try {
                // Pintar negro por un tiempo aleatorio entre 2 y 4 segundos
                b.setBackground(paleta[0-4]);
                int tiempoNegro = 2000 + (int)(Math.random() * 2000); // 2000–4000 ms
                Thread.sleep(tiempoNegro);

                // Pintar color al azar (rojo, verde, azul, amarillo) por 3–5 segundos
                //int indexColor = (int)(Math.random() * colores.length);
                int i = (int)(4. * Math.random());
                b.setBackground(paleta[i]);
                int tiempoColor = 3000 + (int)(Math.random() * 2000); // 3000–5000 ms
                Thread.sleep(tiempoColor);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
