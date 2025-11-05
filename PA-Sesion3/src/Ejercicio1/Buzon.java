/*
 * La clase Buzon tiene que estar protegida con un cerrojo
 * El método enviaMensaje debe esperar si el buzón está lleno
 * El método recibeMensaje debe esperar si el buzón está vacío.
 * Cuando un hilo completa su operación, desbloquea a los que estén esperando
 * para que puedan continuar intentando su acción.
 */

//OBJETO COMPARTIDO 

package Ejercicio1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Buzon {
    
    private final Lock lock = new ReentrantLock();
    private String mensaje;
    private boolean hayMensaje = false;
    private final Condition lleno = lock.newCondition(); 
    private final Condition vacio = lock.newCondition(); 
    
    public void enviaMensaje(String msg) {
        lock.lock();
        try {
            
            while (hayMensaje) { //  Hay mensajes? FALSE pues esperaHay mensajes !false = TRUE pues espera  a que se envie alguno
                lleno.await();
            }
            // Depositar mensaje
            hayMensaje = true;
            mensaje = msg;
            vacio.signal(); // despertamos al que puede enviarlos
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    public String recibeMensaje() {   
        lock.lock();
        try {
            while (!hayMensaje) { // Hay mensajes !false = TRUE pues espera  a que se envie alguno
                vacio.await();
            }
            hayMensaje = false;
            lleno.signal();
            return mensaje;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null; 
        } finally {
            lock.unlock();
        }
    }
}   

