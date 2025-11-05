package Ejercicio3;

import java.awt.Color;
import javax.swing.JButton;

public class Pintor extends Thread {    
    private JButton b;
    private Paleta p;
    private int bloqueId;         // identificador único para este bloque
    private Color actual = null;  // color actual que usa el bloque
    private final Color negro = Color.black;
    
    public Pintor(JButton b, Paleta p, int bloqueId) {
        this.b = b;
        this.p = p;
        this.bloqueId = bloqueId;
    }
    
    @Override
    public void run() {
        while (true) {
            long tiempoEnNegro = (long) (2000 + (2000 * Math.random())); // 2 a 4 seg
            long tiempoEnColor = (long) (3000 + (2000 * Math.random())); // 3 a 5 seg
            
            // Vuelve a negro y libera el color anterior
            b.setBackground(negro);
            if (actual != null) {
                p.liberarColor(bloqueId);
                actual = null;
            }
            try {
                sleep(tiempoEnNegro);
            } catch (InterruptedException e) {}
            
            // Escoge un nuevo color y lo pinta
            actual = p.tomaColor(bloqueId);
            b.setBackground(actual);
            try {
                sleep(tiempoEnColor);
            } catch (InterruptedException e) {}
        }
    }
}
