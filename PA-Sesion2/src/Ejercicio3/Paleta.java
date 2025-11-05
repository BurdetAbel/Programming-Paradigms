package Ejercicio3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.awt.Color;

public class Paleta {
    private final Lock lock;
    private final Color[] colores = new Color[4];   // Colores disponibles
    private final Color[] usados = new Color[4];    // Colores en uso (uno por bloque fijo)

    public Paleta() {
        this.lock = new ReentrantLock();
        colores[0] = Color.red;
        colores[1] = Color.blue;
        colores[2] = Color.green;
        colores[3] = Color.yellow;
    }

    
     // Devuelve un color aleatorio no usado y lo asigna al bloque indicado.
    
    public Color tomaColor(int bloqueId) {
        lock.lock();
        try {
            Color elegido;
            do {
                int i = (int) (Math.random() * colores.length);
                elegido = colores[i];
            } while (estaEnUso(elegido));

            usados[bloqueId] = elegido; // este bloque ocupa el color
            return elegido;
        } finally {
            lock.unlock();
        }
    }

    
     //Libera el color .
     
    public void liberarColor(int bloqueId) {
        lock.lock();
        try {
            usados[bloqueId] = null;
        } finally {
            lock.unlock();
        }
    }
    private boolean estaEnUso(Color c) {
        for (Color usado : usados) {
            if (c != null && c.equals(usado)) {
                return true;
            }
        }
        return false;
    }
}


            
            
            
        
    

